package com.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/signup")
    public String signup(Model model) {

        model.addAttribute(new SignUpForm());

        return "account/signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@Valid SignUpForm signUpForm) {

        accountService.newSign(signUpForm);

        return "account/signup";
    }

    @ResponseBody
    @GetMapping("/checkEmail/{email}")
    public HashMap<String, String> checkEmail(@PathVariable String email) {
        HashMap<String, String> msg = new HashMap<String, String>();
        msg.put("message", "fail");
        return msg;
    }
}
