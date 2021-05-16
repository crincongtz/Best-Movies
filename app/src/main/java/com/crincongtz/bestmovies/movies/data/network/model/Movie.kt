package com.crincongtz.bestmovies.movies.data.network.model

import com.squareup.moshi.Json

data class Movie (
    @JvmField @Json(name = "title")
    var title: String = "",

    @JvmField @Json(name = "id")
    var id: Long = 0,

    @JvmField @Json(name = "release_date")
    var releaseDate: String = "",

    @JvmField @Json(name = "popularity")
    var popularity: Double = 0.0,

    @JvmField @Json(name = "vote_average")
    var rating: Double = 0.0,

    @JvmField @Json(name = "vote_count")
    var ratingCount: Int = 0,

    @JvmField @Json(name = "poster_path")
    var posterImagePath: String = ""
)
