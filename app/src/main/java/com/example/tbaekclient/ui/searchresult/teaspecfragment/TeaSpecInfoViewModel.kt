package com.example.tbaekclient.ui.searchresult.teaspecfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tbaekclient.model.TeaDataModel

class TeaSpecInfoViewModel : ViewModel() {
    private var _item = MutableLiveData<TeaDataModel>().apply {
        this.value = TeaDataModel() // Empty data
    }

    var item: MutableLiveData<TeaDataModel> = _item
}