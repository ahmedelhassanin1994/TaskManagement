package com.example.taskmanagement

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.taskmanagement.data.AppDatabase
import com.example.taskmanagement.data.Priority
import com.example.taskmanagement.data.Task
import com.example.taskmanagement.data.TaskDao
import com.google.ar.core.Config
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import java.util.concurrent.CountDownLatch

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class AppDatabaseTest  {
    // get reference to the LanguageDatabase and LanguageDao class
    private lateinit var database: AppDatabase
    private lateinit var wordsDao: TaskDao


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setupDatabase() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        wordsDao = database.taskDao()
    }



    @After
    fun closeDatabase() {
        database.close()
    }

    @Test
    fun insertWord_returnsTrue() = runBlocking {


        val task=Task(name = "test", priority = Priority.MEDIUM, date = "www")
        wordsDao.insertTask(task)

        val taskes=wordsDao.getAllTask()

        assertThat(taskes).contains(task)



    }

//    @Test
//    fun deleteWord_returnsTrue() = runBlocking {
//        wordsDao.insertTask(Task(name = "test", priority = Priority.MEDIUM, date = "www"))
//        wordsDao.deleteTask(Task(name = "test", priority = Priority.MEDIUM, date = "www"))
//
//        val latch = CountDownLatch(1)
//        val taskes=wordsDao.getAllTask()
//        latch.await()
//        Truth.assertThat(taskes).doesNotContain(Task(name = "test", priority = Priority.MEDIUM, date = "www"))
//
//    }
}