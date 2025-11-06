package com.example.exercise_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exercise_3.ui.theme.Exercise_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Exercise_3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Notes(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Notes(modifier:Modifier = Modifier)
{
    Row (modifier = Modifier.fillMaxSize()) {
        Column (
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(200.dp)
                .fillMaxSize()
                .fillMaxWidth()
        ){
            Box (
                modifier = Modifier
                    .background(color = Color.hsl(279f, 0.75f, 0.79f))
            ) {
                Column(
                    modifier = modifier
                        .padding(5.dp)
                        .height(160.dp)
                ) {
                    Text(
                        text = "Text composable",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Text(
                        text = "Displays text and follows the recommended material design guidelines"
                    )
                }
            }

            Box (
                modifier = Modifier
                    .background(color = Color.hsl(278f, 0.85f, 0.50f))
            )
            {
                Column(
                    modifier = modifier
                        .padding(5.dp)
                        .height(160.dp)
                ) {
                    Text(
                        text = "Row composable",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Text(
                        text = "A layout composable that places it's children in a horizontal sequence"
                    )
                }
            }
        }
        Column (
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(200.dp)
                .fillMaxSize()
                .fillMaxWidth()
        ) {
            Box (
                    modifier = Modifier
                        .background(color = Color.hsl(275f, 0.52f, 0.48f))

            ) {
                Column(
                    modifier = modifier
                        .padding(5.dp)
                        .height(160.dp)

                ) {
                    Text(
                        text = "Image composable",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Text(
                        text = "Creates a composable that lays out and draws a given Painter class object"
                    )
                }
            }

            Box(
                modifier = Modifier
                    .background(color = Color.hsl(279f, 0.48f, 0.79f))

            ) {
                Column(
                    modifier = modifier
                        .padding(5.dp)
                        .height(160.dp)
                ) {
                    Text(
                        text = "Column composable",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Text(
                        text = "A layout composable that places its children in a vertical sequence"
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Exercise_3Theme {
        Notes()
    }
}