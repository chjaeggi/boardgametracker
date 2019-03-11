package com.chjaeggi.boardgametracker.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boardgames")
data class BoardGameEntity(
    @PrimaryKey
    val id: Int,
    val name: String
)