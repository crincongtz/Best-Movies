package com.crincongtz.bestmovies.movies.presentation.mvp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.crincongtz.bestmovies.R
import com.crincongtz.bestmovies.common.presentation.adapters.MoviesAdapter
import com.crincongtz.bestmovies.dagger.components.MovieListComponent
import com.crincongtz.bestmovies.movies.data.network.model.Movie
import kotlinx.android.synthetic.main.activity_movie_list.*
import javax.inject.Inject

class MovieListActivity : AppCompatActivity(), MovieListContract.View {

    @Inject
    lateinit var presenter: MovieListContract.Presenter

    private val moviesAdapter = MoviesAdapter()

    companion object {
        fun createIntent(context: Context) = Intent(context, MovieListActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        setViews()
        presenter.onStart()
    }

    private fun injectDependencies() {
        MovieListComponent.get(this, this)
            .inject(this)
    }

    private fun setViews() {
        recycler_movies.setHasFixedSize(true)
        recycler_movies.layoutManager = GridLayoutManager(recycler_movies.context as AppCompatActivity, 2)
        recycler_movies.adapter = moviesAdapter
    }

    override fun loadMovieList(movies: List<Movie>) {
        if (movies.isNotEmpty()) {
            moviesAdapter.refreshDataMovies(movies)
        }
    }

    override fun showProgressIndicator() {
        progress_view.visibility = View.VISIBLE
    }

    override fun dismissProgressIndicator() {
        progress_view.visibility = View.GONE
    }
}
