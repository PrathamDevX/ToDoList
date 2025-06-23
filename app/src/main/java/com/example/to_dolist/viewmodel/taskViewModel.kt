package com.example.to_dolist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.to_dolist.source.TaskItem
import com.example.to_dolist.source.TaskRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    val tasks = repository.allTasks
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addTask(task: TaskItem) {
        viewModelScope.launch {
            repository.addTask(task)
        }
    }

    fun updateTask(task: TaskItem) {
        viewModelScope.launch {
            repository.updateTask(task)
        }
    }

    fun deleteAllTasks() {
        viewModelScope.launch {
            repository.deleteAllTasks()
        }
    }

    fun deleteTask(task: TaskItem) = viewModelScope.launch {
        repository.deleteTask(task)
    }
}

class TaskViewModelFactory(private val repository: TaskRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            return TaskViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
