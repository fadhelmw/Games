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

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    fun provideGamesApi(retrofit: Retrofit): GamesApi {
        return retrofit.create(GamesApi::class.java)
    }
}