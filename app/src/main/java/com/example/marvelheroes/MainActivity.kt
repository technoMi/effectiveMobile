@file:OptIn(ExperimentalComposeUiApi::class, ExperimentalSnapperApi::class)

package com.example.marvelheroes

//import android.graphics.Color
import android.graphics.drawable.shapes.Shape
import android.icu.number.Scale
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.marvelheroes.ui.theme.MarvelHeroesTheme
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.LazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberLazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //androidx.compose.ui.graphics.Color.Red
        setContent {

            val bgColor: Color = Color(red = 0x26, green = 0x23, blue = 0x26)
            Column(
                Modifier
                    .fillMaxSize()
                    .background(bgColor)
            ) {
                Column(
                    Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .height(30.dp),
                        painter = painterResource(id = R.drawable.marvel_logo),
                        contentDescription = "", contentScale = ContentScale.FillHeight
                    )
                    Text(
                        modifier = Modifier.padding(top = 15.dp),
                        text = "Choose your hero",
                        color = Color.White,
                        fontWeight = Bold,
                        fontSize = 30.sp
                    )
                }

                val lazyListState: LazyListState = rememberLazyListState()
                LazyRow(
                    Modifier.fillMaxSize(),
                    state = lazyListState,
                    flingBehavior = rememberSnapperFlingBehavior(lazyListState),
                ) {
                    itemsIndexed(
                        listOf(
                            ListModel(R.drawable.spider_man, "Spider man"),
                            ListModel(R.drawable.doctor_strange, "Doctor Strange"),
                            ListModel(R.drawable.deadpool, "Deadpool"),
                            ListModel(R.drawable.iron_man, "Iron man")
                        )
                    ) { _, item ->
                        AddListItem(item = item)
                    }
                }
            }
        }
    }
}