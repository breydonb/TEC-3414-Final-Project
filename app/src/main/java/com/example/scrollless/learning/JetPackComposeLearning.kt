package com.example.scrollless.learning

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scrollless.R
import com.example.scrollless.ui.theme.ScrollLessTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    var presses by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Top app bar")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { presses++ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text =
                """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button $presses times.
                """.trimIndent(),
            )
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
    TextButton({ buttonClick() })
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

@Composable
fun ScaffoldTextFields()
{
    Box (modifier = Modifier.offset(30.dp, 30.dp)){
        GreetingMessage(name = "Android", modifier = Modifier.padding(1.dp))
        GreetingMessage(name = "Dustin", modifier = Modifier.padding(1.dp))
    }
}