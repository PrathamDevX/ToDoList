package com.example.to_dolist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.to_dolist.source.Routes

@Composable
fun DrawerContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(270.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF5B61F4),
                        Color(0xFFAA5CC3)
                    )
                )
            )
            .padding(top = 50.dp, start = 16.dp)
    ) {
        NavigationDrawerItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            },
            label = {
                 Text(text = "Home", color = Color.White, fontSize = 18.sp)
            },
            selected = false,
            onClick = {
                navController.navigate(Routes.homeScreen)
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        NavigationDrawerItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            },
            label = {
                Text(text = "Profile", color = Color.White, fontSize = 18.sp)
            },
            selected = false,
            onClick = {
                navController.navigate(Routes.profileScreen)
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        NavigationDrawerItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            },
            label = {
                Text(text = "Settings", color = Color.White, fontSize = 18.sp)
            },
            selected = false,
            onClick = {
                navController.navigate(Routes.settingsScreen)
            }
        )
    }

}