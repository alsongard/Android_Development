package com.example.art_space_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
fun EditImageLayout(
    modifier: Modifier,
    @DrawableRes myImage: Int,
    @StringRes textTitle: Int,
    @StringRes textDescription: Int
) {
    Column(
        modifier = modifier.fillMaxHeight().padding(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. Image Section
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f) // Take 80% of width for balanced look
                .padding(vertical = 5.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Image(
                painter = painterResource(myImage),
                contentDescription = stringResource(textTitle),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(550.dp), // Fixed height for consistency
                contentScale = ContentScale.Crop // Crop to fill the space without distortion
            )
        }

        Spacer(modifier = Modifier.height(12.dp)) // Space between image and text

        // 2. Title Section
        Text(
            text = stringResource(textTitle),
            style = MaterialTheme.typography.headlineLarge, // Large, prominent title
            color = MaterialTheme.colorScheme.primary, // Use theme's primary color
            modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Center, // Center align for better readability
            fontWeight = FontWeight.Bold // Bold for emphasis
        )

        Spacer(modifier = Modifier.height(3.dp)) // Small gap between title and description

        // 3. Description Section
        Text(
            text = stringResource(textDescription),
            style = MaterialTheme.typography.bodyLarge, // Larger body text for readability
            color = MaterialTheme.colorScheme.onSurfaceVariant, // Slightly muted color
            modifier = Modifier.padding(horizontal = 24.dp),
            textAlign = TextAlign.Center, // Center alignment
            lineHeight = 24.sp // Increased line height for better readability
        )
    }
}

@Composable
fun ArtWork(modifier: Modifier = Modifier) {
    var imageNum by remember { mutableIntStateOf(0) }

    val getImageInfo = when (imageNum) {
        0 -> Triple(R.string.sasukeTitle, R.string.sasukeDescription, R.drawable.sasuke_wings)
        1 -> Triple(R.string.darkGothTitle, R.string.darkGothDescription, R.drawable.non_emotion_anime_girl)
        2 -> Triple(R.string.katanaTitle, R.string.katanaDescription, R.drawable.sensei_katana)
        3 -> Triple(R.string.chillOutTitle, R.string.chillOutDescription, R.drawable.chill_out_anime)
        else -> Triple(R.string.sasukeTitle, R.string.sasukeDescription, R.drawable.sasuke_wings)
    }

    // 4. Main Container with gradient background
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1A237E), // Dark blue at top
                        Color(0xFF3949AB), // Medium blue
                        Color(0xFFE8EAF6)  // Light blue/white at bottom
                    )
                )
            )
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(vertical = 10.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
//            verticalArrangement = Arrangement.SpaceBetween // Space between image and buttons
        ) {
            // 5. Image Layout (takes most space)
            EditImageLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), // Takes available space
                myImage = getImageInfo.third,
                textTitle = getImageInfo.first,
                textDescription = getImageInfo.second
            )

            Spacer(modifier = Modifier.height(11.dp)) // Space before buttons

            // 6. Navigation Buttons
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                ),
                shape = RoundedCornerShape(24.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Previous Button
                    Button(
                        onClick = {
                            imageNum = if (imageNum <= 0) 3 else imageNum - 1
                            println("imageNum is (-) $imageNum")
                        },
                        modifier = Modifier
                            .weight(0.45f) // 45% of available width
                            .height(56.dp), // Standard button height
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(12.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 4.dp,
                            pressedElevation = 2.dp
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Previous",
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Text(
                                text = "Previous",
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(16.dp)) // Space between buttons

                    // Next Button
                    Button(
                        onClick = {
                            imageNum = if (imageNum >= 3) 0 else imageNum + 1
                            println("imageNum is (+) $imageNum")
                        },
                        modifier = Modifier
                            .weight(0.45f)
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(12.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 4.dp,
                            pressedElevation = 2.dp
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Next",
                                fontWeight = FontWeight.Medium
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = "Next",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
            }

            // 7. Image Counter (Visual feedback of current position)
            Text(
                text = "${imageNum + 1} / 4",
                style = MaterialTheme.typography.labelLarge,
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtWorkPreview() {
    ArtWork(
        modifier = Modifier.fillMaxSize()
    )
}
