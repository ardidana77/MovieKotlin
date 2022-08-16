package com.example.moviekotlin.Api

import com.example.moviekotlin.Model.PeopleModel

interface PeopleApi {

    suspend fun getCategory() : PeopleModel

}