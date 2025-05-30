// Info umum build
ThisBuild / organization := "com.pelajaran.githubiot"
ThisBuild / version := "1.0.0"
ThisBuild / scalaVersion := "2.13.14"
ThisBuild / versionScheme := Some("early-semver")

// Untuk publish ke Maven Central (termasuk Scala Index)
ThisBuild / publishTo := sonatypePublishToBundle.value
ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"
ThisBuild / sonatypeRepository := "https://s01.oss.sonatype.org/service/local"

// Definisi project root
lazy val root = (project in file("."))
  .settings(
    name := "githubiot",
    description := "Library to send IoT data to GitHub from Scala",
    licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT")),
    homepage := Some(url("https://github.com/4211421036/githubiotscl")),
    developers := List(
      Developer(
        id = "4211421036",
        name = "GALIH RIDHO UTOMO",
        email = "g4lihru@students.unnes.ac.id",
        url = url("https://github.com/4211421036")
      )
    ),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/4211421036/githubiotscl"),
        "scm:git:git@github.com:4211421036/githubiotscl.git"
      )
    ),
    
    // Wajib untuk publish ke Maven Central/Scala Index
    publishMavenStyle := true,
    
    // Wajib: generate dokumen dan source
    publishArtifact in (Compile, packageDoc) := true,
    publishArtifact in (Compile, packageSrc) := true,
    
    // Optional: signing untuk Maven Central
    // publish/skip := true, // skip publish untuk development
  )
