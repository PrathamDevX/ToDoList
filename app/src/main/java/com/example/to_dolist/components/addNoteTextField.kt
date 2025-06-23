package com.example.to_dolist.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AddNoteTextField(
    note: String,
    onNoteChange: (String) -> Unit
) {
    OutlinedTextField(
        value = note,
        onValueChange = onNoteChange,
        placeholder = { Text("Add Note", color = Color.Black) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.BookmarkBorder,
                contentDescription = "Note Icon",
                tint = Color.Gray
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),
        textStyle = TextStyle(fontWeight = FontWeight.Normal),
        singleLine = false
    )
}
