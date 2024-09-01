package com.timrashard.letterboxd_bootcamp.data.entity

data class Review(
    val id: Int,
    val profile: Profile,
    val movie: Movie,
    val rate: Int,
    val reviewText: String,
    val isLiked: Boolean,
    val isRewatch: Boolean,
)
