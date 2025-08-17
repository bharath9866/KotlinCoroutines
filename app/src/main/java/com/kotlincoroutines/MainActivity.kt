package com.kotlincoroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.kotlincoroutines.core.App
import com.kotlincoroutines.ui.theme.KotlinCoroutinesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            KotlinCoroutinesTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFf9fafb))
                ) { innerPadding ->
                    App(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(
    backgroundColor = 0xFFFFFFFF, showBackground = true, showSystemUi = true, device = "id:pixel_xl"
)
@Composable
private fun MainActivityPreview() {
    KotlinCoroutinesTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFf9fafb))
                .windowInsetsPadding(WindowInsets.systemBars),
        ) { innerPadding ->
            App(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}