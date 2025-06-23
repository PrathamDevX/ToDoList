package com.example.to_dolist.source

import kotlinx.coroutines.flow.Flow

class TaskRepository(private val dao: TaskDao) {

    val allTasks: Flow<List<TaskItem>> = dao.getAllTasks()

    suspend fun addTask(task: TaskItem) = dao.insertTask(task)

    suspend fun updateTask(task: TaskItem) = dao.updateTask(task)

    suspend fun deleteAllTasks() = dao.deleteAll()

    suspend fun deleteTask(task: TaskItem) = dao.deleteTask(task)

}

