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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.to_dolist.components.AddNoteTextField
import com.example.to_dolist.components.AddTaskButton
import com.example.to_dolist.components.DatePickerField
import com.example.to_dolist.components.DeleteTaskButton
import com.example.to_dolist.components.TaskInputField
import com.example.to_dolist.components.TimePickerField
import com.example.to_dolist.components.UpdateTaskButton
import com.example.to_dolist.source.Routes
import com.example.to_dolist.source.TaskItem
import com.example.to_dolist.viewmodel.TaskViewModel

@Composable
fun UpdateTaskScreen(navController: NavController,viewModel: TaskViewModel,task: TaskItem) {
    val titleState = remember { mutableStateOf(task.title) }
    val noteState = remember { mutableStateOf(task.description) }
    val timeState = remember { mutableStateOf(task.time) }
    val dateState = remember { mutableStateOf(task.date) }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, bottom = 16.dp)
            .background(Color.White)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            IconButton(
                onClick = { navController.navigate(Routes.homeScreen) },
                modifier = Modifier
                    .padding(top = 50.dp, start = 16.dp)
                    .size(60.dp)

            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "ArrowBack",
                    modifier = Modifier.size(60.dp)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                HorizontalDivider(
                    color = Color.LightGray,
                    thickness = 2.dp,
                    modifier = Modifier
                        .weight(1f)

                )

                Text(
                    text = "Add New",
                    fontSize = 35.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Text(
                    text = "Task",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )

                HorizontalDivider(
                    color = Color.LightGray,
                    thickness = 2.dp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
            }

            TaskInputField(value = titleState.value, onValueChange = { titleState.value = it })

            HorizontalDivider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)

            )

            Spacer(modifier = Modifier.height(6.dp))

            AddNoteTextField(note = noteState.value, onNoteChange = { noteState.value = it })

            Spacer(modifier = Modifier.height(24.dp))

            TimePickerField(selectedTime = timeState)

            Spacer(modifier = Modifier.height(10.dp))

            DatePickerField(selectedDate = dateState)

            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ){

                DeleteTaskButton(
                    context = context,
                    viewModel = viewModel,
                    navController = navController,
                    task = task,
                    modifier = Modifier.padding(16.dp)
                )


                UpdateTaskButton(
                    titleState = titleState.value,
                    noteState = noteState.value,
                    timeState = timeState.value,
                    dateState = dateState.value,
                    context = context,
                    viewModel = viewModel,
                    navController = navController,
                    oldTask = task,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
            }


        }
    }
}