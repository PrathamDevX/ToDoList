package com.example.to_dolist.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.to_dolist.source.Routes
import com.example.to_dolist.source.TaskItem
import com.example.to_dolist.viewmodel.TaskViewModel

@Composable
fun UpdateTaskButton(
    titleState: String,
    noteState: String,
    timeState: String,
    dateState: String,
    context: Context,
    viewModel: TaskViewModel,
    navController: NavController,
    oldTask: TaskItem,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {
            if (titleState.isBlank() || noteState.isBlank() || timeState.isBlank() || dateState.isBlank()) {
                Toast.makeText(context, "Please fill all fields!", Toast.LENGTH_LONG).show()
            } else {
                val updatedTask = oldTask.copy(
                    title = titleState,
                    description = noteState,
                    time = timeState,
                    date = dateState
                )
                viewModel.updateTask(updatedTask)
                Toast.makeText(context, "Task updated!", Toast.LENGTH_SHORT).show()
                navController.navigate(Routes.homeScreen)
            }
        },
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4467db))
    ) {
        Text("Update Task", color = Color.White)
    }
}

