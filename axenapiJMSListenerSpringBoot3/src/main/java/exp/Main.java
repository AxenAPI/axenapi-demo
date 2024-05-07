package exp;

import axenapi.listener.ExampleQueueExampleInListener;
import axenapi.listener.service.ExampleQueueExampleInService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;

@SpringBootApplication
@EnableJms
@ComponentScan("axenapi")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public MessageConverter jmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    @Bean
    public ExampleQueueExampleInService exampleQueueExampleInService() {
        return (exampleIn, headers) -> {
            System.out.println("Received EXAMPLE_QUEUE");
            System.out.println(exampleIn);
            return null;
        };
    }

    @Bean
    public ExampleQueueExampleInListener exampleQueueListener(ExampleQueueExampleInService service) {
        return new ExampleQueueExampleInListener(service);
    }
}
