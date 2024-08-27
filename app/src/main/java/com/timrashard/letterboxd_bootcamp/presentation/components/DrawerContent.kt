package com.timrashard.letterboxd_bootcamp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timrashard.letterboxd_bootcamp.R
import com.timrashard.letterboxd_bootcamp.ui.theme.L_Black
import com.timrashard.letterboxd_bootcamp.ui.theme.L_LightGray
import com.timrashard.letterboxd_bootcamp.ui.theme.DisplayPro
import com.timrashard.letterboxd_bootcamp.ui.theme.L_Gray
import com.timrashard.letterboxd_bootcamp.ui.theme.Satoshi

@Composable
fun DrawerContent() {
    val menuList = listOf(
        DrawerMenu(icon = R.drawable.ic_popular, "Popular"),
        DrawerMenu(icon = R.drawable.ic_search, "Search"),
        DrawerMenu(icon = R.drawable.ic_profile, "Profile"),
        DrawerMenu(icon = R.drawable.ic_watchlist, "Watchlist"),
        DrawerMenu(icon = R.drawable.ic_lists, "Lists"),
        DrawerMenu(icon = R.drawable.ic_diary, "Diary"),
        DrawerMenu(icon = R.drawable.ic_review, "Reviews"),
        DrawerMenu(icon = R.drawable.ic_activity, "Activity"),
        DrawerMenu(icon = R.drawable.ic_settings, "Settings"),
        DrawerMenu(icon = R.drawable.ic_signout, "Sign out")
    )

    val selectedItem = remember { mutableStateOf(0) }

    ModalDrawerSheet(
        modifier = Modifier.fillMaxWidth(0.70f),
        drawerShape = RectangleShape,
        drawerContainerColor = L_Black,
        drawerContentColor = Color.White
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.neo),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(85.dp)
                        .clip(CircleShape)
                        .border(1.dp, L_Gray, CircleShape)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "Samed Temiz",
                        fontFamily = Satoshi,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "TimRashard",
                        fontSize = 16.sp,
                        fontFamily = DisplayPro,
                    )
                }
            }

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                itemsIndexed(menuList) { index, item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                selectedItem.value = index
                            }
                            .background(
                                color = if(index == selectedItem.value) L_LightGray else Color.Transparent
                            )
                            .padding(horizontal = 16.dp, vertical = 14.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = "Icon",
                            tint = if(index == selectedItem.value) Color.White else L_LightGray,
                            modifier = Modifier.size(24.dp)
                        )

                        Text(
                            text = item.title,
                            fontFamily = Satoshi,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(start = 32.dp)
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                Spacer(Modifier.size(24.dp))

                Text(
                    text = "2.18.6 (352)",
                    fontFamily = Satoshi,
                    fontSize = 12.sp,
                    color = L_LightGray,
                    modifier = Modifier.padding(start = 32.dp)
                )
            }
        }
    }
}

data class DrawerMenu(var icon: Int, var title: String)