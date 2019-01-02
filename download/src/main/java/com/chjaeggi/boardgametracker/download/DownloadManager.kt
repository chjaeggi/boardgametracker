package com.chjaeggi.boardgametracker.download

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class DownloadManager {

    private var doc: Document = Jsoup.connect("https://boardgamegeek.com/browse/boardgame").get()

    fun getDoc(): String {
        return doc.html()
    }

}