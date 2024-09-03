package com.example.completeexample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.completeexample.ui.screens.ScreenOne
import com.example.completeexample.ui.screens.ScreenTwo
import com.example.completeexample.viewmodel.CompleteViewModel
import com.example.completeexample.viewmodel.CompleteViewModel.NavigationEvent.NavigateToScreenOne
import com.example.completeexample.viewmodel.CompleteViewModel.NavigationEvent.NavigateToScreenTwo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun NavGraph(viewModel: CompleteViewModel) {
    val navController = rememberNavController()
    NavigationRouting(viewModel, navController)
    NavHost(navController = navController, startDestination = "ScreenOne") {
        composable("ScreenOne") {
            ScreenOne(viewModel)
        }
        composable("ScreenTwo") {
            ScreenTwo(viewModel)
        }
    }
}

@Composable
private fun NavigationRouting(
    viewModel: CompleteViewModel, navController: NavHostController
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(key1 = lifecycleOwner.lifecycle) {
        withContext(Dispatchers.Main.immediate) {
            lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.navigationChannelFlow.collect { events ->
                    when (events) {
                        is NavigateToScreenTwo -> {
                            navController.navigate("ScreenTwo")
                        }

                        is NavigateToScreenOne -> {
                            //  navController.navigate("ScreenOne")
                            navController.popBackStack("ScreenOne", inclusive = false)
                        }
                    }

                }
            }
        }
    }
}