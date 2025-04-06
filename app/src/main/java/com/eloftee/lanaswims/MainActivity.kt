package com.eloftee.lanaswims

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.eloftee.lanaswims.ui.LanaSwimsApp
import com.eloftee.lanaswims.ui.theme.LanaSwimsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LanaSwimsTheme {
                LanaSwimsApp()
            }
        }
    }
}
