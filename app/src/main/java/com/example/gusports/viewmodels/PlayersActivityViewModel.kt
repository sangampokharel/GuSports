package com.example.gusports.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gusports.models.Players
import com.example.gusports.repository.PlayersRepository
import com.example.gusports.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayersActivityViewModel @Inject constructor(private val playersRepository: PlayersRepository):ViewModel() {

    val players = MutableLiveData<Resource<ArrayList<Players>>>()


    fun getPlayers(category:String,teamId:String){

        viewModelScope.launch {
            players.postValue(Resource.Loading)
            playersRepository.getPlayers(category,teamId) {
                players.postValue(it)
            }
        }
    }




}