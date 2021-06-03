package hello.api.fcm.dto.fcm;

import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class FcmMessageDto {

    private String title;
    private String content;
    private Map<String, String> data;
    private String image;
    private String target;

    public static Message createMessageByDto(FcmMessageDto messageDto, FcmTargetType targetType) {
        Notification notification = Notification
                .builder()
                .setTitle(messageDto.getTitle())
                .setBody(messageDto.getContent())
                .setImage(messageDto.getImage())
                .build();

        Message.Builder messageBuilder = Message
                .builder()
                .setNotification(notification)
                .putAllData(messageDto.getData());

        if (targetType == FcmTargetType.TOKEN) {
            messageBuilder.setToken(messageDto.getTarget());
        } else {
            messageBuilder.setTopic(messageDto.getTarget());
        }

        return messageBuilder.build();
    }
}
