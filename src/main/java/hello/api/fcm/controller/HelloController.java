package hello.api.fcm.controller;

import com.google.firebase.FirebaseApp;
import hello.api.fcm.service.FcmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {


        return "ok";
    }
}
