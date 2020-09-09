package com.mohamedhashim.verycreatives_task.data.database.dao

import androidx.room.*
import com.mohamedhashim.verycreatives_task.data.entities.Movie

/**
 * Created by Mohamed Hashim on 9/8/2020.
 */
@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavouriteMovie(movie: Movie)

    @Update
    fun updateMovie(movie: Movie)

    @Query("SELECT * FROM Movie WHERE favourite = '1'")
    fun getFavouriteMovieList(): List<Movie>
}