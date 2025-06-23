package com.example.to_dolist.source

object Routes {
    var homeScreen = "Home_Screen"
    var profileScreen = "Profile_Screen"
    var settingsScreen = "Settings_Screen"
    var addListScreen = "Add_List_Screen"
    var updateTaskScreen = "Update_Task_Screen"
    fun updateTaskScreenWithId(id: Int) = "Update_Task_Screen/$id"
}