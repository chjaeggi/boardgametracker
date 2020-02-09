package com.chjaeggi.boardgametracker.download

import com.chjaeggi.boardgametracker.domain.WebBoardGame
import com.chjaeggi.boardgametracker.data.WebSource
import com.chjaeggi.boardgametracker.domain.BoardGame
import org.jsoup.Jsoup
import org.jsoup.parser.Parser
import timber.log.Timber
import java.lang.NumberFormatException
import kotlin.math.ceil

class BoardGameGeek : WebSource {

    private var details: HashMap<Int, BoardGameGeekDetails> = hashMapOf()

    /**
     * returns a List in form as defined in [WebBoardGame]
     */
    override fun fetchTop(amount: Int): List<WebBoardGame> {
        return getRankedBoardGames(amount)
            .map {
                WebBoardGame(
                    apiRank = it.value,
                    apiId = it.key,
                    description = details[it.key]?.description ?: "",
                    name = details[it.key]?.name ?: "",
                    thumbnailUrl = details[it.key]?.thumbnail ?: "",
                    imageUrl = details[it.key]?.image ?: "",
                    minPlayers = details[it.key]?.minPlayers ?: -1,
                    maxPlayers = details[it.key]?.maxPlayers ?: -1,
                    playTime = details[it.key]?.playingTime ?: -1
                )
            }
    }

    override fun fetchGameById(queryId: Int): BoardGame {
        val detail = BoardGameGeekDetails()
        try {
            val document = Jsoup.parse(
                Jsoup
                    .connect("https://www.boardgamegeek.com/xmlapi2/thing?id=$queryId")
                    .maxBodySize(0)
                    .get()
                    .html(),
                "",
                Parser.xmlParser()
            )

            val name = document.getElementsByTag("name")
            if (name.attr("type") == "primary") {
                detail.name = name.`val`()
            }
            detail.description = document.getElementsByTag("description").text()
            detail.thumbnail = document.getElementsByTag("thumbnail").text()
            detail.image = document.getElementsByTag("image").text()
            detail.minPlayers = document.getElementsByTag("minplayers").`val`().toInt()
            detail.maxPlayers = document.getElementsByTag("maxplayers").`val`().toInt()
            detail.playingTime = document.getElementsByTag("playingtime").`val`().toInt()

        } catch (e: Exception) {
            throw Exception(e)
        }
        return BoardGame(
            id = queryId,
            description = detail.description,
            name = detail.name,
            thumbnailUrl = detail.thumbnail,
            imageUrl = detail.image,
            minPlayers = detail.minPlayers,
            maxPlayers = detail.maxPlayers,
            playTime = detail.playingTime,
            isUserFavorite = false
        )
    }

    override fun fetchGameByName(name: String) : BoardGame? {
        try {
            val document = Jsoup.parse(
                Jsoup
                    .connect("https://www.boardgamegeek.com/xmlapi/search?search=$name&exact=1")
                    .maxBodySize(0)
                    .get()
                    .html(),
                "",
                Parser.xmlParser()
            )
            val boardgame = document.getElementsByTag("boardgame")

            return try {
                fetchGameById(boardgame.attr("objectid").toInt())
            } catch (e: NumberFormatException) {
                null
            }
        } catch (e: Exception) {
            throw Exception(e)
        }
    }

    private fun getRankedBoardGames(amount: Int): HashMap<Int, Int> {
        var rankedList: HashMap<Int, Int> = hashMapOf()
        try {
            for (pageNumber in 1..(ceil(amount / 100.0)).toInt()) {
                val document = Jsoup
                    .connect("https://boardgamegeek.com/browse/boardgame/page/$pageNumber")
                    .get()
                val tdElement = document.select("td.collection_rank")
                tdElement.forEach {
                    val rank = it
                        .select("a[name]")
                        .attr("name")
                        .toInt()
                    val id = it
                        .nextElementSibling()
                        .select("a[href]")
                        .attr("href")
                        .split("/")
                        .elementAt(2)
                        .toInt()
                    rankedList[id] = rank
                }
                getBoardGameDetails(rankedList.keys.toList())
            }
        } catch (e: Exception) {
            Timber.e("Error while downloading data: $e")
        }
        return rankedList
    }

    private fun getBoardGameDetails(rankedList: List<Int>) {

        val ids = rankedList.joinToString(separator = ",")

        try {
            val document = Jsoup.parse(
                Jsoup
                    .connect("https://www.boardgamegeek.com/xmlapi2/thing?id=$ids")
                    .maxBodySize(0)
                    .get()
                    .html(),
                "",
                Parser.xmlParser()
            )

            for (element in document.getElementsByTag("item")) {
                val id = element.attributes().get("id").toInt()
                details[id] = BoardGameGeekDetails()

                val name = element.getElementsByTag("name")
                if (name.attr("type") == "primary") {
                    details[id]?.name = name.`val`()
                }
                details[id]?.description = element.getElementsByTag("description").text()
                details[id]?.thumbnail = element.getElementsByTag("thumbnail").text()
                details[id]?.image = element.getElementsByTag("image").text()
                details[id]?.minPlayers = element.getElementsByTag("minplayers").`val`().toInt()
                details[id]?.maxPlayers = element.getElementsByTag("maxplayers").`val`().toInt()
                details[id]?.playingTime = element.getElementsByTag("playingtime").`val`().toInt()
            }
        } catch (e: Exception) {
            throw Exception(e)
        }
    }
}