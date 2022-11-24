package com.example.gusports.repository

import android.util.Log
import com.example.gusports.models.DateMatches
import com.example.gusports.models.Matches
import com.example.gusports.utils.Resource
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class MatchesRepository @Inject constructor(private val db: FirebaseFirestore) {
     suspend fun getMatches(collection:String,category:String,result:(Resource<ArrayList<DateMatches>>)->Unit){
         val dateMatches = arrayListOf<DateMatches>()
        db.collection(collection)
            .whereEqualTo("category",category)

            .get()
            .addOnSuccessListener {
                   for(document in it.documents){

                        document.toObject(DateMatches::class.java).let {
                            dm ->   dateMatches.add(DateMatches(
                               dm!!.date,
                                dm.category,
                                dm.matches
                            ))
                        }



                    }
                result.invoke(
                    Resource.Success(dateMatches)
                )


            }
            .addOnFailureListener{
                Log.d("MAIN ERROR",it.message.toString())
                result.invoke(
                    Resource.Failure(it.localizedMessage)
                )
            }


    }

}