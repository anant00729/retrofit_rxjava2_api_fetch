package com.socket.an2t.apifetch.retrofit

import com.socket.an2t.apifetch.models.Post
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface ServiceAPI {

    @get:GET("posts")
    val posts:Observable<List<Post>>
}