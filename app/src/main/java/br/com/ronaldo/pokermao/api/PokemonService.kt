package br.com.ronaldo.pokermao.api

import br.com.ronaldo.pokermao.model.HealthResponse
import br.com.ronaldo.pokermao.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {
    @GET("/api/pokemon/health")
    fun checkHealth(): Call<HealthResponse>

    @GET("/api/pokemon")
    fun getPokemons(
        @Query("size") size: Int,
        @Query("sort") sort: String
    ): Call<PokemonResponse>
}