package com.example.jettip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.jettip.ui.theme.JetTipTheme
import com.example.jettip.ui.theme.Purple80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetTipTheme {
                MainScreen()
            }
        }
    }
}

//@Preview
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        TotalBill()
        SetParameters()
    }
}

@Composable
fun TotalBill(
    modifier: Modifier=Modifier,
    bill:String="$100"
) {
    Surface(
        modifier= modifier
            .fillMaxWidth()
            .padding(
                start = 15.dp,
                end = 15.dp,
                top = 15.dp,
                bottom = 15.dp
            ),
        color= Purple80,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Total Per Person",
                textAlign = TextAlign.Center,
                fontSize = TextUnit(25f, TextUnitType.Sp),
                fontFamily = FontFamily(
                    Font(R.font.rubik_semibold)
                ),
                modifier=modifier.padding(
                    top=20.dp
                )
            )
            Text(
                text = bill,
//                modifier=modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = TextUnit(40f, TextUnitType.Sp),
                fontFamily = FontFamily(
                    Font(R.font.rubik_bold)
                ),
                modifier=modifier.padding(
                    bottom = 20.dp
                )
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SetParameters(
    modifier: Modifier=Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 10.dp,
                end = 10.dp
            ),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            5.dp
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp,
                    end = 10.dp,
                    top = 10.dp
                )
        ) {
            var text by rememberSaveable {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = text,
                onValueChange = {
                    text=it
                },
                modifier=modifier.fillMaxWidth(),
                leadingIcon = {
                    Text(text = "$")
                },
                label={
                    Text(text = "Enter Bill")
                },
                placeholder = {
                    Text(text = "Enter Bill")
                },
                keyboardOptions= KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                )
            )
            Row(
                modifier= modifier
                    .fillMaxWidth()
                    .padding(
                        top = 10.dp
                    )
            ) {
                Text(
                    text = "Split",
                    modifier=modifier.weight(1f)
                )
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier =  modifier.weight(1f)
                ) {
                    Surface(
                        shape = CircleShape,
                        shadowElevation=2.5.dp,
                        modifier = modifier.clickable {}
                    ){
                        Box(
                            contentAlignment = Alignment.Center
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.plus),
                                contentDescription ="Add",
                                modifier=modifier.size(25.dp)
                            )
                        }
                    }
                    Text(
                        text =  "1",
                        modifier=modifier.padding(
                            start = 10.dp,
                            end=10.dp
                        ),
                        fontSize = TextUnit(20f,TextUnitType.Sp)
                    )
                    Surface(
                        shape = CircleShape,
                        shadowElevation=2.5.dp,
                        modifier = modifier.clickable {}
                    ){
                        Box(
                            contentAlignment = Alignment.Center
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.minus),
                                contentDescription ="Remove",
                                 modifier=modifier.size(25.dp)
                            )
                        }
                    }
                }
            }
            Row(
                modifier= modifier
                    .fillMaxWidth()
                    .padding(
                        top = 10.dp
                    )
            ) {
                Text(
                    text = "Tip",
                    modifier=modifier.weight(1.5f)
                )
                Text(
                    text = "$33.0",
                    modifier=modifier.weight(1f)
                )
            }
            Text(
                text = "33%",
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        top = 10.dp
                    )
                ,
                textAlign = TextAlign.Center
            )
            var sliderPosition by remember {
                mutableStateOf(0f)
            }
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.secondary,
                    activeTrackColor = MaterialTheme.colorScheme.secondary,
                    inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                ),
                valueRange = 0f..100f
            )
        }
    }
}