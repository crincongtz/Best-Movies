package com.crincongtz.bestmovies.common.presentation.mvp

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

/**
 * Base class for presenters operating with Rx streams.
 *
 * Tracks the disposable and dispose them when stopped. The subclasses each define when the presenter is stopped.
 */
abstract class RxPresenter {

    private val compositeDisposable = CompositeDisposable()

    protected fun onStop() {
        compositeDisposable.clear()
    }

    protected fun Disposable.trackDisposable() = compositeDisposable.add(this)
}

/**
 * An RxPresenter that acts as a lifecycle observer to call stop when the view's lifecycle is destroyed.
 * Disposes observable onStop and onDestroy.
 * To be used by activities and fragments acting as a View (MVP View, not Android View).
 */
abstract class LifecycleStopAwareRxPresenter<V : LifecycleOwner>(
    view: V
) : RxPresenter(), LifecycleObserver {

    private val lifecycle: Lifecycle = view.lifecycle

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStopCalled() {
        onStop()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroyCalled() {
        lifecycle.removeObserver(this)
    }
}
