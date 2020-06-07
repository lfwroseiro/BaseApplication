package br.com.baseapplication.data.source.local.db.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface BaseDao<T> {

    // FIXME: OnConflictStrategy.REPLACE not working
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<T>)
}
