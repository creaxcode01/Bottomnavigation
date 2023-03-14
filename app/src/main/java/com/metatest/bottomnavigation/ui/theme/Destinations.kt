package com.metatest.bottomnavigation.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

interface Destinations { // in interface u can declare value but not initialise it
    val route: String
    val icon: ImageVector
    val title: String
}

object HomeScreenO : Destinations { // hérite de Destinations
    override val route = "Home"
    override val icon = Icons.Filled.Home
    override val title = "Home"
}

object SettingsScreenO : Destinations { // hérite de Destinations
    override val route = "Settings"
    override val icon = Icons.Filled.Settings
    override val title = "Settings"

}