package com.timrashard.letterboxd_bootcamp.presentation.screens.popular

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timrashard.letterboxd_bootcamp.presentation.components.DrawerContent
import com.timrashard.letterboxd_bootcamp.ui.theme.L_Black
import com.timrashard.letterboxd_bootcamp.ui.theme.L_LightGray
import com.timrashard.letterboxd_bootcamp.ui.theme.L_Green
import com.timrashard.letterboxd_bootcamp.ui.theme.L_Orange
import com.timrashard.letterboxd_bootcamp.ui.theme.Satoshi
import com.timrashard.letterboxd_bootcamp.ui.theme.L_White
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun PopularScreen() {
    val tabs = listOf("FILMS", "REVIEWS", "LISTS", "JOURNAL")
    val selectedTab = remember { mutableStateOf(0) }
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collectLatest { page ->
            selectedTab.value = page
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent()
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "Popular",
                            fontFamily = Satoshi,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(horizontal = 12.dp)
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch { drawerState.open() }
                            },
                        ) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = { /* Handle search icon click */ }
                        ) {
                            Icon(Icons.Default.Search, contentDescription = "Search")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = L_LightGray,
                        titleContentColor = L_White,
                        navigationIconContentColor = L_White,
                        actionIconContentColor = L_White
                    )
                )
            }
        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                Tabs(tabs = tabs, pagerState = pagerState, coroutineScope = scope)

                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(L_Black)
                ) { page ->
                    when (page) {
                        0 -> FilmsPage()
                        1 -> ReviewsPage()
                        2 -> Text("Lists Content")
                        3 -> Text("Journal Content")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tabs(
    tabs: List<String>,
    pagerState: PagerState,
    coroutineScope: CoroutineScope
) {
    var selectedTab by remember { mutableIntStateOf(0) }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collectLatest { page ->
            selectedTab = page
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = L_LightGray)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            tabs.forEachIndexed { index, tab ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clickable {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                                selectedTab = index
                            }
                        }
                        .drawBehind {
                            if (pagerState.currentPage == index) {
                                val strokeWidth = 2.dp.toPx()
                                val y = size.height - strokeWidth / 2
                                drawLine(
                                    color = L_Green,
                                    start = Offset(0f, y),
                                    end = Offset(size.width, y),
                                    strokeWidth = strokeWidth
                                )
                            }
                        }
                ) {
                    if(index == 1){
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .background(color = L_Orange, shape = CircleShape)
                                .align(Alignment.TopEnd)
                                .offset(x = (-16).dp, y = 16.dp)
                        )
                    }

                    Text(
                        text = tab,
                        fontFamily = Satoshi,
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 18.dp, vertical = 10.dp)
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PopularPreview() {
    PopularScreen()
}