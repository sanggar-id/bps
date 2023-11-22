package com.isfa.home.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsBottomSheet(
    onAddNewsClick: (String, String) -> Unit,
    onSheetDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()
    var title by remember { mutableStateOf("") }

    ModalBottomSheet(
        onDismissRequest = { onSheetDismiss() },
        sheetState = sheetState
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                TextField(
                    value = title,
                    label = {
                        Text(text = "Title")
                    },
                    onValueChange = {
                        title = it
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            item {
                Button(
                    onClick = {
                        onAddNewsClick(title, "ini category nya")
                        onSheetDismiss()

                        coroutineScope.launch {
                            sheetState.hide()
                        }
                    }
                ) {
                    Text(text = "Add News")
                }
            }

            item {
                Text(text = "Hii, this is a bottom sheet!")
            }

            item {
                Spacer(modifier = Modifier.padding(bottom = 32.dp))
            }
        }
    }
}