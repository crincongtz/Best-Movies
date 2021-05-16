package com.crincongtz.bestmovies.common.presentation.mvp

interface MvpContract {

    interface View

    interface Presenter<T : View> {
        var view: T
    }
}

/**
 * Extension interface for view that finishing the view.
 * [finish] named that way specifically to reduce boilerplate when view is implemented by activity.
 */
interface WithFinish {
    /** Close the screen. */
    fun finish()
}

/**
 * Extension interface for view that allows progress indicator to be shown / hidden.
 */
interface WithProgressIndicator {
    fun showProgressIndicator()
    fun dismissProgressIndicator()
}
