package com.example.qcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Calci()
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun Calci() {

    val fontFamily = FontFamily(
        Font(R.font.bebasneue_regular, FontWeight.Bold)
    )
    val scaffoldState = rememberScaffoldState()
    var textFieldState by remember { mutableStateOf("") }
    var textFieldState1 by remember { mutableStateOf("") }
    var textFieldState2 by remember { mutableStateOf("New Gamble as usual") }
    val scope = rememberCoroutineScope()
    var result = 0.0

    //TextBar and the Toast
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp)
        ) {
            TextField(
                value = textFieldState,
                onValueChange = { textFieldState = it },
                label = { Text(text = "Enter the no first") },
                singleLine = true
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = textFieldState1,
                onValueChange = { textFieldState1 = it },
                label = { Text(text = "Enter the no second") },
                singleLine = true
            )
            Spacer(Modifier.height(20.dp))
            OutlinedTextField(
                value = textFieldState2,
                onValueChange = { textFieldState2 = result.toString() })
        }
    }
    val num1 = textFieldState.toDoubleOrNull()
    val num2 = textFieldState1.toDoubleOrNull()

//Buttons
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(150.dp)
        ) {

            //Add
            Button(
                onClick = {
                    result = if (num1 == null || num2 == null) {
                        0.0
                    } else {
                        num1 + num2
                    }
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("The result is $result")
                    }
                }, modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = "Add",
                    fontSize = 20.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.35f)

                )
            }

            //Substract
            Button(
                onClick = {
                    result = if (num1 == null || num2 == null) {
                        0.0
                    } else {
                        num1 - num2
                    }
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("The result is $result")
                    }
                }, modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = "Substract",
                    fontSize = 20.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }


        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .height(150.dp)
        ) {
            //Multiply
            Button(
                onClick = {
                    result = if (num1 == null || num2 == null) {
                        0.0
                    } else {
                        num1 * num2
                    }
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("The result is $result")
                    }
                }, modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = "Multiply",
                    fontSize = 20.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.35f)
                )
            }

            //Division
            Button(
                onClick = {
                    result = if (num1 == null || num2 == null) {
                        0.0
                    } else {
                        num1 / num2
                    }
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("The result is $result")
                    }
                }, modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = "Division",
                    fontSize = 20.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}