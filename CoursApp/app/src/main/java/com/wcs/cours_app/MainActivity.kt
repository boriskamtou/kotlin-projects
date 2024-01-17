package com.wcs.cours_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wcs.cours_app.model.Topic
import com.wcs.cours_app.ui.theme.CoursAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicApp()
                }
            }
        }
    }
}

@Composable
fun TopicApp() {

}

@Composable
fun TopicList(topics: ) {

}


@Composable
fun TopicItem(topic: Topic, modifier: Modifier = Modifier) {

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursAppTheme {
        TopicApp()
    }
}