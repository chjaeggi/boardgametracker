package com.chjaeggi.boardgametracker.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BoardGameEntity::class], version = 1)
abstract class BoardGameDatabase : RoomDatabase() {

    abstract fun boardgameDAO(): BoardGameDAO
}