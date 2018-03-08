import java.util.{Collections, Properties}

import scala.collection.JavaConverters._
import org.apache.kafka.clients.consumer.KafkaConsumer

object NewConsumer extends App{
  val props = new Properties()

  //3 mandatory properties
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("group.id", "something")
  props.put("enable.auto.commit","false")
  props.put("auto.offset.reset","earliest")

  val consumer = new KafkaConsumer[String, String](props)

  consumer.subscribe(Collections.singletonList("topic1"))

  while(true){
    val records = consumer.poll(5000)
    for(record <- records.asScala){
      println(record.value)
    }
  }
}
