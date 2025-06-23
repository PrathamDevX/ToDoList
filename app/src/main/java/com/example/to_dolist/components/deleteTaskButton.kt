package com.example.to_dolist.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.to_dolist.source.Routes
import com.example.to_dolist.source.TaskItem
import com.example.to_dolist.viewmodel.TaskViewModel

@Composable
fun DeleteTaskButton(
    context: Context,
    viewModel: TaskViewModel,
    navController: NavController,
    task: TaskItem,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {
            viewModel.deleteTask(task)
            Toast.makeText(context, "Task deleted!", Toast.LENGTH_SHORT).show()
            navController.navigate(Routes.homeScreen)
        },
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4467db))
    ) {
        Text("Delete Task", color = Color.White)
    }
}
