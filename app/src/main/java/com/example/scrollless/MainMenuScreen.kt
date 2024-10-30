package com.example.scrollless

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scrollless.learning.ScaffoldExample

// From Dustin: This syntax looks weird, but it's basically just syntactic Kotlin sugar.
// Kotlin classes have one or more constructors (one primary,
// possibly multiple secondary). The arguments for the primary constructor
// are defined in the class header (i.e. the primary constructor of this class
// takes a copy of our MainActivity class as an argument). The actual code for the
// primary constructor is stored in "init." So, init is the function body of the
// constructor, but the function definition is happening in the class header.
// I know, it's super weird syntax.
//
// Source: https://kotlinlang.org/docs/classes.html#constructors
class MainMenuScreen (app : MainActivity) : AppScreen
{
    // Technically, we can "join declaration and assignment." However, I find
    // this way of declaring and referencing variables to be more easy
    // on the eyes.
    private var app : MainActivity;

    init
    {
        this.app = app;
    }

    @Composable
    override fun BuildScreen()
    {
        BackgroundBox()
        //BackgroundScaffold()
        //ScaffoldExample()
        //BackgroundBox()
    }

//    @OptIn(ExperimentalMaterial3Api::class)
//    @Composable
//    fun BackgroundScaffold()
//    {
//        var presses by remember { mutableIntStateOf(0) }
//        Scaffold(
//            topBar = {
//                TopAppBar (
//                    title = {
//                        //Text("Top app bar")
//                        TitleLogo()
//                    },
//                    colors = TopAppBarColors(
//                        containerColor = Color.Transparent,
//                        titleContentColor = Color.Black,
//                        scrolledContainerColor = Color.Transparent,
//                        navigationIconContentColor = Color.Transparent,
//                        actionIconContentColor = Color.Transparent
//                    )
//                )
//            },
//            bottomBar = {
//                BottomAppBar(
//                    containerColor = MaterialTheme.colorScheme.primaryContainer,
//                    contentColor = MaterialTheme.colorScheme.primary,
//                ) {
//                    Text(
//                        modifier = Modifier.fillMaxWidth(),
//                        textAlign = TextAlign.Center,
//                        text = "Bottom app bar",
//                    )
//                }
//            },
//            floatingActionButton = {
//                FloatingActionButton(onClick = { presses++ }) {
//                    Icon(Icons.Default.Add, contentDescription = "Add")
//                }
//            }
//        )
//        { innerPadding ->
//            Column(
//                modifier = Modifier.padding(innerPadding),
//                verticalArrangement = Arrangement.spacedBy(16.dp),)
//            {
//                BackgroundBox()
//            }
//        }
//    }

    //The background box determines the dimensions of the image.
    @Composable
    fun BackgroundBox()
    {
        Box(modifier = Modifier.offset(0.dp, 0.dp).fillMaxSize())
        {
            BackgroundImg()
            TitleLogoBox()
            AddAlarmBtn()
        }
    }

    //The logo box goes inside the background box.
    @Composable
    fun TitleLogoBox()
    {
        Box(modifier = Modifier.offset(100.dp, 100.dp))
        {
            Text(
                text = "ScrollLess",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(20.dp),
                color = Color.White,
                fontSize = 30.sp
            )
        }
    }

    @Composable
    fun AddAlarmBtn()
    {
        Box(modifier = Modifier.offset(300.dp, 780.dp))
        {
            TextButton(onClick = { addAlarm() }, colors = ButtonDefaults.buttonColors(contentColor = Color.Yellow))
            {
                Text("Add Alarm")
            }
        }
    }

    //The background image is placed in the background box.
    @Composable
    fun BackgroundImg()
    {
        val imageModifier = Modifier.size(1000.dp).border(BorderStroke(1.dp, Color.Black))
        Image (
            painter = painterResource(R.drawable.background_01),
            contentDescription = "Background Image",
            contentScale = ContentScale.Fit,
            modifier = imageModifier
        )
    }

    fun addAlarm()
    {

    }
}