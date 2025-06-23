package com.example.to_dolist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.to_dolist.source.Routes
import com.example.to_dolist.source.TaskItem
import com.example.to_dolist.source.TaskRepository

@Composable
fun CardList(
    taskList: List<TaskItem>,
    navController: NavController,
    onCheckedChange: (TaskItem, Boolean) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        items(taskList) { task ->
            CardContent(
                title = task.title,
                description = task.description,
                time = task.time,
                date = task.date,
                isDone = task.isDone,
                onCheckedChange = { isDone ->
                    onCheckedChange(task, isDone)
                },
                onClick = {
                    navController.navigate(Routes.updateTaskScreenWithId(task.id))
                }
            )
        }
    }
}
