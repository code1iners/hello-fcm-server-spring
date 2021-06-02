package hello.api.fcm.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import hello.api.fcm.dto.Note;
import hello.api.fcm.service.FcmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FcmController {

    private final FcmService fcmService;

    @PostMapping(value = "/push/send")
    public String send(
            @RequestBody Note note,
            @RequestParam String topic
                       ) throws FirebaseMessagingException {
        return fcmService.send(note, topic);
    }

}
