package com.crincongtz.bestmovies.common.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.crincongtz.bestmovies.R
import com.crincongtz.bestmovies.movies.data.network.model.Movie
import com.crincongtz.bestmovies.utils.BASE_URL_IMAGES
import kotlinx.android.synthetic.main.item_movies_list.view.*

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MovieHolder>() {

    private var movieItems = ArrayList<Movie>()
    private var context : Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        context = parent.context
        val inflater = LayoutInflater.from(parent.context)
        return MovieHolder(inflater.inflate(R.layout.item_movies_list, parent, false))
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.titleMovie.text = movieItems[position].title
        context.let {
            Glide.with(context!!)
                    .load(BASE_URL_IMAGES + movieItems[position].posterImagePath)
                    .into(holder.posterMovie)
            // Setting the popularity of the movie
            holder.popularityMovie.text = context!!
                    .getString(R.string.popularity_text, movieItems[position].popularity)
            // Setting the rating of the movie
            holder.ratingMovie.text = context!!
                    .getString(R.string.rating_text, movieItems[position].rating)
        }
    }

    override fun getItemCount(): Int {
        return movieItems.size
    }

    fun refreshDataMovies(list: List<Movie>) {
        movieItems = ArrayList(list)
        notifyDataSetChanged()
    }

    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val posterMovie: ImageView = itemView.imagePosterItem
        val titleMovie: TextView = itemView.textTitleMovie
        val popularityMovie: TextView = itemView.textPopularity
        val ratingMovie: TextView = itemView.textRating
    }
}
