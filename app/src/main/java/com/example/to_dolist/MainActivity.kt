package com.example.to_dolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.to_dolist.screens.AddListScreen
import com.example.to_dolist.screens.HomeScreen
import com.example.to_dolist.screens.ProfileScreen
import com.example.to_dolist.screens.SettingsScreen
import com.example.to_dolist.screens.UpdateTaskScreen
import com.example.to_dolist.source.Routes
import com.example.to_dolist.source.TaskDatabase
import com.example.to_dolist.source.TaskRepository
import com.example.to_dolist.ui.theme.ToDoListTheme
import com.example.to_dolist.viewmodel.TaskViewModel
import com.example.to_dolist.viewmodel.TaskViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoListTheme {
                val db = TaskDatabase.getDatabase(applicationContext)
                val repository = TaskRepository(db.taskDao())
                val viewModel: TaskViewModel = viewModel(factory = TaskViewModelFactory(repository))

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.homeScreen, builder = {
                    composable( Routes.homeScreen){
                        HomeScreen(navController,viewModel)
                        }
                    composable( Routes.profileScreen){
                        ProfileScreen(navController)
                    }
                    composable( Routes.settingsScreen) {
                        SettingsScreen(navController)
                    }
                    composable( Routes.addListScreen){
                        AddListScreen(navController, viewModel)
                    }
                    composable("${Routes.updateTaskScreen}/{id}") { backStackEntry ->
                        val taskId = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                        val task = viewModel.tasks.collectAsState().value.find { it.id == taskId }

                        if (task != null) {
                            UpdateTaskScreen(navController, viewModel, task)
                        }
                    }
                })
            }
        }
    }
}

