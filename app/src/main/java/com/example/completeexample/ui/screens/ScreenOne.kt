package com.example.completeexample.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.example.completeexample.viewmodel.CompleteViewModel

@Composable
fun ScreenOne(viewModel: CompleteViewModel) {
    val images = viewModel.images.collectAsState()
//    val context = LocalContext.current
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchImages()
    }
    Surface(modifier = Modifier) {
        LazyColumn {
            items(images.value) { info ->
                Column {
                    var text = "Test"
                    Row {
                        OutlinedTextField(value = "", onValueChange = {  }, leadingIcon = { Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = ""
                        )}, label = { Text(text = "My Label")}, placeholder = { Text(
                            text = "My PlaceHolder"
                        )}, modifier = Modifier.fillParentMaxWidth())
                        Text(
                            modifier = Modifier.background(color = Color.Red),
                            text = info.userId.toString()
                        )
                        Text(
                            modifier = Modifier.background(color = Color.Yellow),
                            text = info.id.toString()
                        )
                    }
                    Column {
                        Text(modifier = Modifier.background(color = Color.Gray), text = info.title)
                        Text(modifier = Modifier
                            .background(color = Color.Blue)
                            .clickable {
                                //Toast.makeText(context,"Check", Toast.LENGTH_SHORT).show()
                                viewModel.navigateToScreen(CompleteViewModel.NavigationEvent.NavigateToScreenTwo)
                            }, text = info.body)
                    }
                }
            }
        }
    }
}