package com.example.zaythelgyi.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PriceAndQtyForCategoryDAO {

    @Insert
    fun savePriceAndQtyForCategory(priceAndQtyForCategory : PriceAndQtyForCategoryEntity)

    @Query("select * from PriceAndQtyForCategoryEntity")
    fun getAllData() : List<PriceAndQtyForCategoryEntity>
}