package com.example.myapplication.navigation

import com.example.myapplication.R

sealed class BottomNavigationScreens (var title: String, var icon: Int, var screen_route: String) {
    object Home: BottomNavigationScreens(title = "Home", icon = R.drawable.baseline_home_24, screen_route = "home")
    object MyNetwork: BottomNavigationScreens(title = "Network", icon = R.drawable.baseline_people_24, screen_route = "my_network")
    object Post: BottomNavigationScreens(title = "Post", icon = R.drawable.baseline_add_24, screen_route = "post")
    object Notification: BottomNavigationScreens(title = "Notification", icon = R.drawable.baseline_notifications_24, screen_route = "notification")
    object Jobs: BottomNavigationScreens(title = "Jobs", icon = R.drawable.baseline_work_24, screen_route = "jobs")
}