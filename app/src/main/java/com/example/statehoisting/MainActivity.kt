package com.example.statehoisting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.statehoisting.ui.theme.StateHoistingTheme
import androidx.compose.material3.Card
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateHoistingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StateHoistingTheme {
        Greeting("Android")
    }
}

@Composable
fun Dollar(){
    val counter = remember {
        mutableStateOf(1)
    }
    Column(
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {


    Text(
        text = " ${counter.value*100}Dollar",
        fontSize = 40.sp
    )
    Spacer(modifier  =  Modifier.height(100.dp))
        Row(modifier = Modifier.padding(10.dp)){

            CustomButton{
                counter.value++
            }

            CustomButton2 {
                counter.value = 0
            }
        }
}}
@Composable
fun CustomButton(onClick:()->Unit){
    Card(modifier = Modifier
        .size(120.dp)
        .clickable {
            onClick.invoke()
        },shape = CircleShape,colors = CardDefaults.cardColors(
        containerColor = Color.Yellow,
        contentColor = Color.Blue,
        disabledContainerColor = Color.Gray,
        disabledContentColor = Color.DarkGray
    ) ){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text="Tap", style  = MaterialTheme.typography.titleLarge)
    }
    }
}
@Composable
fun CustomButton2(onClick:()->Unit){
    Card(modifier = Modifier.padding(10.dp)
        .size(120.dp)
        .clickable {
            onClick.invoke()
        },shape = CircleShape,colors = CardDefaults.cardColors(
        containerColor = Color.Yellow,
        contentColor = Color.Blue,
        disabledContainerColor = Color.Gray,
        disabledContentColor = Color.DarkGray
    ) ){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(text="Reset", style  = MaterialTheme.typography.titleLarge)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ShowContnet(){
    Dollar()
}