package com.example.gusports.repository

import com.example.gusports.constants.Contants
import com.example.gusports.models.Players
import com.example.gusports.models.PlayersResult
import com.example.gusports.utils.Resource
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class PlayersRepository @Inject constructor(private val db:FirebaseFirestore) {


    suspend fun getPlayers(category:String,teamId:String,result:(Resource<ArrayList<Players>>)->Unit){

        val players = ArrayList<Players>()
        db.collection(Contants.PLAYERS)
            .whereEqualTo("teamId",teamId)
            .whereEqualTo("category",category)
            .get()
            .addOnSuccessListener {

                    for(item in it.documents){
                        val playersResult = item.toObject(PlayersResult::class.java)

                        for( player in playersResult?.players!!){
                            players.add(player)
                        }

                    }

                result.invoke(
                    Resource.Success(players)
                )

            }
            .addOnFailureListener {

                result.invoke(
                    Resource.Failure(it.localizedMessage)
                )
            }

    }


}