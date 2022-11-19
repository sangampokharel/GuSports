package com.example.gusports.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gusports.constants.Contants
import com.example.gusports.models.DateMatches
import com.example.gusports.repository.MatchesRepository
import com.example.gusports.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchFragmentViewModel @Inject constructor (private val matchesRepository: MatchesRepository):ViewModel() {

    val matches = MutableLiveData<Resource<ArrayList<DateMatches>>>()

    init {
        getMatches("cricket")
    }
    private fun getMatches(category:String){
        viewModelScope.launch {
            matches.postValue(Resource.Loading)
            matchesRepository.getMatches(Contants.DATEMATCHES,category) {
                matches.postValue(it)
            }
        }
    }



}