package com.example.gusports.repository

import com.example.gusports.models.Rules
import com.example.gusports.utils.Resource
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class RulesRepository @Inject constructor (private val db:FirebaseFirestore) {

    suspend fun getRules(category:String,result:(Resource<Rules>)->Unit){
        var rules=Rules()
        db.collection("rules")
            .whereEqualTo("category",category)
            .get()
            .addOnSuccessListener {
                for(item in it.documents){
                    rules = item.toObject(Rules::class.java)!!
                }
            result.invoke(
                Resource.Success(rules)
            )


        }.addOnFailureListener {

            result.invoke(
                Resource.Failure(it.localizedMessage)
            )
        }
    }
}