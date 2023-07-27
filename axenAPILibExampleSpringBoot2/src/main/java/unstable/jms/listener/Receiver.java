package unstable.jms.listener;


import swagger4kafka.model.Chief;
import com.example.demo.kafka.model.Subordinate;
import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.JmsHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Receiver {
    // явное указание фабрики контейнеров
    @JmsListener(destination = "chiefs", containerFactory = "listenerContainerFactory")
    public void receiveChief(Chief chief) {
        System.out.println("Chief received: " + chief);
    }

    // Валидация payload + чтение всех заголовков через MessageHeaders
    //@SendTo //аннотация над методом, возвращающем void вызовет IllegalStateException
    @JmsListener(destination = "chiefs")
    public void receiveChief(@Payload Chief chief, MessageHeaders headers) {
        System.out.println("Chief received <" + chief + " with headers: " + headers);
    }

    // отправка возвращаемого значения + чтение заголовков через аннотацию
    @SendTo("info")
    @JmsListener(destination = "subordinates")
    public String receiveSubordinate(Subordinate subordinate, @Headers Map<String, Object> headers) {
        System.out.println("Subordinate received: " + subordinate + " with headers: " + headers);
        return subordinate + " arrived";
    }

    //@SendTo({"info", "chiefs"}) - Несколько destination для @SendTo приведет к ошибке
    @JmsListener(destination = "subordinates")
    public void receiveSubordinate(Subordinate subordinate) {
        System.out.println("Subordinate received: " + subordinate);
    }

    // Заголовок из JmsHeaders и MessageConverter::typeIdPropertyName
    @JmsListener(destination = "info")
    public void receiveInfo(String info,
                            @Header("_type") String type,
                            @Header(JmsHeaders.DESTINATION) String destination) {
        System.out.println("Info received: " + info + " with type: " + type + " and destination: " + destination);
    }

    // Работа с исходным сообщением Message
    @JmsListener(destination = "info")
    public void receiveInfo(String info, Message raw) {
        System.out.println("Info received: " + info + ", raw message: " + raw);
    }


}
