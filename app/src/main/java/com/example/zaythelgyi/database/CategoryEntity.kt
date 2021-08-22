package com.example.zaythelgyi.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CategoryEntity {

    @PrimaryKey(autoGenerate = true)
    var categoryId : Int = 0

    @ColumnInfo(name = "CategoryName")
    var categoryName : String = ""


}