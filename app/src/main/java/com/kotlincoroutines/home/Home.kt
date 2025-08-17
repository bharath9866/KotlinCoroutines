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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun Home(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val headingOneList = remember {
        mutableListOf(
            Pair(0, "Coroutine Basics"),
            Pair(1, "Coroutine Basics"),
            Pair(2, "Coroutine Contexts"),
            Pair(3, "Coroutine Cancellation"),
            Pair(4, "Coroutine Error Handling"),
            Pair(5, "Combining What You've Learnt So Far"),
            Pair(6, "Coroutine Synchronization"),
            Pair(7, "Flow Fundamentals"),
            Pair(8, "Flows In Practice"),
            Pair(9, "Testing Coroutines & Flows")
        )
    }
    Surface(modifier = modifier.fillMaxSize()) {
        Column {
            Text(text ="Kotlin Coroutines Masterclass")
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(headingOneList, key = {it.first}) {
                    TitleComponent(text = it.second) {
                        navController.navigate("course/${it.first}")
                    }
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

@Preview
@Composable
private fun HomePreview() {
    Home(Modifier, rememberNavController())
}