package com.example.gusports.repository

import com.example.gusports.constants.Contants
import com.example.gusports.models.Team
import com.example.gusports.utils.Resource
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class TeamRepository @Inject constructor(private val db:FirebaseFirestore) {

    suspend fun getTeams(result:(Resource<ArrayList<Team>>)->Unit){

        val teams = arrayListOf<Team>()

        db.collection(Contants.TEAMS).get().addOnSuccessListener {
            for(document in it.documents){
                document.toObject(Team::class.java)?.let { it1 -> teams.add(it1) }
            }

            result.invoke(
                Resource.Success(teams)
            )


        }.addOnFailureListener {
            result.invoke(
                Resource.Failure(it.localizedMessage)
            )
        }
    }
}