package com.dchalbyshev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")  // выход через /first во всех методах
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name",required = false)
                                        String name, @RequestParam(value = "surname",
            required = false) String  surname, Model model) {
    // Spring за нас выбирает значение по указанному ключу  и присваивает его аргументу(магия Spring)
    // required = false если не определить это значение то
    // в случае непередачи указанный параметров в запросе пол
    //учим ОШИБКУ
        model.addAttribute("message",name + "  "  + surname);
      //  System.out.println(name + "  "  + surname);
        return "first/hello";}



   /* @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
       //  HttpServletRequest request содержит все сведения о  HTTP запросе
       String name = request.getParameter("name");
       //  в скобках указываем ключ
       String surname = request.getParameter("surname");
        System.out.println(name + "  "  + surname);
        return "first/hello";
    }*/

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}




