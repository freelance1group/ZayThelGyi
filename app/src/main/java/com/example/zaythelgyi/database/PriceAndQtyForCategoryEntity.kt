package com.example.zaythelgyi.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class PriceAndQtyForCategoryEntity {
    @PrimaryKey(autoGenerate = true)
    var categoryId : Int = 0

    @ColumnInfo(name = "CategoryName")
    var categoryName : String = ""

    @ColumnInfo(name = "CategoryPrice")
    var categoryPrice : String = ""

    @ColumnInfo(name = "CategoryQuantity")
    var categoryQuantity : String = ""
}