package com.example.to_dolist.source

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<TaskItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskItem)

    @Update
    suspend fun updateTask(task: TaskItem)

    @Query("DELETE FROM tasks")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteTask(task: TaskItem)

}
