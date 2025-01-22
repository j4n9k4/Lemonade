package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.dimensionResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                lemonadeApp()
            }

        }
    }
}

@Composable
fun lemonadeApp(modifier: Modifier = Modifier.fillMaxSize()) {

    var index by remember { mutableStateOf(0) }
    var randomTap = (2..4).random()
    var tapCount = 1

    val images = arrayOf(
        painterResource(R.drawable.lemon_tree),
        painterResource(R.drawable.lemon_squeeze),
        painterResource(R.drawable.lemon_drink),
        painterResource(R.drawable.lemon_restart)
        )
    val texts = arrayOf(
        stringResource(R.string.first_page_msg),
        stringResource(R.string.second_page_msg),
        stringResource(R.string.third_page_msg),
        stringResource(R.string.fourth_page_msg)
    )

    val contentDescriptions = arrayOf(
        stringResource(R.string.fp_content),
        stringResource(R.string.sp_content),
        stringResource(R.string.tp_content),
        stringResource(R.string.fthp_content)
    )

    var image = images[index]
    var text = texts[index]
    var contentDescription = contentDescriptions[index]
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        )
    {
        Surface(
            color = Color(245, 229, 104),
            modifier = modifier
                .weight(0.05F)
                .align(Alignment.CenterHorizontally)
        )
        {
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
                Text(
                    text = "Lemonade",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }

        Surface(modifier.weight(0.4F)) {
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        when(index)
                        {
                            0, 2 -> index++
                            1 -> if (randomTap == tapCount)
                            {
                                index++
                                randomTap = (2..4).random()
                                tapCount = 1
                            }
                                else {
                                tapCount++
                            }
                            
                            3 -> {
                                index = 0
                            }
                        }
                    },
                    colors = ButtonColors(
                        contentColor = Color.Gray,
                        containerColor = Color(red = 203, green = 235, blue = 212),
                        disabledContentColor = Color.Gray,
                        disabledContainerColor = Color.Gray
                    ),
                    shape = RoundedCornerShape(40.dp)
                )
                {
                    Image(
                        painter = image,
                        contentDescription = contentDescription

                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = text,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeTheme {
        lemonadeApp()
    }
}