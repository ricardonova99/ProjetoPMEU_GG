package ipvc.estg.projetopmeu_gg.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EndPoints {
    @GET("/utilizadorWhereNI/{nome}/{password}")
    fun getUtilizador(@Query("nome") nome: String, @Query("password") password: String): Call<Utilizador>
}