package id.fadhelmw.games.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.fadhelmw.games.data.remote.GamesApi
import id.fadhelmw.games.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Modul Dagger-Hilt yang menyediakan Retrofit dan GamesApi sebagai dependensi
@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    // fungsi untuk menyediakan instance Retrofit dengan base URL dan converter JSON (Gson)
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    @Singleton
    @Provides
    // fungsi untuk menyediakan instance GamesApi berdasarkan instance Retrofit
    fun provideGamesApi(retrofit: Retrofit): GamesApi {
        return retrofit.create(GamesApi::class.java)
    }
}