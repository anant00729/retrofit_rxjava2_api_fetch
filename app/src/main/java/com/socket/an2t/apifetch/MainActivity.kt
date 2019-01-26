package com.socket.an2t.apifetch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.socket.an2t.apifetch.adapter.PostA
import com.socket.an2t.apifetch.models.Post
import com.socket.an2t.apifetch.retrofit.RetrofitClient
import com.socket.an2t.apifetch.retrofit.ServiceAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.create

class MainActivity : AppCompatActivity() {


    internal lateinit var mSAPI : ServiceAPI
    internal lateinit var mCD : CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mR = RetrofitClient.instance
        mSAPI = mR.create(ServiceAPI::class.java)
        mCD = CompositeDisposable()

        rv_main.setHasFixedSize(true)
        rv_main.layoutManager = LinearLayoutManager(this)
        fetchData()

    }

    private fun fetchData() {
        mCD.add(mSAPI.posts
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{p->displayData(p)}
        )

    }

    private fun displayData(p: List<Post>?) {
        val mA = PostA(this,p!!)
        rv_main.adapter = mA

    }

}
