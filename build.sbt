import com.typesafe.config.{Config, ConfigFactory}
import scala.collection.JavaConverters._

name := """message-board"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies ++= Seq(
  "org.scalikejdbc"        %% "scalikejdbc"                  % "2.5.2",
  "org.scalikejdbc"        %% "scalikejdbc-config"           % "2.5.2",
  "org.scalikejdbc"        %% "scalikejdbc-jsr310"           % "2.5.2",
  "org.scalikejdbc"        %% "scalikejdbc-test"             % "2.5.2" % Test,
  "org.skinny-framework"   %% "skinny-orm"                   % "2.3.7",
  "org.scalikejdbc"        %% "scalikejdbc-play-initializer" % "2.6.+",
  "ch.qos.logback"         % "logback-classic"               % "1.2.3",
  "mysql"                  % "mysql-connector-java"          % "6.0.6",
  "com.adrianhurt"         %% "play-bootstrap"               % "1.2-P26-B3" // 追加
)
// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"

lazy val envConfig = settingKey[Config]("env-config")

envConfig := {
  val env = sys.props.getOrElse("env", "dev")
  ConfigFactory.parseFile(file("env") / (env + ".conf"))
}

flywayLocations := envConfig.value.getStringList("flywayLocations").asScala
flywayDriver := envConfig.value.getString("jdbcDriver")
flywayUrl := envConfig.value.getString("jdbcUrl")
flywayUser := envConfig.value.getString("jdbcUserName")
flywayPassword := envConfig.value.getString("jdbcPassword")

TwirlKeys.templateImports ++= Seq("forms._")
