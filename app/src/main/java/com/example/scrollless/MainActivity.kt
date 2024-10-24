package com.example.scrollless

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scrollless.ui.theme.ScrollLessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScrollLessTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    GUIBackground(
                        name = "Background",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GUIBackground(name: String, modifier : Modifier = Modifier)
{
    val imageModifier = Modifier.size(1000.dp)
        .border(BorderStroke(1.dp, Color.Black))
        //.background(Color.Yellow)
    Image(
        painter = painterResource(R.drawable.background_01),
        contentDescription = "Background Image",
        contentScale = ContentScale.Fit,
        modifier = imageModifier
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    TextButton({buttonClick()})
    {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}

fun buttonClick(): Boolean {
    return true
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScrollLessTheme {
        Greeting("Android")
    }
}