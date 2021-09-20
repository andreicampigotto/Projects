package com.proway.project_four.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.proway.project_four.database.dao.PokeDAO
import com.proway.project_four.model.Pokemon

// Aqui cria o banco
@Database(
    entities = [
        Pokemon::class
    ],
    version = 1,
)
abstract class AppDatabase : RoomDatabase(){
    //porque mesmo eh abstract?
    abstract fun getPokeDAO(): PokeDAO

    //Singleton que gera o AppDatabase com tudo implementado pelo room, reforcar como funciona
    companion object{
        fun getDatabase(context: Context): AppDatabase{
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "pokemon_dp"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}