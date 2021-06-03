package hello.api.fcm.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import hello.api.fcm.dto.fcm.FcmMessageDto;
import hello.api.fcm.dto.fcm.FcmTargetOs;
import hello.api.fcm.service.fcm.FcmServiceAndroid;
import hello.api.fcm.service.fcm.FcmServiceIos;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

import static hello.api.fcm.dto.fcm.FcmTargetOs.ANDROID;
import static hello.api.fcm.dto.fcm.FcmTargetOs.IOS;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FcmController {

    private final FcmServiceAndroid fcmServiceAndroid;
    private final FcmServiceIos fcmServiceIos;

    /**
     * <h3>Send.</h3>
     * <p>Send Firebase Cloud Message.</p>
     */
    @PostMapping(value = "/push/send")
    public Map<String, String> send(
            @RequestBody FcmMessageDto fcmMessageDto,
            @RequestParam String kind) throws FirebaseMessagingException {
        HashMap<String, String> result = new HashMap<>();
        result.put(ANDROID.name(), fcmServiceAndroid.send(fcmMessageDto, kind));
        result.put(IOS.name(), fcmServiceIos.send(fcmMessageDto, kind));

        return result;
    }
}
