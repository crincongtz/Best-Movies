package com.crincongtz.bestmovies.main.presentation.mvp

import com.crincongtz.bestmovies.common.presentation.mvp.MvpContract
import com.crincongtz.bestmovies.common.presentation.mvp.WithFinish

interface MainContract {
    interface View : MvpContract.View, WithFinish {

    }

    interface Presenter : MvpContract.Presenter<View> {
        fun startMovieList()
    }
}
