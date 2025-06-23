package com.example.to_dolist.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.to_dolist.components.CardList
import com.example.to_dolist.components.DrawerContent
import com.example.to_dolist.source.Routes
import com.example.to_dolist.components.TopBar
import com.example.to_dolist.viewmodel.TaskViewModel
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(navController: NavController, viewModel: TaskViewModel) {
    val taskList by viewModel.tasks.collectAsState()

    val totalTasks = taskList.size
    val completedTasks = taskList.count { it.isDone }
    val progress = if (totalTasks > 0) completedTasks / totalTasks.toFloat() else 0f

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navController)
        }
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    openDrawer = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    },
                    viewModel = viewModel
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { navController.navigate(Routes.addListScreen) },
                    modifier = Modifier.size(70.dp),
                    containerColor = Color(0xFF4568DC)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.White
                    )
                }
            }
        ) { innerpadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(innerpadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 28.dp, vertical = 20.dp)
                    ) {
                        Box(
                            modifier = Modifier.size(34.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                progress = { progress },
                                strokeWidth = 5.dp,
                                modifier = Modifier.fillMaxSize(),
                                color = Color(0xFF4467DB)
                            )
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(modifier = Modifier.padding(start = 12.dp)) {
                            Text(
                                text = "My Tasks",
                                style = MaterialTheme.typography.headlineLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 45.sp
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = "$completedTasks of $totalTasks task",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.Gray,
                                fontSize = 20.sp
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            HorizontalDivider(
                                color = Color.LightGray,
                                thickness = 1.dp,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }

                CardList(
                    taskList = taskList,
                    navController = navController,
                    onCheckedChange = { task, isChecked ->
                        viewModel.updateTask(task.copy(isDone = isChecked))
                    }
                )
            }
        }
    }
}












