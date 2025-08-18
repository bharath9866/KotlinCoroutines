package com.kotlincoroutines.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kotlincoroutines.home.components.ExpandCard
import com.kotlincoroutines.home.model.response


@Composable
fun Home(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val headingOneList by remember {
        mutableStateOf(response)
    }
    Surface(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Column {
            Text(
                text = response.title,
                modifier = Modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(headingOneList.topics, key = { it.topicId }) {
                    ExpandCard(
                        icon = it.icon,
                        title = it.topic,
                        topicsCount = it.subTopics.size,
                        subTopics = it.subTopics
                    )
                }
            }
        }
    }
}

@Composable
fun TitleComponent(text: String = "", onClick: () -> Unit = {}) {
    Button(onClick = onClick) {
        Text(text)
    }
}

@Preview
@Composable
private fun TitleComponentPreview() {
    TitleComponent(text = "Coroutine Basics")
}

@Preview(showBackground = true)
@Composable
private fun HomePreview() {
    Home(Modifier, rememberNavController())
}