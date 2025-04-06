package com.eloftee.lanaswims.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eloftee.lanaswims.R
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.core.entry.entryModelOf

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
        ) {
            Text(
                text = "Berkeley Marina Tide Chart",
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                lineHeight = 36.sp,
                letterSpacing = 0.5.sp,
                fontSize = 32.sp,
                modifier = Modifier
                    .width(256.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Sunday, April 6",
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(216.dp)

            ) {
                Chart(
                    chart = lineChart(),
                    model = entryModelOf(*listOf(1.2f, 2.5f, 3.0f, 4.1f, 2.8f).toTypedArray()),
                    modifier = Modifier
                        .fillMaxSize()
                )
            }


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