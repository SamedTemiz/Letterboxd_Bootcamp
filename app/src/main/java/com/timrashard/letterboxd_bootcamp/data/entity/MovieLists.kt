package com.timrashard.letterboxd_bootcamp.data.entity

import com.timrashard.letterboxd_bootcamp.R

object MovieLists {

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
        Movie(id = 8, name = "The Lord of The Rings - The Return of The King", image = R.drawable.the_lord_of_the_rings_the_return_of_the_king),
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
}