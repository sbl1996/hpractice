name := "hpractice"

scalaVersion := "2.11.8"

//libraryDependencies += "junit" % "junit" % "4.12"

//libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"

//libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.2" % "test"

//libraryDependencies += "com.github.pathikrit" %% "better-files" % version

import sbt._
import complete.DefaultParsers._

val submit = inputKey[Unit]("Submit a file to HrvvI.")

submit := {
  // get the result of parsing
  val args: Seq[String] = spaceDelimited("<arg>").parsed

  val log = streams.value.log

  args match {
    case Seq(name, unit, filename) => SubmitUtils.submit(name, unit, filename)
    case _ =>
      log.error("Args must include <name>, <unit> and <filename>.")
      log.info("Example: submit Shen unit1 operator")
  }
  // Here, we also use the value of the `scalaVersion` setting
}