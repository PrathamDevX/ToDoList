package com.example.to_dolist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.to_dolist.viewmodel.TaskViewModel

@Composable
fun DeletePopup(showDialog: Boolean, onDismiss: () -> Unit,viewModel: TaskViewModel) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(
                    text = "Are You Sure?",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
            },

            text = {
                Text(
                    text = "Do you really want to delete all tasks? You will not be able to undo this action!",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 16.sp
                )
            },
            dismissButton = {
                TextButton(onClick = onDismiss,) {
                    Text("No", fontSize = 20.sp, color = Color(0xFF4567DB))
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    viewModel.deleteAllTasks()
                    onDismiss()
                }) {
                    Text("Yes", fontSize = 20.sp, color = Color(0xFF4567DB))
                }
            },
            containerColor = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp)

        )
    }
}
