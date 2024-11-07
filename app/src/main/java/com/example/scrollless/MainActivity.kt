package com.example.scrollless

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
import com.example.scrollless.ui.theme.ScrollLessTheme


///** Launches the Android application.  */
//class MainActivity : AndroidApplication() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val configuration = AndroidApplicationConfiguration()
//        configuration.useImmersiveMode = true // Recommended, but not required.
//        initialize(MiniGame(), configuration)
//    }
//}

//This is a link to our Figma:
//      https://www.figma.com/design/igoFvUcyzVYHMlh3t3esIf/ScrollLess-POC?node-id=0-1&node-type=canvas&t=TGZkqnY6B7aDNQHY-0
// At this point, it's become abundantly clear that Compose UI actually sucks balls, but we've also spent enough time with it
// that moving to a different framework would be a pain in the ass.
// Just try to match the figma screens as best as you can.
class MainActivity : ComponentActivity()
{
    var curScreen : AppScreen? = null;
    val loadingScreen : AppScreen;
    val mainMenuScreen : AppScreen;
    val addAlarmScreen : AppScreen;

    init {
        loadingScreen  = LoadingScreen(this);
        mainMenuScreen = MainMenuScreen(this);
        addAlarmScreen = AddAlarmScreen();
    }


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        //Let's create our loading screen.


        //enableEdgeToEdge()
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

