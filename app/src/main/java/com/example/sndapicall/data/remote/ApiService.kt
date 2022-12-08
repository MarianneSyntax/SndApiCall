package com.example.sndapicall.data.remote
import com.example.sndapicall.data.model.Response
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

// VARIABLEN, die von jeder ApiService Instanz nutzbar sein sollen:
const val BASE_URL = "https://dog.ceo/api/"


// speichert in der Variable moshi einen moshi Builder, der Json (Sprache der Antwort von der Website) in Kotlin konvertiert
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

// speichert in der Variable retrofit einen Converter mit unserem moshi Builder speziell für unsere Base URL
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()

// hier geht das Interface los, von dem konkrete Instanz erstellt werden können
// interfaces sind dazu da, Funktionen bereitzustellen

interface ApiService {

    //get request:
    // wir wollen von der base_url aus die Antwort von folgender Adresse als Datentyp Response speichern:
    // wir tun im Kommentar so, als wollten wir konkret zur rasse beagle
    // und setzen in Z. 30 und 33 für {dogbreed} beagle in die Adresse:
    @GET("/breed/{dogBreed}/images")
    //https://dog.ceo/api/breed/beagle/images
    suspend fun getBeagles(@Path("dogBreed") dogBreed: String): Response
    // @Path im Gegensatz zu @Query: bei Query würde die Adresse automatisch so aussehen:
// "/search?dogBreed=beagle"

}

object DogApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}


