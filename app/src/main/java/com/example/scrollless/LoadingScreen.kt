package com.example.scrollless

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LoadingScreen(app : MainActivity) : AppScreen
{
    private var app : MainActivity;

    init
    {
        this.app = app
    }

    //This function builds the screen as a single unified composable.
    @Composable
    override fun BuildScreen()
    {
        BackgroundBox()
    }

    //The background box determines the dimensions of the image.
    @Composable
    fun BackgroundBox()
    {
        Box(modifier = Modifier.offset(0.dp, 0.dp))
        {
            BackgroundImg()
            LogoBox()
        }
    }

    //The logo box goes inside the background box.
    @Composable
    fun LogoBox()
    {
        Box(modifier = Modifier.offset(100.dp, 300.dp))
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

    //The background image is placed in the background box.
    @Composable
    fun BackgroundImg()
    {
        val imageModifier = Modifier.size(1000.dp)
            .border(BorderStroke(1.dp, Color.Black))
        Image (
            painter = painterResource(R.drawable.background_01),
            contentDescription = "Background Image",
            contentScale = ContentScale.Fit,
            modifier = imageModifier
        )
    }
}