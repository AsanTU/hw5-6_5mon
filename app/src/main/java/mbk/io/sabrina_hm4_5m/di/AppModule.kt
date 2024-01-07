package mbk.io.sabrina_hm4_5m.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import mbk.io.sabrina_hm4_5m.Hero
import mbk.io.sabrina_hm4_5m.LoveApi
import mbk.io.sabrina_hm4_5m.Pref
import mbk.io.sabrina_hm4_5m.Utils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun provideUtils() = Utils()

    @Provides
    fun provideHero(): Hero {
        return Hero()
    }

    @Provides
    fun providePreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("fileName", Context.MODE_PRIVATE)
    }

    @Provides
    fun providePref(sharedPreferences: SharedPreferences): Pref {
        return Pref(sharedPreferences)
    }
}