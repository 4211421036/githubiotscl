package com.pelajaran.githubiot

import java.util.Base64

class GithubIoT(val token: String, val username: String, val repo: String) {

  private val apiUrl = s"https://api.github.com/repos/$username/$repo/contents/data.json"

  def sendData(jsonContent: String, commitMessage: String = "update via scala"): Unit = {
    val encodedContent = Base64.getEncoder.encodeToString(jsonContent.getBytes("UTF-8"))

    val body =
      s"""
         |{
         |  "message": "$commitMessage",
         |  "content": "$encodedContent"
         |}
         |""".stripMargin

    val headers = Map(
      "Authorization" -> s"token $token",
      "Content-Type"  -> "application/json"
    )

    val responseCode = HttpClient.putJson(apiUrl, body, headers)

    if (responseCode != 200 && responseCode != 201) {
      throw new RuntimeException(s"Failed to send data. HTTP code: $responseCode")
    }
  }
}
