package com.eloftee.lanaswims.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.eloftee.lanaswims.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanaSwimsApp() {
    Scaffold(
        topBar = {
            TopAppBar(title = { HeaderTitle() })
        } 
    ) {padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Today's Spot Summary")
        }
    }
}

@Composable
fun HeaderTitle() {
    val appIcon = painterResource(R.drawable.lanaswimsicon)
    Row (
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = appIcon,
            contentDescription = "LanaSwims Icon",
            modifier = Modifier
                .height(22.dp)
                .width(22.dp)
        )
        Text(text = "LanaSwims", fontWeight = FontWeight.Bold, modifier = Modifier.padding(6.dp))
    }
}