package com.example.gusports.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gusports.models.Team
import com.example.gusports.repository.TeamRepository
import com.example.gusports.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamsFragmentViewModel @Inject constructor(private val teamRepository: TeamRepository):ViewModel() {

    val teams = MutableLiveData<Resource<ArrayList<Team>>>()

    init {
        getTeams()
    }

    private fun getTeams(){
        teams.postValue(Resource.Loading)
        viewModelScope.launch {
            teamRepository.getTeams {
                teams.postValue(it)
            }
        }
    }







}