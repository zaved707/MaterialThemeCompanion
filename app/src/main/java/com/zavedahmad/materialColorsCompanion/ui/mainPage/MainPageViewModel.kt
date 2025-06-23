package com.zavedahmad.materialColorsCompanion.ui.mainPage


import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.zavedahmad.materialColorsCompanion.roomDatabase.PreferencesDao
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel()
class MainPageViewModel @Inject constructor(

    val preferencesDao: PreferencesDao
) :
    ViewModel() {
    override fun onCleared() {
        println("mainViewModelCleared")
    }
    private val _selectedColor = MutableStateFlow<Color?>(null)
    val selectedColor = _selectedColor.asStateFlow()

    fun changeSelectedColor(color :Color){
        _selectedColor.value =color
    }
}