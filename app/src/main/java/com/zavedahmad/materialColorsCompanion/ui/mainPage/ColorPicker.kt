package com.zavedahmad.materialColorsCompanion.ui.mainPage


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.picker.ui.KvColorPickerBottomSheet
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorPickerCustom(
    OnColorSelected: (Color) -> Unit,
    showColorSheet: MutableState<Boolean>,
    colorSheetState: SheetState
) {
    if (showColorSheet.value) {
        KvColorPickerBottomSheet(
            showSheet = showColorSheet,
            colorSheetState,
            onColorSelected = { color ->
                OnColorSelected(color)

            })
    }
}