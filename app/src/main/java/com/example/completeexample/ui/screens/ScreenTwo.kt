package com.example.completeexample.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.completeexample.viewmodel.CompleteViewModel

@Composable
fun ScreenTwo(viewModel: CompleteViewModel) {
    Surface(
        modifier = Modifier
            .background(color = Color.Green)
            .fillMaxSize()
    ) {
        Text(text = "ScreenTwo", modifier = Modifier.clickable {
            viewModel.navigateToScreen(CompleteViewModel.NavigationEvent.NavigateToScreenOne)
        })
    }
}