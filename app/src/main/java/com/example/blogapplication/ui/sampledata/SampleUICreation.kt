package com.example.blogapplication.ui.sampledata

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blogapplication.R
import com.example.blogapplication.ui.theme.white
import com.example.blogapplication.ui.viewmodel.SampleViewModel

@Preview(
    showBackground = true
)
@Composable
fun CreateNewSampleData(sampleViewModel: SampleViewModel) {

    val sampleData by sampleViewModel.sampleList.observeAsState()
    var userName by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(value = userName, onValueChange = {
                userName = it
            })
            Button(onClick = {
                sampleViewModel.addAllSamples(userName)
                userName = ""
            }) {
                Text(text = "Add")
            }
        }

        sampleData?.let {
            LazyColumn(content = {
                itemsIndexed(it) { index: Int, item: SampleData ->
                    CreateItems(item, index, onDelete = {
                        Log.v("numberIndex", item.id.toString())
                        sampleViewModel.deleteAllSamples(item.id)
                    })
                }
            })
        } ?: Text(
            text = "No Items in List",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Composable
fun CreateItems(item: SampleData, index: Int, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Row() {
                Text(text = item.name + ", " + item.gender, color = white, fontSize = 16.sp)
            }
            Text(text = item.number.toString(), color = white, fontSize = 22.sp)
        }
        IconButton(
            onClick = onDelete
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Delete",
                tint = white
            )
        }
    }
}

