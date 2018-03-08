import java.util.{Collections, Properties}

import scala.collection.JavaConverters._
import org.apache.kafka.clients.consumer.KafkaConsumer

object NewConsumer extends App{
  val props = new Properties()

  //3 mandatory properties
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "CustomDeserializer")
  props.put("group.id", "something")
  props.put("enable.auto.commit","false")
  props.put("auto.offset.reset","earliest")

  //val consumer = new KafkaConsumer[String, String](props)
  val consumer1 = new KafkaConsumer[String,Student](props)

  //consumer.subscribe(Collections.singletonList("topic1"))
  consumer1.subscribe(Collections.singletonList("StudentRecord"))

 /* while(true){
    val records = consumer.poll(5000)
    for(record <- records.asScala){
      println(record.value)
    }
  }*/

  while(true){
    val records = consumer1.poll(5000)
    for(record <- records.asScala){
      println("received message")
      println(record.value)
    }
  }
}
