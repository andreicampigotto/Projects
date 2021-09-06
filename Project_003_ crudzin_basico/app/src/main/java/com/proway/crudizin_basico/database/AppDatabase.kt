package com.proway.crudizin_basico.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.proway.crudizin_basico.database.dao.AgendaDao
import com.proway.crudizin_basico.database.dao.DoctorDao
import com.proway.crudizin_basico.database.dao.PatientDao
import com.proway.crudizin_basico.database.dao.SpecialityDao
import com.proway.crudizin_basico.model.Agenda
import com.proway.crudizin_basico.model.Doctor
import com.proway.crudizin_basico.model.Patient
import com.proway.crudizin_basico.model.Speciality

@Database(
    entities = [
        Patient::class,
        Doctor::class,
        Agenda::class,
        Speciality::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getPatientDao(): PatientDao
    abstract fun getDoctorDao(): DoctorDao
    abstract fun getAgendaDao(): AgendaDao
    abstract fun getSpecialityDao(): SpecialityDao

    companion object {
        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "crudizin_basico_app_db"
            )
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }
}