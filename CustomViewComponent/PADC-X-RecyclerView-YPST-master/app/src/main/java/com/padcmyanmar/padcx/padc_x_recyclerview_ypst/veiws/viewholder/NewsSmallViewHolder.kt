package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.data.vos.NewsVO
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.delegates.NewsItemDelegate
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewpods.ReactionViewPod
import kotlinx.android.synthetic.main.item_news.view.*
import kotlinx.android.synthetic.main.item_news_smalll.view.*
import kotlinx.android.synthetic.main.item_news_smalll.view.ivNewsImage
import kotlinx.android.synthetic.main.item_news_smalll.view.tvNewsHeadLine
import kotlinx.android.synthetic.main.item_news_smalll.view.viewPodReaction

/**
 * Created by Ye Pyae Sone Tun
 * on 2020-01-18.
 */

class NewsSmallViewHolder(itemView: View,private val delegate : NewsItemDelegate) : BaseNewsViewHolder(itemView){

    private val mViewPodReaction = itemView.viewPodReaction as ReactionViewPod

    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapNewsItem(it.id)
            }
        }
    }

    override fun bindData(data: NewsVO) {
        mData = data
        Glide.with(itemView.context)
            .load(data.heroImage)
            .into(itemView.ivNewsImage)
        itemView.tvNewsHeadLine.text = data.title

        mViewPodReaction.bindData(data)
        mViewPodReaction.setDelegate(delegate)
    }
}