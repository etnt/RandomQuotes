package se.kruskakli.quotes2

import retrofit2.Response
import retrofit2.http.GET
interface QuoteApi {

    @GET("random")
    suspend fun getRandomQuote() : Response<List<QuoteModel>>

    // We could add more API's here like this:
    //@GET("today")
    //suspend fun getTodayQuote() : Response<List<QuoteModel>>

}