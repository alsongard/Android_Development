package com.example.happy_birthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happy_birthday.ui.theme.Happy_birthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Happy_birthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    BirthDayImage(stringResource(R.string.happy_birthday_text), from = stringResource(R.string.from_text))
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
        modifier = modifier.fillMaxSize(),
    )
    {
        Text(
            text = message,
            fontSize = 50.sp,
            lineHeight = 50.sp,
            color = Color.Black,
            fontWeight = FontWeight(150),
            textAlign = TextAlign.Center

        )
        Text(
            text = from,
            fontSize = 15.sp,
            color = Color.Black,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .align(alignment = Alignment.End)
        )
    }
}
// modifier is used to set out the layout of your composable function in the parent layout or the given layout:
// think of it as the designer for your component

@Composable
fun BirthDayImage(message:String, from:String, modifier:Modifier=Modifier){
    val image = painterResource(R.drawable.backiee_336024_landscape_little_anime_girl)
    // The painterResource() function loads a drawable image resource and takes resource ID (R.drawable.androidparty in this case) as an argument.
    val image2 = painterResource(R.drawable.backiee_336024_little_anime_girl_portrait)
    val myImage = painterResource(R.drawable.backiee_241584_landscape_game_dragon_warrior)
    Box(modifier = Modifier.fillMaxSize())
        {
            Image(
                painter = myImage,
                contentDescription = null,
                contentScale =  ContentScale.Crop,
                alpha=0.8F,
                modifier = Modifier.fillMaxSize()
            )

        HappyBirthDay(
            message=message,
            from = from
        )
    }
}

@Preview(showBackground = true, name="SwahiliPot")
@Composable
fun HappyBirthDayPreview() {
    Happy_birthdayTheme {
        BirthDayImage(stringResource(R.string.happy_birthday_text), from = stringResource(R.string.from_text))
    }
}

//        HappyBirthDay("Happy Birthday Sam!", from ="from Emma")
