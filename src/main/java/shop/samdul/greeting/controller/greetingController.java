package shop.samdul.greeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class greetingController {
    ArrayList<String> remember = new ArrayList<String>();

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue = "Hi")
            String name,
            Model model
    ) {
        remember.add(name);

        model.addAttribute("name", name);
        model.addAttribute("history", remember);

        return "greeting";
    }
}
