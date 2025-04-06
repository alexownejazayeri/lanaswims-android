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
import androidx.compose.foundation.lazy.LazyColumn
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
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.core.entry.entryModelOf


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanaSwimsApp() {
    val timeLabels = listOf("12am", "1am", "2am", "3am", "4am")
    val tideData = listOf(0f, 0.5f, 1.2f, 2.5f, 3.0f)

    Scaffold(
        topBar = {
            TopAppBar(title = { HeaderTitle() })
        } 
    ) {padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
        ) {
            item {
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
            }

            item {
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
                        model = entryModelOf(*tideData.toTypedArray()),
                        startAxis = null,
                        bottomAxis = rememberBottomAxis(
                            guideline = null,
                            valueFormatter = { x, _ ->
                                timeLabels.getOrNull(x.toInt()) ?: ""
                            }
                        ),
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }

            item {
                Text(
                    text = "Today's Spot Summary",
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    Text(
                        text = "Future spot summary",
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    Text(
                        text = "Future time to next tide",
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
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