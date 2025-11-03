package com.example.happy_birthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.happy_birthday.ui.theme.Happy_birthdayTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Happy_birthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HappyBirthDay("Happy Birthday Sam!", from ="from Emma")
                }
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    HappyBirthDay("Happy Birthday Sam!", from ="from Emma")
//
//                }
            }
        }
    }
}

@Composable
fun HappyBirthDay(message:String, from: String, modifier: Modifier = Modifier)
{

    Column(
        verticalArrangement =  Arrangement.Center,
        modifier = modifier.padding(4.dp)
    ) {
        Surface(color=Color.Yellow) {
            Text(
                text = message,
                fontSize = 100.sp,
                lineHeight = 116.sp,
                color = Color.Black,
                modifier = modifier.padding(10.dp)
            )
        }
        Surface(color=Color.LightGray)
        {
            Text(
                text = from,
                fontSize = 36.sp,
                color = Color.Black,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight(56),
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment=Alignment.End)
            )
        }
        
    }

}

@Preview(showBackground = true, name="SwahiliPot")
@Composable
fun HappyBirthDayPreview() {
    Happy_birthdayTheme {
        HappyBirthDay("Happy Birthday Sam!", from ="from Emma")
    }
}