package com.example.art_space_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.art_space_app.ui.theme.Art_Space_AppTheme
import kotlinx.serialization.builtins.TripleSerializer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Art_Space_AppTheme {
                ArtWork(modifier=Modifier)
            }
        }
    }
}
@Composable
fun EditImageLayout(modifier: Modifier, @DrawableRes myImage: Int, @StringRes textTitle:Int, @StringRes textDescription:Int)
{
    Image(
        painter = painterResource(myImage),
        contentDescription = stringResource(textTitle),
    )

    Text(text=stringResource(textTitle))
    Text(text=stringResource(textDescription))

}
@Composable
fun ArtWork(modifier: Modifier=Modifier)
{
    var imageNum  by remember { mutableIntStateOf(0) }


    var getImageInfo = when (imageNum)
    {
        0 -> Triple(R.string.sasukeTitle, R.string.sasukeDescription, R.drawable.sasuke_wings)
        1 -> Triple(R.string.darkGothTitle, R.string.darkGothDescription, R.drawable.non_emotion_anime_girl)
        2 -> Triple(R.string.katanaTitle, R.string.katanaDescription, R.drawable.sensei_katana)
        3 -> Triple(R.string.chillOutTitle, R.string.chillOutDescription, R.drawable.chill_out_anime)
        else -> Triple(R.string.sasukeTitle, R.string.sasukeDescription, R.drawable.sasuke_wings)
    }
    Column(
    )
    {
        EditImageLayout(modifier.fillMaxSize(),getImageInfo.third, getImageInfo.first, getImageInfo.second)

        Row() {
            Button(onClick = {
                imageNum = if (imageNum <= 0 ) 3 else imageNum -1
                println("imageNum is (-) $imageNum")
            }) {
                Text(text="Previous")
            }
//            Spacer(modifier.padding(horizontal = 1.dp).width(2.dp))
            Button(onClick = {
                imageNum = if (imageNum >= 3) 0 else imageNum + 1
                println("imaggenum is (+) $imageNum")
            }){
                Text(text="Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtWorkPreview()
{
    ArtWork(
        modifier = Modifier.fillMaxSize()
    )
}

