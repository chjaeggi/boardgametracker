package com.chjaeggi.boardgametracker.download

import com.chjaeggi.boardgametracker.data.BoardGameWebApi
import com.chjaeggi.boardgametracker.data.BoardGameWebApiInfo
import org.jsoup.Jsoup
import org.jsoup.parser.Parser
import timber.log.Timber

class BoardGameGeek : BoardGameWebApi {

    private var details: HashMap<Int, BoardGameGeekDetails> = hashMapOf()

    /**
     * returns a List in form as defined in [BoardGameWebApiInfo]
     */
    override fun getBoardGames(): List<BoardGameWebApiInfo> {
        return getRankedBoardGames()
            .map {
                BoardGameWebApiInfo(
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

    private fun getRankedBoardGames(): HashMap<Int, Int> {
        var rankedList: HashMap<Int, Int> = hashMapOf()
        try {
            for (pageNumber in 1..1) { // Top 100
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