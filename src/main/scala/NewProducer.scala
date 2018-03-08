import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object NewProducer extends App {

    val props = new Properties()

    //3 mandatory properties
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "CustomSerializer")

    /*val producer = new KafkaProducer[String, String](props)
    for (i <- 1 to 100) {
      val record = new ProducerRecord[String, String]("topic1", i.toString, s"Hello $i")
      producer.send(record)
      println(s"message shown $i")
    }*/
  val producer1 = new KafkaProducer[String, Student](props)
  val student1 = new Student(1,"Nancy")

  val studentRecord = new ProducerRecord[String, Student]("StudentRecord", "key", student1)

  producer1.send(studentRecord)
  System.out.println(s"Student record has been sent")

  //producer.close()
  producer1.close()
}
