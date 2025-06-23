package com.example.to_dolist.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import com.example.to_dolist.source.Routes


@Composable
fun CardContent(
    title: String,
    description: String,
    time: String,
    date: String,
    isDone: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable{ onClick() },
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDone) Color(0xFFE2DDFE) else Color.White
        )
    ) {
        Row() {
            Checkbox(
                checked = isDone,
                onCheckedChange = onCheckedChange,
                modifier = Modifier.padding(top = 6.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textDecoration = if (isDone) TextDecoration.LineThrough else null
                )


                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = description,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    textDecoration = if (isDone) TextDecoration.LineThrough else null
                )

                Spacer(modifier = Modifier.height(4.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(text = "Time: $time", color = Color.Black, fontWeight = FontWeight.Light)
                    Text(text = "Date: $date", color = Color.Black, fontWeight = FontWeight.Light)
                }
            }
        }

    }
}
