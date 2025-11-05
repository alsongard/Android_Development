package com.example.exercise_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercise_2.ui.theme.Exercise_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Exercise_2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FinishTask(
                        modifier = Modifier.padding(innerPadding),
                        taskStatus = stringResource(R.string.taskStatus),
                        taskShortMessage = stringResource(R.string.taskShortMessage)
                    )
                }
            }
        }
    }
}

@Composable
fun FinishTask(taskStatus:String, taskShortMessage: String, modifier:Modifier = Modifier)
{
    var myImage = painterResource(R.drawable.exercise_2_image)

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
    )
    {
        Image(
            painter = myImage,
            contentDescription = null
        )
        Text(
            text=taskStatus,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(
                    top = 24.dp,
                    bottom = 8.dp
                )
        )
        Text(
            text=taskShortMessage,
            fontSize = 16.sp,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Exercise_2Theme {
        FinishTask(taskStatus = stringResource(R.string.taskStatus), taskShortMessage = stringResource(R.string.taskShortMessage))
    }
}