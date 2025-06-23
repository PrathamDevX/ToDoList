package com.example.to_dolist.components

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerField(
    selectedDate: MutableState<String>
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            selectedDate.value = "$dayOfMonth/${month + 1}/$year"
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    OutlinedTextField(
        value = selectedDate.value,
        onValueChange = {},
        label = { Text("Date") },
        enabled = false,
        trailingIcon = {
            if (selectedDate.value.isNotEmpty()) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFFEFEFEF),
                    modifier = Modifier.padding(end = 7.dp)
                ) {
                    Text(
                        text = selectedDate.value,
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
                datePickerDialog.show()
            },
        colors = OutlinedTextFieldDefaults.colors(
            disabledTextColor = Color.Transparent,
            disabledBorderColor = Color.Gray,
            disabledLabelColor = Color.Gray
        ),
        shape = RoundedCornerShape(10.dp)
    )
}
