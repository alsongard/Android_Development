package com.example.courses_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import  androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses_app.dataSource.DataSource
import com.example.courses_app.model.TopicModel
import com.example.courses_app.ui.theme.Courses_APPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                Courses_APPTheme {
                    Scaffold { innerPadding ->
                        CourseListView(DataSource().getTopics(), modifier = Modifier.padding(innerPadding))
}
                }


        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier ) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Courses_APPTheme {
//        Greeting("Android")
//    }
//}

@Preview
@Composable
fun CoursePreview(){
    CourseListView(DataSource().getTopics(), modifier = Modifier)
}


@Composable
fun CourseCard(theCourseItem: TopicModel){
    println("theCourseItem") // 192.168.100.4
    println(theCourseItem)
    Card(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth().height(200.dp)){
            Image(
                painter = painterResource(theCourseItem.courseImage),
                contentDescription = stringResource(theCourseItem.courseTitle),
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(200.dp).width(85.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

//                horizontalAlignment: Alignment.Horizontal = Alignment.Start,
                modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(vertical = 10.dp)
            ) {
                Text(text=stringResource(theCourseItem.courseTitle))
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
//                    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
//                verticalAlignment: Alignment.Vertical = Alignment.Top
                ) {
                    Image(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = "theIcon", modifier = Modifier.height(45.dp).width(35.dp))
                    Text(text=theCourseItem.courseNumber)
                }
            }
        }
    }
}


@Composable
fun CourseListView(courseLists: List<TopicModel>, modifier: Modifier = Modifier.fillMaxSize())
{
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 140.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 10.dp),
        modifier = modifier
    ) {

        items(courseLists) { courseItem ->
            CourseCard(courseItem)
        }
    }
//    LazyColumn(modifier = Modifier) {
//        items(courseLists){ courseItem ->
//            CourseCard(courseItem)
//        }
//    }
}

