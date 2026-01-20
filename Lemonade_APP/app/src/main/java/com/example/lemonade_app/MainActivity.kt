package com.example.lemonade_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade_app.ui.theme.Lemonade_APPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lemonade_APPTheme {
                LemonadePreview()
            }
        }
    }
}
// parameter:argument values given to a function are not reassignable only read-only
fun addition(myval:Int): Int
{
    var myvalue:Int
    if (myval >= 4)
    {
        myvalue = 0
    }
    else
    {
        myvalue  =  myval + 1
    }
//    println("myvalue: $myvalue");
    return myvalue
}

@Composable
fun LemonadeMaker(modifier: Modifier=Modifier)
{
    var myImage by remember { mutableIntStateOf(R.drawable.lemon_tree) }
    var result by remember { mutableIntStateOf(1) }
    var myString by remember { mutableIntStateOf(R.string.contentdesc_lemon_tree) }
    var buttonText by remember { mutableIntStateOf(R.string.lemon_tree) }

    val toDestructureImageString = when(result)
    {
        1 -> Triple(R.drawable.lemon_tree , R.string.contentdesc_lemon_tree, R.string.lemon_tree)
        2 -> Triple(R.drawable.lemon_squeeze , R.string.contentdesc_lemon_squeeze, R.string.lemon_squeeze)
        3 -> Triple(R.drawable.lemon_drink , R.string.contentdesc_lemon_drink, R.string.lemon_drink)
        else -> Triple(R.drawable.lemon_restart , R.string.contentdesc_lemon_start, R.string.lemon_start)
    }

    myImage = toDestructureImageString.first
    myString = toDestructureImageString.second
    buttonText = toDestructureImageString.third

    Column(
        modifier = modifier
            .fillMaxSize()
        ,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color.hsl(52f, 80f, 80f), Color.hsl(82f, 80f, 80f))
                    )
                )
                .height(50.dp)
            ,
            textAlign = TextAlign.Center,
            text="Lemonade",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            lineHeight = 50.sp,
            fontSize = 20.sp
        )
        Spacer(
            modifier = Modifier.height(250.dp) // 250
        )
        Image(painter = painterResource(myImage), contentDescription = stringResource(myString))
        Button(onClick = {
            result = addition(result)
        }) {
            Text(
                text = stringResource(buttonText)
            )
        }
    }
}


@Preview
@Composable
fun LemonadePreview(modifier: Modifier= Modifier)
{
    LemonadeMaker(modifier
        .fillMaxSize()
        .wrapContentSize()
    )
}