// Info umum build
ThisBuild / organization := "com.pelajaran.githubiot"
ThisBuild / version := "1.0.0"
ThisBuild / scalaVersion := "2.13.14"
ThisBuild / versionScheme := Some("early-semver")

// Credentials di-load dari environment variables GH_USERNAME dan GH_TOKEN
credentials += Credentials(
  "GitHub Package Registry",                // Harus ini supaya sbt cocok dengan server GitHub
  "maven.pkg.github.com",                    // Host GitHub Packages
  sys.env.getOrElse("GH_USERNAME", ""),     // Username dari env var GH_USERNAME
  sys.env.getOrElse("GH_TOKEN", "")         // Token dari env var GH_TOKEN
)

// Definisi project root
lazy val root = (project in file("."))
  .settings(
    name := "githubiot",
    description := "Library to send IoT data to GitHub from Scala",
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
    homepage := Some(url("https://github.com/4211421036/githubiotscl/")),
    developers := List(
      Developer(
        "4211421036",
        "GALIH RIDHO UTOMO",
        "g4lihru@students.unnes.ac.id",
        url("https://github.com/4211421036")
      )
    ),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/4211421036/githubiotscl/"),
        "scm:git@github.com:4211421036/githubiotscl.git"  // gunakan ':' bukan '/'
      )
    ),
    
    publishMavenStyle := true,    // Wajib untuk publish ke Maven repositori
    
    // Publish ke GitHub Packages URL, ganti sesuai owner dan repo kamu
    publishTo := Some(
      "GitHub Package Registry" at s"https://maven.pkg.github.com/4211421036/githubiotscl"
    ),
    
    // Optional: kalau tidak ingin generate javadoc jar (docs)
    publishArtifact in (Compile, packageDoc) := false
  )
