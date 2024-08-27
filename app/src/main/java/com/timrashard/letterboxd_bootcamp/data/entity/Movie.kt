package com.timrashard.letterboxd_bootcamp.data.entity

data class Movie(
    var id: Int,
    var name: String,
    var image: Int,
    var directedBy: String? = null,
    var year: String? = null,
    var length: String? = null,
    var plot: String? = null
)