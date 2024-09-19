package com.example.blogapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blogapplication.ui.theme.BlogApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlogApplicationTheme {
                // A surface container using the 'background' color from the theme
//                Greeting("Hello Android")
                SampleApp()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(name.length) { _ ->
                Icon(
                    Icons.Default.Add, contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
            }
        }
        Column(modifier = Modifier.fillMaxHeight()) {
            Text(
                text = "Hello $name!",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red)
                    .padding(10.dp),
                color = Color.Black,
                fontFamily = FontFamily.Monospace,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                maxLines = 5,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Hello!",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue)
                    .padding(10.dp),
                color = Color.Black,
                fontFamily = FontFamily.Monospace,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                maxLines = 5,
                textAlign = TextAlign.End
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(20.dp))
            if (name.length > 5) {
                Icon(
                    Icons.Default.ArrowBack, contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(100.dp)
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = name,
                )
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun GreetingPreview() {
    BlogApplicationTheme {
//        Greeting("Testing")
        SampleApp()
    }
}

@Composable
fun SampleApp() {
    var count by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = count.toString(), fontSize = 16.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            count++
        }) {
            Text(text = "Click me!:  $count".uppercase())
        }
    }
}
