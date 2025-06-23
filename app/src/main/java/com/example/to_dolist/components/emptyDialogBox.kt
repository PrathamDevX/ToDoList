package com.example.to_dolist.components

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
import com.example.to_dolist.viewmodel.TaskViewModel

@Composable
fun EmptyPopup(showDialog: Boolean, onDismiss: () -> Unit,viewModel: TaskViewModel) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(
                    text = "OOPS!",
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
                    text = "There is no task to delete! Try adding some and then try to delete it!",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 18.sp
                )
            },
            dismissButton = {
                TextButton(onClick = onDismiss,) {
                    Text("Okay", fontSize = 24.sp, textAlign = TextAlign.Center, color = Color(0xFF4567DB))
                }

            },
            confirmButton = {},
            containerColor = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp)

        )
    }
}
