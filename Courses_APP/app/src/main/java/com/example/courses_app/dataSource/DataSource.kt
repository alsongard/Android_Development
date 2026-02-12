package com.example.courses_app.dataSource

import com.example.courses_app.R
import com.example.courses_app.model.TopicModel

class DataSource {
    fun getTopics(): List<TopicModel>
    {
        return listOf(
            TopicModel(R.string.architecture, "58", R.drawable.architecture),
            TopicModel(R.string.crafts, "121", R.drawable.crafts),
            TopicModel(R.string.business, "78", R.drawable.business),
            TopicModel(R.string.culinary, "118", R.drawable.culinary),
            TopicModel(R.string.design, "423", R.drawable.design),
            TopicModel(R.string.fashion, "92", R.drawable.fashion),
            TopicModel(R.string.film, "165", R.drawable.film),
            TopicModel(R.string.gaming, "164", R.drawable.gaming),
            TopicModel(R.string.drawing, "326", R.drawable.drawing),
            TopicModel(R.string.lifestyle, "305", R.drawable.lifestyle),
            TopicModel(R.string.music, "212", R.drawable.music),
            TopicModel(R.string.painting, "172", R.drawable.painting),
            TopicModel(R.string.photography, "321", R.drawable.photography),
            TopicModel(R.string.tech, "118", R.drawable.tech)
        )
    }
}
