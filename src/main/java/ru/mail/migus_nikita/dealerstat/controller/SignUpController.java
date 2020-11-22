package ru.mail.migus_nikita.dealerstat.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.migus_nikita.dealerstat.dto.UserDto;
import ru.mail.migus_nikita.dealerstat.service.UserService;

@RestController
public class SignUpController {

    private final RedisTemplate<String, String> redisTemplateService;
    private final JavaMailSender mailService;
    private final UserService userService;

    @Autowired
    public SignUpController(UserService userService,
            RedisTemplate<String, String> redisTemplateService,
            JavaMailSender mailService) {
        this.redisTemplateService = redisTemplateService;
        this.mailService = mailService;
        this.userService = userService;
    }

    @PostMapping(value = "/signUp")
    public void registration(UserDto dto) throws NotFoundException {

        userService.addUser(dto);

        SimpleMailMessage message = new SimpleMailMessage();

        int hashCode = dto.getEmail().hashCode();
        String msg = String.format("<a href=\"%s\">confirm email</a>", "localhost:8080/confirm/" + dto.getEmail() + "/" + hashCode);

        redisTemplateService.opsForValue().set(dto.getEmail(), String.valueOf(hashCode));

        message.setText(msg);
        message.setTo(dto.getEmail());
        mailService.send(message);
    }

    @PostMapping(value = "/confirm/{email}/{hashCode}")
    public void confirmLinkFromEmail(@PathVariable String hashCode, @PathVariable String email) {

        String fromRedis = redisTemplateService.opsForValue().get(email);

        if (hashCode.equals(fromRedis)) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setText("your account confirmed");
            mailService.send(message);
        }

    }

}
