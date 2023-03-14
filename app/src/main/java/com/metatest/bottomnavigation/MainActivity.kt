package com.metatest.bottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.metatest.bottomnavigation.ui.theme.BottomnavigationTheme
import com.metatest.bottomnavigation.ui.theme.Destinations
import com.metatest.bottomnavigation.ui.theme.HomeScreenO
import com.metatest.bottomnavigation.ui.theme.SettingsScreenO


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
              MyApp()
            }

    }
}


@Composable
fun MyApp() {
    val navC = rememberNavController()

    Scaffold(bottomBar = { MyBottomNavigation(navControl = navC)}) {
        Box(Modifier.padding(it)) {
            NavHost(navController = navC, startDestination = HomeScreenO.route) {
                composable(HomeScreenO.route){
                    HomeScreen()
                }

                composable(SettingsScreenO.route) {
                    SetScreen()
                }
            }
        }
        
        
    }

}


@Composable
fun MyBottomNavigation(navControl :NavController) {
    val destinationList = listOf<Destinations>(

        HomeScreenO,
        SettingsScreenO
                                               )

    val selectedIndex = rememberSaveable{
        mutableStateOf(0)

    }
    
  BottomNavigation() {
      destinationList.forEachIndexed{index, destinations ->
          BottomNavigationItem(
          label =  { Text(text = destinations.title)},


          icon = {Icon(imageVector = destinations.icon, contentDescription = destinations.title )},

          selected = index == selectedIndex.value,
          onClick = {

              selectedIndex.value = index

              navControl.navigate(destinationList[index].route) {

                       popUpTo(HomeScreenO.route)
                       launchSingleTop = true


                    }

               })


      }
  }
      
  
}