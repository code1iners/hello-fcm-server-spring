package hello.api.fcm.service.fcm;

import com.google.firebase.messaging.FirebaseMessagingException;
import hello.api.fcm.dto.fcm.FcmMessageDto;

import java.util.Map;


public interface FcmService {

    /**
     * Send message.
     */
    String send(FcmMessageDto fcmMessageDto, String kind) throws FirebaseMessagingException;
}
