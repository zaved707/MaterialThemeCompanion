package com.zavedahmad.materialColorsCompanion.ui.mainPage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import com.zavedahmad.materialColorsCompanion.ui.components.MyTopABCommon
import com.zavedahmad.materialColorsCompanion.utility.getInverseColor


data class listColor(val name: String, val color: Color, val textColor: Color? = null)

@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainPage(backStack: SnapshotStateList<NavKey>, viewModel: MainPageViewModel) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold (
        Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {

        MyTopABCommon(backStack, scrollBehavior,"Material Colors")}){ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            val colors =
                listOf<listColor>(
                    listColor("Primary", MaterialTheme.colorScheme.primary),
                    listColor("OnPrimary", MaterialTheme.colorScheme.onPrimary),
                    listColor("PrimaryContainer", MaterialTheme.colorScheme.primaryContainer),
                    listColor("OnPrimaryContainer", MaterialTheme.colorScheme.onPrimaryContainer),
                    listColor("Secondary", MaterialTheme.colorScheme.secondary),
                    listColor("OnSecondary", MaterialTheme.colorScheme.onSecondary),
                    listColor("SecondaryContainer", MaterialTheme.colorScheme.secondaryContainer),
                    listColor(
                        "OnSecondaryContainer",
                        MaterialTheme.colorScheme.onSecondaryContainer
                    ),
                    listColor("Tertiary", MaterialTheme.colorScheme.tertiary),
                    listColor("OnTertiary", MaterialTheme.colorScheme.onTertiary),
                    listColor("TertiaryContainer", MaterialTheme.colorScheme.tertiaryContainer),
                    listColor("OnTertiaryContainer", MaterialTheme.colorScheme.onTertiaryContainer),
                    listColor("Error", MaterialTheme.colorScheme.error),
                    listColor("OnError", MaterialTheme.colorScheme.onError),
                    listColor("ErrorContainer", MaterialTheme.colorScheme.errorContainer),
                    listColor("OnErrorContainer", MaterialTheme.colorScheme.onErrorContainer, textColor = getInverseColor(
                        MaterialTheme.colorScheme.onErrorContainer)),
                    listColor("Background", MaterialTheme.colorScheme.background),
                    listColor("OnBackground", MaterialTheme.colorScheme.onBackground, textColor = getInverseColor(
                        MaterialTheme.colorScheme.onBackground)),
                    listColor("Surface", MaterialTheme.colorScheme.surface),
                    listColor("OnSurface", MaterialTheme.colorScheme.onSurface, textColor = getInverseColor(MaterialTheme.colorScheme.onSurface)),
                    listColor("SurfaceVariant", MaterialTheme.colorScheme.surfaceVariant),
                    listColor("OnSurfaceVariant", MaterialTheme.colorScheme.onSurfaceVariant, textColor = getInverseColor(
                        MaterialTheme.colorScheme.onSurfaceVariant)),
                    listColor("Outline", MaterialTheme.colorScheme.outline),
                    listColor("OutlineVariant", MaterialTheme.colorScheme.outlineVariant),
                    listColor("SurfaceBright", MaterialTheme.colorScheme.surfaceBright),
                    listColor("SurfaceDim", MaterialTheme.colorScheme.surfaceDim),
                    listColor("SurfaceContainer", MaterialTheme.colorScheme.surfaceContainer),
                    listColor(
                        "SurfaceContainerLowest",
                        MaterialTheme.colorScheme.surfaceContainerLowest
                    ),
                    listColor("SurfaceContainerLow", MaterialTheme.colorScheme.surfaceContainerLow),
                    listColor(
                        "SurfaceContainerHigh",
                        MaterialTheme.colorScheme.surfaceContainerHigh
                    ),
                    listColor(
                        "SurfaceContainerHighest",
                        MaterialTheme.colorScheme.surfaceContainerHighest
                    ),
                    listColor("InversePrimary", MaterialTheme.colorScheme.inversePrimary),
                    listColor("InverseSurface", MaterialTheme.colorScheme.inverseSurface),
                    listColor("InverseOnSurface", MaterialTheme.colorScheme.inverseOnSurface)
                )
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(colors) { item ->
                    Box(Modifier.padding(10.dp)) {
                        OutlinedCard(
                            onClick = {}, modifier =
                                Modifier

                                    .height(100.dp)
                                    .fillMaxSize(),
                            shape = RoundedCornerShape(20.dp),

                            colors = CardDefaults.cardColors(containerColor = item.color, contentColor = if (item.textColor== null){
                                CardDefaults.cardColors(item.color).contentColor}else{item.textColor})
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize().padding(5.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(item.name) }
                        }
                    }
                }
            }

        }
    }

}

