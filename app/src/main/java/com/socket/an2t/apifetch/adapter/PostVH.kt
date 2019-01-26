package com.socket.an2t.apifetch.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.post_item.view.*

class PostVH(itemView : View) : RecyclerView.ViewHolder(itemView){
    var tv_title = itemView.tv_title
    var tv_desc = itemView.tv_desc

}