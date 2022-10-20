package com.example.marvelheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddListItem(item: ListModel) {
    Card(
        Modifier
            .fillMaxHeight()
            .width(LocalConfiguration.current.screenWidthDp.dp)
            .padding(20.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = 5.dp
    ) {
        Image(
            painter = painterResource(id = item.imageId),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Box(
            Modifier
                .fillMaxSize()
                .padding(start = 25.dp, bottom = 35.dp),
            contentAlignment = Alignment.BottomStart,
        ) {
            Text(
                text = item.Name,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        }
    }
}