package com.pelajaran.githubiot

import java.io.OutputStreamWriter
import java.net.{HttpURLConnection, URL}

object HttpClient {

  def putJson(url: String, jsonBody: String, headers: Map[String, String]): Int = {
    val connection = new URL(url).openConnection().asInstanceOf[HttpURLConnection]
    connection.setRequestMethod("PUT")
    connection.setDoOutput(true)

    // Set headers
    headers.foreach { case (key, value) =>
      connection.setRequestProperty(key, value)
    }

    val writer = new OutputStreamWriter(connection.getOutputStream)
    writer.write(jsonBody)
    writer.flush()
    writer.close()

    connection.getResponseCode
  }

}
