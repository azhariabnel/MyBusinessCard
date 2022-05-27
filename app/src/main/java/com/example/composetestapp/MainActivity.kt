package com.example.composetestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetestapp.ui.theme.ComposeTestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBCard()
                }
            }
        }
    }
}

@Composable
fun CreateBCard() {
    val buttonState = remember{
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(400.dp)
                .padding(15.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            backgroundColor = Color.Gray,
            elevation = 5.dp
        ) {
            Column(modifier = Modifier.height(300.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {
                CreateImageProfile()
                Divider(
                    Modifier
                        .padding(10.dp)
                        .height(5.dp), Color.Black)
                CreateInfo()
                Button(onClick = {
                    buttonState.value = !buttonState.value
                }
                ) {

                    Text(text = "Portfolio", style = MaterialTheme.typography.button)
                }
                if (buttonState.value){
                    CreateContent()
                } else {
                    Box(){

                    }
                }
            }
        }

    }
}
@Preview
@Composable
fun CreateContent(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp),
        shape = RoundedCornerShape(corner = CornerSize(5.dp)),
        border = BorderStroke(width = 3.dp, color = Color.Black)){

            Portfolio(data = listOf("Opsicorp","Digitravel","Arrangge","Kimia Farma Mobile","Kimia Farma Home Pharmacy Care"),)
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {

    LazyColumn{
        items(data){ item ->
            Card(modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            shape = RectangleShape,
            elevation = 5.dp) {
                Row(modifier = Modifier
                    .padding(3.dp)
                    .background(MaterialTheme.colors.background)
                    .padding(10.dp)) {
                    CreateImageContent()
                    Column(modifier = Modifier
                        .padding(8.dp)
                        .align(alignment = Alignment.CenterVertically)) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "Available on Play Store", style = MaterialTheme.typography.body2)
                    }
                }
            }
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Azhari Abnel",
            fontSize = 24.sp,
            color = Color.White,
            style = MaterialTheme.typography.h3
        )
        Text(
            text = "Android Developer",
            Modifier.padding(3.dp),
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.subtitle2
        )
        Text(
            text = "@AriAbnel",
            Modifier.padding(3.dp),
            fontSize = 16.sp,
            color = Color.White,
            style = MaterialTheme.typography.subtitle2
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.Gray),
        elevation = 5.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.sample_photo),
            contentDescription = "profile image"
        )
    }
}

@Composable
private fun CreateImageContent(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(50.dp)
            .padding(5.dp),
        shape = CircleShape,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.ic_android_white),
            contentDescription = "content image"
        )
    }
}

/*@Preview(showBackground = true)*/
@Composable
fun DefaultPreview() {
    ComposeTestAppTheme {
        CreateBCard()
    }
}