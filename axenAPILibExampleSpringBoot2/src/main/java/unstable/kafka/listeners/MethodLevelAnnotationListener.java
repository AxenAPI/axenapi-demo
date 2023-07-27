package unstable.kafka.listeners;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MethodLevelAnnotationListener {
    @KafkaListener(topics = "multiType, info", groupId = "group-3")
    public void handleObject(List<Object> o) {
        System.out.println("group-3 >> Object received: " + o);
    }
}
