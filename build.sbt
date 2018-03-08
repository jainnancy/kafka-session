name := "kafka-session"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies  +=  "org.apache.kafka" % "kafka-clients" % "0.11.0.0"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"

libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.8.0-beta1" % Test