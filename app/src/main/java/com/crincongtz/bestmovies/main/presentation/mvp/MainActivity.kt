package com.crincongtz.bestmovies.main.presentation.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crincongtz.bestmovies.R
import com.crincongtz.bestmovies.dagger.components.MainComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.startMovieList()
    }

    private fun injectDependencies() {
        MainComponent.get(this, this)
            .inject(this)
    }
}
