package com.example.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.navigation.BottomNavigationScreens
import com.example.myapplication.navigation.NavGraph
import kotlinx.coroutines.launch

@Composable
fun ScaffoldComponent() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()

    val navController = rememberNavController()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBarContent(onMenuClicked = {
                coroutineScope.launch {
                    scaffoldState.drawerState.open()
                }
            })
        },
        bottomBar = { BottomAppBarContent(navController = navController) }
    ) {
        NavGraph(navController = navController)
    }
}

@Composable
fun TopAppBarContent(onMenuClicked: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Scaffold", color = Color.White) },
        navigationIcon = { Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menu",
            modifier = Modifier.clickable(onClick = onMenuClicked),
            tint = Color.White
        ) }
    )
}

@Composable
fun BottomAppBarContent(navController: NavController) {
    val items = listOf(
        BottomNavigationScreens.Home,
        BottomNavigationScreens.MyNetwork,
        BottomNavigationScreens.Post,
        BottomNavigationScreens.Notification,
        BottomNavigationScreens.Jobs
    )

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.purple_700),
        contentColor = Color.Black
    ) {
        val navStackBackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navStackBackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title)},
                label = { Text(text = item.title, fontSize = 8.sp) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun BottomNavScreen(text: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Composable
fun HomeScreen() {
    BottomNavScreen(text = "Home Screen")
}

@Composable
fun MyNetworkScreen() {
    BottomNavScreen(text = "My Network Screen")
}
@Composable
fun PostScreen() {
    BottomNavScreen(text = "Add Post Screen")
}
@Composable
fun NotificationScreen() {
    BottomNavScreen(text = "Notification Screen")
}
@Composable
fun JobScreen() {
    BottomNavScreen(text = "Job Screen")
}

