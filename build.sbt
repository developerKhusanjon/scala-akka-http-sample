name := "scala-akka-http-sample"

version := "0.1.0"

scalaVersion := "2.13.12"

idePackagePrefix := Some("dev.khusanjon")

val akkaActorTypedVersion = "2.8.0"
val akkaHttpVersion: String = "10.5.0"
val akkaStreamVersion: String = "2.8.0"
val akkaTestkitVersion: String = "2.8.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaActorTypedVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaStreamVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaTestkitVersion,
)
