package com.example.compose_article_exercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_article_exercise.ui.theme.Compose_Article_ExerciseTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_Article_ExerciseTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    JetPackTutorial(stringResource(R.string.header), stringResource(R.string.subheader),
//                        stringResource(R.string.content)
//                    )
//                }

                Scaffold()
                {
                    innerPadding-> JetPackTutorial( stringResource(R.string.header), stringResource(R.string.subheader),
                    stringResource(R.string.content),  modifier = Modifier.padding(innerPadding))
                }

            }
        }
    }
}

//                    TutorialApp(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )

@Composable
fun JetPackTutorial(header: String, subHeader:String, content:String, modifier: Modifier = Modifier)
{
    val image = painterResource(id=R.drawable.bg_compose_background)
    Column(
        modifier = modifier.fillMaxSize()
    )
    {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text =header,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 10.dp,
                    bottom = 10.dp
                )
            ,
            textAlign = TextAlign.Center
        )
        Text(
            text=subHeader,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 16.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
            fontSize = 16.sp,
        )
        Text(
            text=content,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun TutorialApp(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_Article_ExerciseTheme {
        JetPackTutorial(stringResource(R.string.header), stringResource(R.string.subheader),
            stringResource(R.string.content)
        )
    }
}