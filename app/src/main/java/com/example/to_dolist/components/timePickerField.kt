package com.example.to_dolist.components

import android.app.TimePickerDialog
import android.widget.TimePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.util.Calendar

@Composable
fun TimePickerField(selectedTime: MutableState<String>) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)



    val timePickerDialog = TimePickerDialog(
        context,
        { _: TimePicker, selectedHour: Int, selectedMinute: Int ->
            val amPm = if (selectedHour >= 12) "PM" else "AM"
            val formattedHour = if (selectedHour % 12 == 0) 12 else selectedHour % 12
            selectedTime.value = String.format("%02d:%02d %s", formattedHour, selectedMinute, amPm)
        },
        hour,
        minute,
        false
    )

    OutlinedTextField(
        value = selectedTime.value,
        onValueChange = {},
        label = { Text("Time") },
        enabled = false,
        trailingIcon = {
            if (selectedTime.value.isNotEmpty()) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFFEFEFEF),
                    modifier = Modifier.padding(end = 7.dp)
                ) {
                    Text(
                        text = selectedTime.value,
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        },
        modifier = Modifier
            .padding(start = 18.dp, end = 18.dp)
            .fillMaxWidth()
            .clickable {
                timePickerDialog.show()
            },
        colors = OutlinedTextFieldDefaults.colors(
            disabledTextColor = Color.Transparent,
            disabledBorderColor = Color.Gray,
            disabledLabelColor = Color.Gray
        ),
        shape = RoundedCornerShape(10.dp)
    )
}
