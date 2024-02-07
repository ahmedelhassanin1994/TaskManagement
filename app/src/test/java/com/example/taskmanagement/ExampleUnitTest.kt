package com.example.taskmanagement

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.taskmanagement.data.AppDatabase
import com.example.taskmanagement.data.Priority
import com.example.taskmanagement.data.Task
import com.example.taskmanagement.data.TaskDao
import com.google.common.truth.Truth
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class AppDatabaseTest : TestCase() {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}