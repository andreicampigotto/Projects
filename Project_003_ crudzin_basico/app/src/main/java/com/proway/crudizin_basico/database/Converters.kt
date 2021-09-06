package com.proway.crudizin_basico.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import java.sql.Types

class Converters {
    @TypeConverter
    fun listToJson(value: List<Types>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String)= Gson().fromJson(value, Array<Types>::class.java).toList()
}