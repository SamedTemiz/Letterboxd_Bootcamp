package com.timrashard.letterboxd_bootcamp.presentation.screens.popular

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.timrashard.letterboxd_bootcamp.data.entity.Movie
import com.timrashard.letterboxd_bootcamp.data.entity.MovieLists
import com.timrashard.letterboxd_bootcamp.ui.theme.DisplayPro
import com.timrashard.letterboxd_bootcamp.ui.theme.L_LightGray
import com.timrashard.letterboxd_bootcamp.ui.theme.L_White
import com.timrashard.letterboxd_bootcamp.ui.theme.Satoshi

@Composable
fun FilmsPage() {
    val popularMovieList = remember { mutableStateListOf<Movie>() }
    val newFromFriendsList = remember { mutableStateListOf<Movie>() }
    val popularWithFriends = remember { mutableStateListOf<Movie>() }

    LaunchedEffect(true) {
        popularMovieList.clear()
        newFromFriendsList.clear()
        popularWithFriends.clear()

        popularMovieList.addAll(MovieLists.popularMovieList)
        newFromFriendsList.addAll(MovieLists.newFromFriendsList)
        popularWithFriends.addAll(MovieLists.popularWithFriends)
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(36.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(top = 36.dp, bottom = 36.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            MovieListRow(title = "Popular this week", movies = popularMovieList)
        }

        item {
            MovieListRow(title = "New from friends", movies = newFromFriendsList)
        }

        item {
            MovieListRow(title = "Popular with friends", movies = popularWithFriends)
        }
    }
}

@Composable
fun MovieListRow(
    title: String,
    movies: List<Movie>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontFamily = DisplayPro,
            color = L_White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 16.dp)
        )

        Spacer(Modifier.height(16.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(movies) { movie ->
                var image by remember { mutableStateOf(movie.image) }

                Box(
                    modifier = Modifier
                        .size(width = 100.dp, height = 150.dp)
                        .background(Color.Red)
                        .border(1.dp, L_LightGray)
                ) {
                    SubcomposeAsyncImage(
                        model = image,
                        contentDescription = null,
                        loading = {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = L_LightGray),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = movie.name,
                                    fontFamily = Satoshi,
                                    color = L_White
                                )
                            }
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

        }
    }
}