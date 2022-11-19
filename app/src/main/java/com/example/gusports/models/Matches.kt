package com.example.gusports.models

import java.io.Serializable

data class Matches(
    val homeTeamLogo:String?=null,
    val awayTeamLogo:String?=null,
    val homeTeamName:String?=null,
    val awayTeamName:String?=null,
     val time:String?=null,
    val gameStatus:String?=null,
    val awayWinner:String?=null,
    val homeWinner:String?=null,
    val venue:String?=null,
    val mentor:String?=null,
    val contact:String?=null,
    val category:String?=null

) {

}