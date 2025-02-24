package com.example.blogapplication.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blogapplication.ui.theme.BlogApplicationTheme

class PractisingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            BlogApplicationTheme {
                GreetingName("GANESH")
            }
        }
    }
}

@Composable

fun GreetingName(name: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Helo,$name",
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .padding(20.dp),
            color = Color.Black,
            fontSize = 22.sp
        )
        LazyRow(modifier = Modifier.fillMaxSize()) {
            items(10) { it ->
                Text(
                    text = "name",
                    modifier = Modifier
                        .height(12.dp)
                        .fillMaxSize()
                        .padding(20.dp),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GreetingName() {
    BlogApplicationTheme {
        GreetingName("GAN")
    }
}