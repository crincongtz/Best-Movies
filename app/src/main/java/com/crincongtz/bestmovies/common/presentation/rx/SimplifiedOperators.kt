package com.crincongtz.bestmovies.common.presentation.rx

import com.crincongtz.bestmovies.common.presentation.mvp.WithProgressIndicator
import io.reactivex.rxjava3.core.Single

/**
 * Shows progress indicator once subscriber subscribes and hides progress indicator when stream finished.
 *
 * To ensure that any other `doOnSubscribe` and `doOnFinally` calls happens when progress indicator is shown:
 * * Set schedulers using `subscribeOn(...` and `observeOn(...` __before__ the `.withProgressIndicator` call.
 * * Add `doOnSubscribe` and `doOnFinally` __after__ the `.withProgressIndicator`.
 */
fun <T> Single<T>.withProgressIndicator(progressIndicator: WithProgressIndicator): Single<T> {
    return this
        .doOnSubscribe {
            progressIndicator.showProgressIndicator()
        }
        .doFinally {
            progressIndicator.dismissProgressIndicator()
        }
}

