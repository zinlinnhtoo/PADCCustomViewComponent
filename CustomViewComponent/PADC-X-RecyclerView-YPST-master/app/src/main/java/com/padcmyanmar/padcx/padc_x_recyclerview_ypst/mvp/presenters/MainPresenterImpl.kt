package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.data.models.NewsModelImpl
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    private val mNewsModel = NewsModelImpl

    override fun onTapNewsItem(newsId: Int) {
        mView?.navigateToNewsDetails(newsId)
    }

    override fun onTapLike() {
        Log.d("TAG", "onTapLike")
    }

    override fun onTapComment() {
        Log.d("TAG", "onTapComment")
    }

    override fun onTapShare() {
        Log.d("TAG", "onTapShare")
    }

    override fun onTapTryAgain() {
        loadAllNewsFromAPI()
    }

    private fun loadAllNewsFromAPI() {
        mNewsModel.getAllNewsFromApiAndSaveToDatabase(
            onSuccess = {},
            onError = {}
        )
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        requestAllNews(lifecycleOwner)
    }

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        requestAllNews(lifeCycleOwner)
    }

    private fun requestAllNews(lifeCycleOwner: LifecycleOwner) {
        mView?.enableSwipeRefresh()
        mNewsModel.getAllNews(onError = {
            mView?.disableSwipeRefresh()
//            mView?.displayEmptyView()
        }).observe(lifeCycleOwner, Observer {
            mView?.disableSwipeRefresh()
//            if (it.isEmpty()) mView?.displayEmptyView() else mView?.displayNewsList(it)
            mView?.displayNewsList(it)
        })
    }
}