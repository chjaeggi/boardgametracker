package com.chjaeggi.boardgametracker.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface BoardGameDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveGames(games: List<BoardGameEntity>)

    @Query("SELECT * FROM boardgames WHERE id = :id")
    fun findGameById(id: String): Single<BoardGameEntity>

    @Query("SELECT * FROM boardgames")
    fun loadAllGames(): Flowable<List<BoardGameEntity>>
}