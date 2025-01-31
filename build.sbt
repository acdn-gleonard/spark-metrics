
val scalatestVersion = "3.0.4"
val sparkVersion = "2.3.0"


resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

lazy val root = (project in file("."))
  .settings(
    name := "spark-metrics",
    organization := "com.banzaicloud",
    scalaVersion := "2.11.12",
    version := "2.3.1-1.0.0",
    libraryDependencies ++= Seq(
      "io.prometheus" % "simpleclient" % "0.3.0",
      "io.prometheus" % "simpleclient_dropwizard" % "0.3.0",
      "io.prometheus" % "simpleclient_pushgateway" % "0.3.0",
      "io.dropwizard.metrics" % "metrics-core" % "3.1.2",
      "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
      "org.slf4j" % "slf4j-api" % "1.7.16",
      "com.google.guava" % "guava" % "14.0.1",
      "com.novocode" % "junit-interface" % "0.11" % Test,
      "org.scalatest" %% "scalatest" % scalatestVersion % "test"

    )
  )

publishMavenStyle := true

publishTo := {
  if (isSnapshot.value)
    Some(Resolver.file("file", new File("maven-repo/snapshots")))
  else
    Some(Resolver.file("file", new File("maven-repo/releases")))
}