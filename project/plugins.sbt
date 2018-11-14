resolvers += "Flyway" at "https://flywaydb.org/repo" // 追加

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.11")

addSbtPlugin("org.flywaydb" % "flyway-sbt" % "4.2.0") // 追加
addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.3")
addSbtPlugin("com.heroku" % "sbt-heroku" % "1.0.1")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.9")