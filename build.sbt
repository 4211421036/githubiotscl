ThisBuild / organization := "com.pelajaran.githubiot"
ThisBuild / version := "1.0.0"
ThisBuild / scalaVersion := "2.13.14"

lazy val root = (project in file("."))
  .settings(
    name := "githubiot",
    description := "Library to send IoT data to GitHub from Scala",
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
    homepage := Some(url("https://github.com/4211421036/githubiotscl/")),
    developers := List(
      Developer("4211421036", "GALIH RIDHO UTOMO", "g4lihru@students.unnes.ac.id", url("https://github.com/4211421036"))
    ),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/4211421036/githubiotscl/"),
        "scm:git@github.com/4211421036/githubiotscl/.git"
      )
    ),
    publishTo := Some("GitHub Package Registry" at "https://maven.pkg.github.com/4211421036/githubiotscl"),
    credentials += Credentials(Path.userHome / ".github" / ".credentials"),
    publishMavenStyle := true
  )
