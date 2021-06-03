package hello.api.fcm.service.fcm;

import com.google.firebase.messaging.FirebaseMessagingException;
import hello.api.fcm.dto.fcm.FcmMessageDto;
import org.springframework.stereotype.Service;

@Service
public class FcmServiceIos implements FcmService{

    @Override
    public String send(FcmMessageDto fcmMessageDto, String kind) throws FirebaseMessagingException {
        return null;
    }
}
