package com.example.databindingquickstart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel(){
    var sMessage : MutableLiveData<String> =  MutableLiveData<String>()
    init{
        sMessage.value = "init MainViewModel"
    }
}