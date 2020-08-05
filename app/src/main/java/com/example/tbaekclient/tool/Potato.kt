package com.example.tbaekclient.tool

import android.graphics.drawable.ColorDrawable
import com.example.tbaekclient.model.TagDataModel
import com.example.tbaekclient.model.TeaDataModel

/**
 * Assumed server made with some potatoes.
 * 감자로 만든 서버입니다. 나중에 삶아먹읍시다.
 */
object Potato {

    val SEARCHRESULT : ArrayList<TeaDataModel> = arrayListOf(
        TeaDataModel(
            "얼그레이",
            "홍차",
            "홍차 잎에 베르가못의 껍질로부터 추출한 기름을 첨가함으로써 특이한 향을 내도록 블렌드한 가향차의 일종이다.",
            ColorDrawable(android.R.color.holo_red_dark).color,
            0.5f,
            0.9f,
            14f,
            true,
            arrayListOf<String>(
                "티포트 2개(우려내는 용과 서빙 용)와 찻잔, 타이머, 티코지 등 준비하고 찻잎을 예열한 티포트에 넣는다.",
                "뜨거운 물(95~98도)을 티포트에 붓고 찻잎에 적당한 시간 동안 우린다.",
                "찻잎은 스트레이너로 거르고 차는 서빙용 포트에 옮겨 담는다. 예열된 찻잔에 따라서 마신다."
            ),
            arrayListOf<TagDataModel>(
                TagDataModel("카페인", ColorDrawable(android.R.color.black).color),
                TagDataModel("다이어트", ColorDrawable(android.R.color.holo_green_light).color)
            ),
            arrayListOf<TagDataModel>(
                TagDataModel("노화방지", ColorDrawable(android.R.color.holo_green_light).color),
                TagDataModel("충치 예방", ColorDrawable(android.R.color.holo_blue_light).color),
                TagDataModel("스트레스 예방", ColorDrawable(android.R.color.holo_red_light).color)
            )
        ),
        TeaDataModel(
            "우전",
            "녹차",
            "24절기 중 하나인 곡우 전에 찻잎을 따서 만든 차를 말한다. 이른 봄 가장 먼저 딴 찻잎으로 만든 차라 하여 첫물차라고도 한다.",
            ColorDrawable(android.R.color.holo_green_dark).color,
            0.9f,
            0.2f,
            9.7f,
            false,
            arrayListOf<String>(
                "티포트 2개(우려내는 용과 서빙 용)와 찻잔, 타이머, 티코지 등 준비하고 찻잎을 예열한 티포트에 넣는다.",
                "뜨거운 물(95~98도)을 티포트에 붓고 찻잎에 적당한 시간 동안 우린다.",
                "찻잎은 스트레이너로 거르고 차는 서빙용 포트에 옮겨 담는다. 예열된 찻잔에 따라서 마신다."
            ),
            arrayListOf<TagDataModel>(
                TagDataModel("다이어트", ColorDrawable(android.R.color.holo_green_light).color)
            ),
            arrayListOf<TagDataModel>(
                TagDataModel("스트레스 예방", ColorDrawable(android.R.color.holo_red_light).color),
                TagDataModel("진정효과", ColorDrawable(android.R.color.holo_purple).color)
            )
        ),
        TeaDataModel(
            "막걸리",
            "술",
            "막걸리는 한국의 전통주로, 탁주나 농주, 재주, 회주라고도 한다. 보통 쌀이나 밀에 누룩을 첨가하여 발효시켜 만든다. 발효와 함께 유산균 뒤에 짤려있는데 뭐라고 더 적으면 될까 모르겠다 으히힛.",
            ColorDrawable(android.R.color.darker_gray).color,
            0.83f,
            0.48f,
            0.0f,
            false,
            arrayListOf<String>(
                "티포트 2개(우려내는 용과 서빙 용)와 찻잔, 타이머, 티코지 등 준비하고 찻잎을 예열한 티포트에 넣는다.",
                "뜨거운 물(95~98도)을 티포트에 붓고 찻잎에 적당한 시간 동안 우린다.",
                "찻잎은 스트레이너로 거르고 차는 서빙용 포트에 옮겨 담는다. 예열된 찻잔에 따라서 마신다."
            ),
            arrayListOf<TagDataModel>(

            ),
            arrayListOf<TagDataModel>(

            )
        )
    )
}