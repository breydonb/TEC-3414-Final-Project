package com.example.scrollless

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.scrollless.ui.theme.ScrollLessTheme

class MainActivity : ComponentActivity()
{
    var curScreen : AppScreen? = null;

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        //Let's create our loading screen.
        val loadingScreen = LoadingScreen(this)
        val mainMenuScreen = MainMenuScreen(this)
        val addAlarmScreen = AddAlarmScreen()

        enableEdgeToEdge()
        setScreen(mainMenuScreen)
        //setScreen(loadingScreen)
    }

    fun setScreen(screen : AppScreen)
    {
        this.curScreen = screen;
        setContent {
            ScrollLessTheme {
                curScreen!!.BuildScreen()
            }
        }
    }
}

