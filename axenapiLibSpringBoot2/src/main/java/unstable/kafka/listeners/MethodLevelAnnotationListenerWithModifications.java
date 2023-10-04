package unstable.kafka.listeners;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;



@Component
public class MethodLevelAnnotationListenerWithModifications {
    final String topic = "multiType";
    final String id = "group-4";

    @KafkaListener(topics = "info", groupId = id, errorHandler = "kafkaListenerErrorHandler")
    @SendTo("error")
    public void handleReplyInfo(Object o, MessageHeaders headers, ConsumerRecord record) {
        System.out.printf("group-4 >> Info received: %s\n" +
                        "Headers: %s\n" +
                        "Raw message: %s\n",
                o, headers, record);
        throw new RuntimeException("fail");
    }

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = topic,
                    partitionOffsets = {
                            @PartitionOffset(partition = "0", initialOffset = "0"),
                            @PartitionOffset(partition = "1", initialOffset = "0")}),
            groupId = id)
    @KafkaHandler(isDefault = true)
    public void handleObject(
            @Payload Object payload,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(
                "group-4 >> Received Object: " + payload
                        + "from partition: " + partition);
    }
}
