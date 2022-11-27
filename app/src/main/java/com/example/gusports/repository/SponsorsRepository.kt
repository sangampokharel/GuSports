package com.example.gusports.repository

import com.example.gusports.constants.Contants
import com.example.gusports.models.Sponsor
import com.example.gusports.utils.Resource
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class SponsorsRepository @Inject constructor(private val db:FirebaseFirestore) {

    var sponsors = mutableListOf<Sponsor>()
    suspend fun getSponsors(result:(Resource<List<Sponsor>>)->Unit){

        db.collection(Contants.SPONSORS)
            .orderBy("name")
            .get().addOnSuccessListener {

            for(item in it.documents){
                sponsors.add(item.toObject(Sponsor::class.java)!!)
            }


            result.invoke(
                Resource.Success(sponsors)
            )

        }.addOnFailureListener {
                result.invoke(
                    Resource.Failure(it.localizedMessage)
                )
        }

    }
}