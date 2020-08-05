package com.example.tbaekclient.model

/**
 * 서버의 차 정보를 레이아웃에 표현하는데
 * 필요한 데이터를 담아두는 DTO 클래스
 */
class TeaDataModel (
    val name: String = "",
    val category: String = "",
    val description: String = "",
    val themeColor: Int = 0,
    val popular: Float = 0.0f,
    val recommend: Float = 0.0f,
    val caffeine: Float = 0.0f,
    var isBookmarked: Boolean = false,
    var infuseSteps: ArrayList<String>? = null,
    var tagList: ArrayList<TagDataModel>? = null,
    var effectList: ArrayList<TagDataModel>? = null
)  {

}
