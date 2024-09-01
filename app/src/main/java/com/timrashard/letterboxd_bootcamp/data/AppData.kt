package com.timrashard.letterboxd_bootcamp.data

import com.timrashard.letterboxd_bootcamp.R
import com.timrashard.letterboxd_bootcamp.data.entity.Movie
import com.timrashard.letterboxd_bootcamp.data.entity.Profile
import com.timrashard.letterboxd_bootcamp.data.entity.Review

object AppData {

    // Profiles
    val profiles = listOf(
        Profile(id = 1, name = "Hasan", image = R.drawable.hasan),
        Profile(id = 2, name = "MoviRunner", image = R.drawable.movirunner),
        Profile(id = 3, name = "BobinKafa", image = R.drawable.bobinkafa),
        Profile(id = 4, name = "James Hally", image = R.drawable.james_hally),
        Profile(id = 5, name = "Dhanush", image = R.drawable.dhanush),
        Profile(id = 6, name = "Joseph", image = R.drawable.joseph),
    )

    // Films
    val popularMovieList = listOf(
        Movie(id = 1, name = "Arrival", image = R.drawable.arrival),
        Movie(id = 2, name = "Matrix", image = R.drawable.matrix),
        Movie(id = 3, name = "Interstellar", image = R.drawable.interstellar),
        Movie(id = 4, name = "Contact", image = R.drawable.contact),
        Movie(id = 5, name = "Sicario", image = R.drawable.sicario),
    )

    val newFromFriendsList = listOf(
        Movie(id = 6, name = "Dune Part Two", image = R.drawable.dune_part_two),
        Movie(id = 7, name = "The Dark Knight", image = R.drawable.the_dark_knight),
        Movie(
            id = 8,
            name = "The Lord of The Rings - The Return of The King",
            image = R.drawable.the_lord_of_the_rings_the_return_of_the_king
        ),
        Movie(id = 9, name = "Man From Earth", image = R.drawable.man_from_earth),
        Movie(id = 10, name = "Drive", image = R.drawable.drive),
    )

    val popularWithFriends = listOf(
        Movie(id = 11, name = "Kung Fu Hustle", image = R.drawable.kung_fu_hustle),
        Movie(id = 12, name = "The Wailing", image = R.drawable.the_wailing),
        Movie(id = 13, name = "Enemy", image = R.drawable.enemy),
        Movie(id = 14, name = "Deep Impact", image = R.drawable.deep_impact),
        Movie(id = 15, name = "La La Land", image = R.drawable.la_la_land),
    )

    // Reviews

    val newFromFriendsReviews = listOf(
        Review(
            id = 1,
            profile = profiles[0],
            movie = Movie(id = 21, name = "The Promised Land", image = R.drawable.the_promised_land, year = "2023"),
            rate = 4,
            reviewText = "If we pursue goals without knowing the value of what we have, when we lose what we have, the goal becomes irrelevant.",
            isLiked = true,
            isRewatch = false
        ),
        Review(
            id = 2,
            profile = profiles[1],
            movie = Movie(id = 18, name = "Longlegs", image = R.drawable.longlegs, year = "2024"),
            rate = 3,
            reviewText = "filmi izlemeden önce bir sahnede kahkaha atacağımı tahmin etmezdim",
            isLiked = false,
            isRewatch = false
        ),
        Review(
            id = 3,
            profile = profiles[2],
            movie = Movie(id = 16, name = "The Perks of Being a Wallflower", image = R.drawable.the_perks_of_being_a_wallflower, year = "2012"),
            rate = 4,
            reviewText = "For the first time, I saw a stepsister movie where she wasn't in any embarrassing situation.",
            isLiked = false,
            isRewatch = true
        ),
    )

    val popularWithFriendsReviews = listOf(
        Review(
            id = 4,
            profile = profiles[3],
            movie = Movie(id = 17, name = "To Leslie", image = R.drawable.to_leslie, year = "2022"),
            rate = 3,
            reviewText = "Desperately wanted Maron to ask Leslie \'so, who are your guys?\'\nHe didn't, but really good movie nonetheless.",
            isLiked = false,
            isRewatch = false
        ),
        Review(
            id = 5,
            profile = profiles[4],
            movie = Movie(id = 19, name = "Borderlands", image = R.drawable.borderlands, year = "2024"),
            rate = 1,
            reviewText = "i'm pretty sure this is a hate crime",
            isLiked = false,
            isRewatch = false
        ),
        Review(
            id = 6,
            profile = profiles[5],
            movie = Movie(id = 20, name = "The Wailing", image = R.drawable.the_wailing, year = "2016"),
            rate = 0,
            reviewText = "The Wailing started off as a typical murder mystery. A story with quirky characters oblivious to the sickness spreading in the village. It's a bold story that refuses to give in to timed scares to reenergise poor attention spans.",
            isLiked = true,
            isRewatch = false
        ),
    )
}