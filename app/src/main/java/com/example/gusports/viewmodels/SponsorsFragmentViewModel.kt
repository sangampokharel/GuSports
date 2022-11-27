package com.example.gusports.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gusports.models.Sponsor
import com.example.gusports.repository.SponsorsRepository
import com.example.gusports.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SponsorsFragmentViewModel @Inject constructor(private val sponsorsRepository: SponsorsRepository):ViewModel() {

    val sponsors = MutableLiveData<Resource<List<Sponsor>>>()
   init {
       getSponsors()
   }

    private fun getSponsors(){
        viewModelScope.launch {
            sponsors.postValue(Resource.Loading)
            sponsorsRepository.getSponsors {
                sponsors.postValue(it)
            }
        }
    }


}