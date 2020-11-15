package ru.mail.migus_nikita.dealerstat.controller;

import javax.servlet.http.HttpServletRequest;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.migus_nikita.dealerstat.dto.LoginDto;
import ru.mail.migus_nikita.dealerstat.model.User;
import ru.mail.migus_nikita.dealerstat.service.CryptoService;
import ru.mail.migus_nikita.dealerstat.service.UserService;

@RestController
public class LoginController {

    private final UserService userService;
    private final CryptoService cryptoService;

    @Autowired
    public LoginController(UserService userService, CryptoService cryptoService) {
        this.userService = userService;
        this.cryptoService = cryptoService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void login(LoginDto loginDto, HttpServletRequest request) throws NotFoundException {

        if (loginDto == null || loginDto.getPassword() == null || loginDto.getEmail() == null) {
            throw new NotFoundException("password or email is empty");
        }
        User user = userService.findByUserName(loginDto.getEmail());
        if (user == null) {
            throw new NotFoundException("user with given email is not exists");
        }

        String password = cryptoService.decrypt(user.getPassword());
        String email = user.getEmail();

        if (!password.equals(loginDto.getPassword()) && !email.equals(loginDto.getEmail())) {
            throw new NotFoundException("user with given email is not exists");
        }

        request.getSession().setAttribute("login", "successful");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(HttpServletRequest request) {
        request.getSession().invalidate();
    }

}
