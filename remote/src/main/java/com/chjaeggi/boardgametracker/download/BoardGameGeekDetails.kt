package com.chjaeggi.boardgametracker.download

data class BoardGameGeekDetails(
    var name: String = "",
    var description: String = "",
    var thumbnail: String = "",
    var image: String = "",
    var minPlayers: Int = -1,
    var maxPlayers: Int = -1,
    var playingTime: Int = -1
)
