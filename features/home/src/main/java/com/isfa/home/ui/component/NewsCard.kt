package com.isfa.home.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.isfa.home.R

@Composable
fun NewsCard(title: String, category: String, action: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .background(Color.LightGray)
            .clickable {
                action()
            }
    ) {
        Column(
            modifier = Modifier
                .weight(2f)
                .padding(6.dp)
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = category.uppercase(),
                color = Color.Red,
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(top = 4.dp)
            )
        }

        Image(
            painter = painterResource(R.drawable.img_nasi_jaha),
            contentDescription = "thumbnail berita",
            modifier = Modifier
                .padding(start = 4.dp)
                .weight(1.5f)
        )
    }
}

@Composable
@Preview
fun NewsCardPreview() {
    NewsCard(
        title = "Nasi Jaha, Nasi ciri khas Minahasa",
        category = "Budaya"
    )
}