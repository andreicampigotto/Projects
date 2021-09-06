package com.proway.crudizin_basico.di

import android.content.Context
import com.proway.crudizin_basico.database.AppDatabase
import com.proway.crudizin_basico.database.dao.AgendaDao
import com.proway.crudizin_basico.database.dao.DoctorDao
import com.proway.crudizin_basico.database.dao.PatientDao
import com.proway.crudizin_basico.database.dao.SpecialityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideSpecialityDao(@ApplicationContext context: Context): SpecialityDao {
        return AppDatabase.getDatabase(context).getSpecialityDao()
    }

    @Provides
    fun providePatientDao(@ApplicationContext context: Context): PatientDao {
        return AppDatabase.getDatabase(context).getPatientDao()
    }

    @Provides
    fun provideDoctorDao(@ApplicationContext context: Context): DoctorDao {
        return AppDatabase.getDatabase(context).getDoctorDao()
    }

    @Provides
    fun provideAgendaDao(@ApplicationContext context: Context): AgendaDao {
        return AppDatabase.getDatabase(context).getAgendaDao()
    }

}