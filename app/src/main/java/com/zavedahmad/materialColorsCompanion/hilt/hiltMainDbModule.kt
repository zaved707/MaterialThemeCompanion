package com.zavedahmad.materialColorsCompanion.hilt

//import com.zavedahmad.materialColorsCompanion.roomDatabase.FavouritesDao

import android.content.Context
import androidx.room.Room
import com.zavedahmad.materialColorsCompanion.roomDatabase.MainDatabase
import com.zavedahmad.materialColorsCompanion.roomDatabase.PreferencesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object HiltMainDbModule {
    @Provides
    @Singleton
    fun providePreferenceDB(@ApplicationContext context: Context ) : MainDatabase{
        return Room.databaseBuilder(context = context, MainDatabase::class.java, "main_database").build()
    }

    @Provides
    fun providePreferencesDao(database: MainDatabase): PreferencesDao{
        return database.preferencesDao()
    }

}