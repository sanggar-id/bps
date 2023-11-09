package com.isfa.home.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderView(time: String, name: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Selamat $time di,",
            fontSize = 12.sp
        )

        Text(
            text = name,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 4.dp)
        )
    }
}

@Composable
@Preview
fun HeaderViewPreview() {
    HeaderView(
        time = "Malam",
        name = "BPS Catatan Berita!"
    )
}