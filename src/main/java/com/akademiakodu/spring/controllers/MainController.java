package com.akademiakodu.spring.controllers;

import com.akademiakodu.spring.models.Person;
import com.akademiakodu.spring.models.SimpleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


/**
 * Created by Lukasz Kolacz on 27.05.2017.
 */

@Controller
public class MainController {

    //    Odwołanie do naszego SimpleBeana (wstrzyknięcie):
    @Autowired
    SimpleBean simpleBean;
//      -----------------------------------------

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {

        ZonedDateTime now = LocalDateTime.now().atZone(ZoneId.of("Europe/Paris"));

        System.out.println("Time now: " + now.toString());

        if (now.getHour() >= 16) {
            model.addAttribute("someString", "a");
        } else {
            model.addAttribute("someString", "b");
        }


//        model.addAttribute("someString", "Pochodzę z controllera!");
        return "index";
    }

    //      Pobieranie danych z formularza:
//          (for firstIndex.html)
//    @RequestMapping(value = "/data", method = RequestMethod.POST)
//    @ResponseBody
//    public String data(@RequestParam(value = "name") String name,
//                       @RequestParam(value = "lastname") String lastname,
//                       @RequestParam(value = "age", required = false) int age){
//        return name + " " + lastname + " jest " + ((age>18) ? "pelnoletni" : "niepelnoletni");
//    }
//    --------------------------------------------------------------
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    public String data(@RequestParam(value = "email") String email,
                       @RequestParam(value = "password") String password) {


        return "Logowanie testowe: " + "Email: " + email + " Password: " + password;
    }

//    INNE PODEJSCIE DO (dużych) FORMULARZY:

    @RequestMapping(value = "/newform", method = RequestMethod.GET)
    public String newform(Model model) {
        model.addAttribute("personObject", new Person());
        return "form";
    }

    @RequestMapping(value = "/newform", method = RequestMethod.POST)
    @ResponseBody
    public String newFormPost(Person person){

    return "Przyszla klasa: " + person.getName() +" " + person.getLastname() + " " + person.getEmail();
    }

//    ---------------------------------------------------------------------------------------------------------






//    Testujemy jak dziala wzorzec builder
//    nie ma wplywu na dzialanie springa
//    private void testBuilder() {
//        Person person = new Person.Builder("Oskar")
//                .lastname("Polak")
//                .age(27)
//                .number("787-234-123")
//                .email("costam@gmail.com")
//                .build();
//        person.getAge();
//    }
}