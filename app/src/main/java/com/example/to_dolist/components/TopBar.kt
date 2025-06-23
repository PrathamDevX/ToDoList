package com.example.to_dolist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.to_dolist.source.TaskItem
import com.example.to_dolist.source.TaskRepository
import com.example.to_dolist.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    openDrawer: () -> Unit,
    viewModel: TaskViewModel
) {
    val showDialog = remember { mutableStateOf(false) }
    TopAppBar(
        title = {},
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 16.dp)
                    .clickable {
                        openDrawer()
                    },
                tint = Color.Black
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        ),
        actions = {
            IconButton(
                onClick = {
                    showDialog.value = true
                },
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete",
                    tint = Color.Black,
                    modifier = Modifier.size(35.dp)
                )
            }
        }
    )
    if(showDialog.value){
        if(viewModel.tasks.collectAsState().value.isEmpty()){
            EmptyPopup(
                showDialog = true,
                onDismiss = { showDialog.value = false },
                viewModel = viewModel
            )
        } else{
            DeletePopup(
                showDialog = true,
                onDismiss = { showDialog.value = false },
                viewModel = viewModel
            )
        }
    }
}