package com.example.taskmanagement.ui.screen

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


@Composable
fun MyAlertDailog(){

    val shouldShowDailog= remember {
        mutableStateOf(true)
    }


    if (shouldShowDailog.value){

        AlertDialog(
            title = {Text(text = "tittle ")},
            text = { Text(text = "test Dailog ")},
            onDismissRequest = {
                shouldShowDailog.value=false
            },
            confirmButton = {
             Button(onClick = {    shouldShowDailog.value=false }) {

                 Text(text = "Confirm")
             }
            },
            dismissButton = {
                Button(onClick = {  shouldShowDailog.value=false }) {
                    Text(text = "Cancel")
                }
            }

            )


    }
}