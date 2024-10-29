package com.example.scrollless

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scrollless.ui.theme.ScrollLessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScrollLessTheme {
                //ScaffoldTextFields()
                CenterText("Name 1", "Name 2", "Name 3")
            }
        }
    }

    @Composable
    fun ScaffoldTextFields()
    {
        Box (modifier = Modifier.offset(30.dp, 30.dp)){
            GreetingMessage(name = "Android", modifier = Modifier.padding(1.dp))
            GreetingMessage(name = "Dustin", modifier = Modifier.padding(1.dp))
        }
    }
}





@Composable
fun CenterText(vararg names: String)
{
    Box (modifier = Modifier.offset(0.dp, 0.dp),)
    {
        val imageModifier = Modifier.size(1000.dp)
            .border(BorderStroke(1.dp, Color.Black))
        Image (
            painter = painterResource(R.drawable.background_01),
            contentDescription = "Background Image",
            contentScale = ContentScale.Fit,
            modifier = imageModifier
        )
        Box(modifier = Modifier.offset(30.dp, 30.dp))
        {
            Column()
            {
                var i = 0
                for(name in names)
                {
                    i++
                    Text(
                        text = "Hello World $i",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(20.dp),
                        color = Color.White
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
        modifier = imageModifier)

}

@Composable
fun GUIBackgroundText(name: String, modifier : Modifier = Modifier)
{
    Text(name, textAlign = TextAlign.Center, modifier = Modifier);
}

@Composable
fun GreetingMessage(name: String, modifier: Modifier = Modifier) {
    TextButton({buttonClick()})
    {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            color = Color.White
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
        GreetingMessage("Android")
    }
}