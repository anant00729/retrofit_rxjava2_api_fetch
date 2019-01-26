package com.socket.an2t.apifetch.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.socket.an2t.apifetch.R
import com.socket.an2t.apifetch.models.Post

class PostA (internal  var context : Context , internal var postL : List<Post>) : RecyclerView.Adapter<PostVH>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostVH {
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.post_item,p0,false)

        return PostVH(itemView)
    }

    override fun getItemCount(): Int {
        return postL.size
    }

    override fun onBindViewHolder(h: PostVH, p1: Int) {
        val p = postL.get(p1)
        h.tv_title.text = p.title
        h.tv_desc.text = p.body
    }

}