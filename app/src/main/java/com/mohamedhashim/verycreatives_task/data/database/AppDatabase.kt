package com.mohamedhashim.verycreatives_task.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mohamedhashim.verycreatives_task.data.entities.Movie

/**
 * Created by Mohamed Hashim on 9/8/2020.
 */
@Database(
    entities = [Movie::class],
    version = 1, exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
}
