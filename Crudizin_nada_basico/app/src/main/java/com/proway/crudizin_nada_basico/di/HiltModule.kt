package com.proway.crudizin_nada_basico.di


import android.content.Context
import com.proway.crudizin_nada_basico.database.AppDatabase
import com.proway.crudizin_nada_basico.database.dao.AgendaDao
import com.proway.crudizin_nada_basico.database.dao.DoctorDao
import com.proway.crudizin_nada_basico.database.dao.PatientDao
import com.proway.crudizin_nada_basico.database.dao.SpecialityDao
import com.proway.crudizin_nada_basico.repository.DoctorRepository
import com.proway.crudizin_nada_basico.repository.PatientRepository
import com.proway.crudizin_nada_basico.repository.SpecialityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideSpecialityRepository(@ApplicationContext context: Context): SpecialityRepository = SpecialityRepository(provideSpecialityDao(context))

    @Provides
    fun providePatientRepository(@ApplicationContext context: Context): PatientRepository = PatientRepository(providePatientDao(context))

    @Provides
    fun provideDoctorRepository(@ApplicationContext context: Context): DoctorRepository {
        return DoctorRepository(provideDoctorDao(context))
    }

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