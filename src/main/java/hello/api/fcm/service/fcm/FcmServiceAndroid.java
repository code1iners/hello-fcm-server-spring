package hello.api.fcm.service.fcm;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import hello.api.fcm.dto.fcm.FcmMessageDto;
import hello.api.fcm.dto.fcm.FcmTargetType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static hello.api.fcm.dto.fcm.FcmTargetType.TOKEN;
import static hello.api.fcm.dto.fcm.FcmTargetType.TOPIC;

@Service
@Slf4j
@RequiredArgsConstructor
public class FcmServiceAndroid implements FcmService {

    private final FirebaseMessaging firebaseMessaging;

    @Override
    public String send(FcmMessageDto fcmMessageDto, String kind) throws FirebaseMessagingException {
        FcmTargetType targetType = (kind.equals("token")) ? TOKEN : TOPIC;
        Message message = FcmMessageDto.createMessageByDto(fcmMessageDto, targetType);
        return firebaseMessaging.send(message);
    }
}
