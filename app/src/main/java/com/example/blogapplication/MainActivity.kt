package com.example.blogapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blogapplication.ui.theme.BlogApplicationTheme
import com.example.blogapplication.ui.theme.newBlack
import com.example.blogapplication.ui.theme.newBlue
import com.example.blogapplication.ui.theme.newOrange
import com.example.blogapplication.ui.theme.newWhite
import com.example.blogapplication.ui.theme.newYellow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlogApplicationTheme {
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
        CustomizedDesignForTextFields()
    }
}

@Composable
fun CustomizedDesignForTextFields() {
    var firstTextName by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.Red)
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            OutlinedTextField(
                value = firstTextName,
                onValueChange = { newValue ->
                    firstTextName = newValue
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                textStyle = TextStyle(fontSize = 16.sp),
                /*
                                label = { Text(text = "Enter Name") },
                */
                placeholder = {
                    Text(
                        text = "Enter text here",
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(start = 50.dp)
                    )
                },
                colors = TextFieldDefaults.colors(
                    /*focusedPlaceholderColor = newYellow,
                    unfocusedPlaceholderColor = newWhite,*/
                    /*unfocusedContainerColor = newWhite,
                    focusedContainerColor = newOrange,*/
                    /*focusedIndicatorColor = newYellow,
                    unfocusedIndicatorColor = newBlue*/
                    /*focusedTextColor = Color.Red,
                    unfocusedTextColor = Color.White*/
                ),
                shape = RoundedCornerShape(16.dp)
            )
        }
    }
}

