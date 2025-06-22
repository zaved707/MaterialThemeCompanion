package com.zavedahmad.materialColorsCompanion.ui.mainPage


import androidx.lifecycle.ViewModel
import com.zavedahmad.materialColorsCompanion.roomDatabase.PreferencesDao
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel()
class MainPageViewModel @Inject constructor(

    val preferencesDao: PreferencesDao
) :
    ViewModel() {
    override fun onCleared() {
        println("mainViewModelCleared")
    }


}