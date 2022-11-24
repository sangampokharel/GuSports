package com.example.gusports.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gusports.models.Rules
import com.example.gusports.repository.RulesRepository
import com.example.gusports.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RulesActivityViewModel @Inject constructor(private val rulesRepository: RulesRepository):ViewModel() {

    val rules = MutableLiveData<Resource<Rules>>()



     fun getRules(category:String){
        rules.postValue(Resource.Loading)
        viewModelScope.launch {
            rulesRepository.getRules(category) {
                rules.postValue(it)
            }
        }
    }


}