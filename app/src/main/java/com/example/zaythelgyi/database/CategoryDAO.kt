package com.example.zaythelgyi.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CategoryDAO {

    @Insert
    fun saveCategory(category : CategoryEntity)

    @Query("select * from CategoryEntity")
    fun getAllCategory(categoryName: String): List<CategoryEntity>



}