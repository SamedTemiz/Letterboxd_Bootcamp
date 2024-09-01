package com.timrashard.letterboxd_bootcamp.presentation.screens.popular

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timrashard.letterboxd_bootcamp.R
import com.timrashard.letterboxd_bootcamp.data.AppData
import com.timrashard.letterboxd_bootcamp.data.entity.Review
import com.timrashard.letterboxd_bootcamp.ui.theme.DisplayPro
import com.timrashard.letterboxd_bootcamp.ui.theme.L_BlueGray
import com.timrashard.letterboxd_bootcamp.ui.theme.L_Gray
import com.timrashard.letterboxd_bootcamp.ui.theme.L_Green
import com.timrashard.letterboxd_bootcamp.ui.theme.L_LightBlueGray
import com.timrashard.letterboxd_bootcamp.ui.theme.L_LightGray
import com.timrashard.letterboxd_bootcamp.ui.theme.L_Orange
import com.timrashard.letterboxd_bootcamp.ui.theme.L_White
import com.timrashard.letterboxd_bootcamp.ui.theme.Satoshi

@Composable
fun ReviewsPage() {
    val newFromFriendsReviews = remember { mutableStateListOf<Review>() }
    val popularWithFriendsReviews = remember { mutableStateListOf<Review>() }

    LaunchedEffect(Unit) {
        if(newFromFriendsReviews.size < 1 && popularWithFriendsReviews.size < 1){
            newFromFriendsReviews.addAll(AppData.newFromFriendsReviews)
            popularWithFriendsReviews.addAll(AppData.popularWithFriendsReviews)
        }
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(36.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(top = 36.dp, bottom = 36.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            ReviewCardList(listTitle = "New from friends", list = newFromFriendsReviews)
        }

        item {
            ReviewCardList(listTitle = "Popular with friends", list = popularWithFriendsReviews)
        }
    }
}

@Composable
fun ReviewCardList(
    listTitle: String,
    list: List<Review>
) {
    Column(
        Modifier.fillMaxWidth()
    ) {
        Text(
            text = listTitle,
            fontFamily = DisplayPro,
            color = L_White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 16.dp)
        )

        Spacer(Modifier.height(16.dp))

        list.forEachIndexed() { index, review ->
            ReviewCardComponent(review = review)

            HorizontalDivider(
                thickness = 1.dp,
                color = L_LightGray,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = if (index < list.size - 1) 16.dp else 0.dp
                )
            )
        }
    }
}


@Composable
fun ReviewCardComponent(review: Review) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = review.movie.name,
                        fontFamily = DisplayPro,
                        fontSize = 16.sp,
                        color = L_LightBlueGray,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.alignByBaseline()
                    )

                    Spacer(Modifier.width(4.dp))

                    Text(
                        text = review.movie.year ?: "-",
                        fontFamily = Satoshi,
                        fontSize = 12.sp,
                        color = L_BlueGray,
                        modifier = Modifier.alignByBaseline()
                    )
                }

                Spacer(Modifier.size(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if(review.rate > 0){
                        repeat(review.rate) { index ->
                            Icon(
                                painter = painterResource(id = R.drawable.ic_star),
                                contentDescription = "Rate",
                                tint = L_Green,
                                modifier = Modifier.size(14.dp)
                            )

                            if (index < review.rate - 1) {
                                Spacer(Modifier.width(4.dp))
                            }
                        }

                        Spacer(Modifier.width(8.dp))
                    }

                    if(review.isLiked){
                        Icon(
                            painter = painterResource(id = R.drawable.ic_heart),
                            contentDescription = "Like",
                            tint = L_Orange,
                            modifier = Modifier.size(14.dp)
                        )

                        Spacer(Modifier.width(8.dp))
                    }

                    if(review.isRewatch){
                        Icon(
                            painter = painterResource(id = R.drawable.ic_repeat),
                            contentDescription = "Repeat",
                            tint = L_LightBlueGray,
                            modifier = Modifier.size(14.dp)
                        )

                        Spacer(Modifier.width(8.dp))
                    }
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = review.profile.name,
                    fontFamily = DisplayPro,
                    fontSize = 12.sp,
                    color = L_BlueGray,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.size(8.dp))

                Image(
                    painter = painterResource(id = review.profile.image),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .border(1.dp, L_Gray, CircleShape)
                )
            }
        }

        Spacer(modifier = Modifier.size(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = review.movie.image),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 100.dp, height = 150.dp)
                    .background(Color.Red)
                    .border(1.dp, L_LightGray)
            )

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = review.reviewText,
                fontFamily = DisplayPro,
                fontSize = 14.sp,
                color = L_LightBlueGray,
            )
        }
    }
}