package guru.springframework.controllers;

import guru.springframework.commands.LoginCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginShow(Model model) {
        model.addAttribute("loginCommand", new LoginCommand());

        return "login-form";
    }

    @PostMapping("/login")
    public String loginSave(@Valid LoginCommand loginCommand, BindingResult result) {
        if(result.hasErrors()) {
            return "login-form";
        }

        return "redirect:/";
    }
}
