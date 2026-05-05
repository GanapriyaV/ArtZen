package com.example.artzen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artzen.ui.theme.ArtZenTheme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtZenTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Calling ArtZenLayout instead of View to be consistent with the Preview
                    ArtZenLayout()
                }
            }
        }
    }
}

@Composable
fun View()
{
    var photo by remember{ mutableStateOf(1)}

    @Composable
    fun Screen(image: Int, @StringRes title: Int, @StringRes author: Int)
    {
        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom, modifier = Modifier.fillMaxSize())
        {
            Button(onClick = {photo -= 1}, modifier = Modifier.padding(5.dp))
            {
                Text(text = "Preview", fontSize = 16.sp)
            }

            Button(onClick = {photo += 1}, modifier = Modifier.padding(5.dp))
            {
                Text(text = "Next", fontSize = 16.sp)
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
        {
            Image(painter = painterResource(id = image),
                contentDescription = "Forest",
                modifier = Modifier
                    .padding(top = 36.dp, bottom = 18.dp, start = 18.dp, end = 18.dp)
                    .border(
                        3.dp,
                        Color.DarkGray,
                        RoundedCornerShape(1)
                    ))

            Column(modifier = Modifier
                .border(
                    1.dp,
                    Color.DarkGray,
                    RoundedCornerShape(5)
                )
                .padding(3.dp))

            {
                Text(text = stringResource(id = title), fontStyle = FontStyle.Italic, fontSize = 30.sp)
                Text(text = stringResource(id = author), fontSize = 20.sp)
            }
        }
    }

    when(photo)
    {
        0 ->    photo = 5
        1 ->    Screen(R.drawable.pexels_dc_productions_10367456, R.string.Sunrise_over_the_forest, R.string.Pexels)
        2 ->    Screen(R.drawable.pexels_eberhard_grossgasteiger_454880, R.string.Lake_in_the_forest, R.string.Pexels)
        3 ->    Screen(R.drawable.pexels_eberhard_grossgasteiger_443446, R.string.lake_at_the_foot_of_the_mountain, R.string.Pexels)
        4 ->    Screen(R.drawable.istockphoto_517188688_1024, R.string.Mountain_landscape, R.string.Biletskiy_Evgeniy)
        5 ->    Screen(R.drawable.istockphoto_485371557_612, R.string.Twilight_at_Spirit_Island, R.string.Biletskiy_Evgeniy)
        6 ->    photo = 1
    }
}

@Preview(showBackground = true)
@Composable
fun ArtZenLayoutPreview() {
    ArtZenTheme {
        ArtZenLayout()
    }
}

@Composable
fun ArtZenLayout() {
    View()
}
