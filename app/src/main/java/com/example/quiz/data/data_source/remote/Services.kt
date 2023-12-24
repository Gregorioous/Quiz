package com.example.quiz.data.data_source.remote

import android.util.Log
import com.example.quiz.data.data_source.remote.dto.QuestionResponse
import com.example.quiz.utills.Constants
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.url

class Services(
    private val client: HttpClient
) {
    suspend fun getQuestions(): List<QuestionResponse> {
        return try {
            client.get { url(Constants.base_url) }
        } catch (e: RedirectResponseException) {
            // 3xx - responses
            Log.d("Error", e.response.status.description)
            emptyList()
        } catch (e: ClientRequestException) {
            // 4xx - responses
            Log.d("Error", e.response.status.description)

            emptyList()
        } catch (e: ServerResponseException) {
            // 5xx - responses
            Log.d("Error", e.response.status.description)
            emptyList()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }


}