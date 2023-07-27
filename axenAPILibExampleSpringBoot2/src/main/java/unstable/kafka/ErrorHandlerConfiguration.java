package unstable.kafka;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.support.KafkaHeaders;

@Configuration
public class ErrorHandlerConfiguration {
    @Bean
    KafkaListenerErrorHandler kafkaListenerErrorHandler() {
        return (msg, ex) -> {
            if (msg.getHeaders().get(KafkaHeaders.DELIVERY_ATTEMPT, Integer.class) > 9) {
                return "FAILED";
            }
            throw ex;
        };
    }
}
