
name := """play-akka-dbflute"""
organization := "com.example"

version := "1.0-SNAPSHOT"

scalaVersion := "2.13.3"

libraryDependencies ++=
  Seq(
    guice,
    jdbc,
    "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
    "mysql" % "mysql-connector-java" % "8.0.23",
    "com.typesafe.play" %% "play-slick" % "5.0.0",
    "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0",
    "com.typesafe.slick" %% "slick-codegen" % "3.3.3")

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
