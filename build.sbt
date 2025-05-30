ThisBuild / organization := "com.pelajaran.githubiot"
ThisBuild / version := "1.0.0"
ThisBuild / scalaVersion := "2.13.14"
ThisBuild / versionScheme := Some("early-semver")

// Ganti ini supaya credentials benar di-load, bukan dari file .sbt (karena sbt biasanya baca .credentials)
credentials += Credentials(
  "GitHub Package Registry",
  "maven.pkg.github.com",
  sys.env.getOrElse("GH_USERNAME", ""),
  sys.env.getOrElse("GH_TOKEN", "")
)

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
        "scm:git@github.com:4211421036/githubiotscl.git" // gunakan ":" bukan "/" setelah github.com
      )
    ),
    publishMavenStyle := true,  // penting supaya sbt tahu ini maven style repo
    publishTo := Some("GitHub Package Registry" at s"https://maven.pkg.github.com/4211421036/githubiotscl"), // harus repo owner dan repo name bukan cuma org
    
    // Opsional, untuk men-disable publish docs jar jika tidak perlu:
    publishArtifact in (Compile, packageDoc) := false,
    
    // Supaya artifact signed (kalau mau, tapi bisa skip dulu):
    // enablePlugins(PgpPlugin)
  )
