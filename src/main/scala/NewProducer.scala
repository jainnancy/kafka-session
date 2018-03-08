import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object NewProducer extends App {

    val props = new Properties()

    //3 mandatory properties
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    val producer = new KafkaProducer[String, String](props)
    for (i <- 1 to 100) {
      val record = new ProducerRecord[String, String]("topic1", i.toString, s"Hello $i")
      producer.send(record)
      println(s"message shown $i")
    }

  }
