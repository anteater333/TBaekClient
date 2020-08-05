package com.example.tbaekclient.ui.searchresult

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tbaekclient.model.TeaDataModel
import com.example.tbaekclient.tool.Potato

class SearchResultViewModel : ViewModel() {
    private val _searchResultList = MutableLiveData<ArrayList<TeaDataModel>>().apply {
        this.value = Potato.SEARCHRESULT
    }

    /**
     * TODO: SearchResultFragment 생성 시에 검색 결과로 초기화해줘야 합니다.
     */
    val searchResultList: MutableLiveData<ArrayList<TeaDataModel>> = _searchResultList

    private var _selectedItem: MutableLiveData<TeaDataModel>? = MutableLiveData<TeaDataModel>().apply {
        this.value = TeaDataModel()
    }

    var selectedItem: MutableLiveData<TeaDataModel>? = _selectedItem

}