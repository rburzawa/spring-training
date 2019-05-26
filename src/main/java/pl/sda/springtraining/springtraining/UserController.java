package pl.sda.springtraining.springtraining;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {


    @GetMapping(value = "/register")
    public String showForm (Model model){
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        model.addAttribute("userDTO", userRegistrationDTO);
        model.addAttribute("countries", Countries.values());
        return "registerForm";
    }

    @PostMapping(value = "/register")
    public String register(@ModelAttribute(name = "userDTO") @Valid UserRegistrationDTO userDTO, BindingResult result, Model model){
        if (result.hasErrors()){
            return "/registerForm";
        }
        return "/index";
    }

}
