package com.chjaeggi.boardgametracker.download

import com.chjaeggi.boardgametracker.data.BoardGameApi
import com.chjaeggi.boardgametracker.data.BoardGameApiInfo
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import timber.log.Timber

class DownloadManager : BoardGameApi {

    private var doc: Document? = null

    /**
     * returns a HashMap of the game rank and its unique ID
     */
    override fun getBoardGames(): List<BoardGameApiInfo> {
        Timber.d("XXX: ${getDoc()}()")
        return listOf(
            BoardGameApiInfo(apiId = 3, name = "a"),
            BoardGameApiInfo(apiId = 4, name = "b"),
            BoardGameApiInfo(apiId = 5, name = "c")
        )
    }

    fun getDoc(): String? {
        doc = Jsoup.connect("https://boardgamegeek.com/browse/boardgame").get()
        return doc?.html()
    }

}