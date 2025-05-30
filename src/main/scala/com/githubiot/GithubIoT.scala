package com.pelajaran.githubiot

import java.io.OutputStreamWriter
import java.net.{HttpURLConnection, URL}

class GithubIoT(val token: String, val username: String, val repo: String) {

  private val apiUrl = s"https://api.github.com/repos/$username/$repo/contents/data.json"

  def sendData(jsonContent: String, commitMessage: String = "update via scala"): Unit = {
    val connection = new URL(apiUrl).openConnection().asInstanceOf[HttpURLConnection]
    connection.setRequestMethod("PUT")
    connection.setDoOutput(true)
    connection.setRequestProperty("Authorization", s"token $token")
    connection.setRequestProperty("Content-Type", "application/json")

    val encodedContent = java.util.Base64.getEncoder.encodeToString(jsonContent.getBytes("UTF-8"))

    val body =
      s"""
         |{
         |  "message": "$commitMessage",
         |  "content": "$encodedContent"
         |}
         |""".stripMargin

    val writer = new OutputStreamWriter(connection.getOutputStream)
    writer.write(body)
    writer.flush()
    writer.close()

    val responseCode = connection.getResponseCode
    if (responseCode != 201 && responseCode != 200) {
      throw new RuntimeException(s"Failed to send data. HTTP code: $responseCode")
    }
  }
}
