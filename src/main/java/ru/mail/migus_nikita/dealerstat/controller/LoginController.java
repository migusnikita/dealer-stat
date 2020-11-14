package ru.mail.migus_nikita.dealerstat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.mail.migus_nikita.dealerstat.service.UserService;

@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            @RequestParam(value = "activationCode", required = false) boolean activation,
            @RequestParam(value = "resetPassword", required = false) boolean resetPassword) {
        ModelAndView modelAndView = new ModelAndView();
        String message = null;

        if (error != null) {
            message = "Username or Password is incorrect";
        }
        if (logout != null) {
            message = "Logged out successfully";
        }
        if (activation) {
            message = "Submit your email";
        }else {
            message = "Email is submitted";
        }

        if ("true".equals(resetPassword)) {
            message = "Submit resetting password on email";
        }
        if ("false".equals(resetPassword)) {
            message = "Password has been reset";
        }

        modelAndView.setViewName("login");
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}
