package com.example.zaythelgyi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(CategoryEntity::class)], version = 1)
abstract class AppDB: RoomDatabase() {
    abstract fun categoryDao(): CategoryDAO

    companion object {
        private var INSTANCE: AppDB? = null

        fun getAppDB(context: Context): AppDB {
            if (INSTANCE == null) {
                synchronized(AppDB::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDB::class.java,
                        "MyCategoryDB"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE!!
        }

        fun deleteData() {
            INSTANCE = null
        }
    }
}