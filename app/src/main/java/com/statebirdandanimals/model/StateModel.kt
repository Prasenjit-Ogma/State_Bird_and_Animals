package com.statebirdandanimals.model

data class StateModel(
    val stateName: String,
    val stateImage : Int = 0,
    val stateBirdImg: Int = 0,
    val stateBirdName: String = "",
    val stateBirdInfo: String = "",
    val stateAnimalImg: Int = 0,
    val stateAnimalName: String = "",
    val stateAnimalInfo: String = ""
)
