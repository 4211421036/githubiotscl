// General project info
ThisBuild / organization := "com.pelajaran.githubiot"
ThisBuild / version      := "1.0.0"
ThisBuild / scalaVersion := "2.13.14"
ThisBuild / versionScheme := Some("early-semver")

// GitHub Packages publishing settings
ThisBuild / publishMavenStyle := true
ThisBuild / publishTo := Some(
  "GitHub Package Registry" at "https://maven.pkg.github.com/4211421036/githubiotscl"
)

// Project definition
lazy val root = (project in file("."))
  .settings(
    name := "githubiot",
    description := "Library to send IoT data to GitHub from Scala",
    
    // Metadata for GitHub Packages
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

    // Optional: Disable docs if not needed
    Compile / packageDoc / publishArtifact := false,
    Compile / packageSrc / publishArtifact := true
  )

// Load GitHub credentials from environment variables
credentials += Credentials(
  "GitHub Package Registry",
  "maven.pkg.github.com",
  sys.env.getOrElse("GITHUB_USERNAME", ""),
  sys.env.getOrElse("GITHUB_TOKEN", "")
)
