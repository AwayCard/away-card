package br.com.awaycard

import android.os.Build
import androidx.room.Room
import br.com.awaycard.data.AppDatabase
import br.com.awaycard.data.InMemoryUserRegister
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class InMemoryUserRegisterTest {
    private val inMemoryRegister by lazy { InMemoryUserRegister(dbApp) }

    private val dbApp by lazy {
        Room.inMemoryDatabaseBuilder(
            RuntimeEnvironment.systemContext,
            AppDatabase::class.java
        ).build()
    }

    @Test
    fun registerSuccessUser() = runBlocking {
        inMemoryRegister.insert("jvprogramador")
        assertEquals("jvprogramador", inMemoryRegister.get())
    }

    @Test fun registerInfosTwice() {
        runBlocking {
            inMemoryRegister.insert("jvprogramador")
            inMemoryRegister.insert("jovemprogramador")
            assertEquals("jovemprogramador", inMemoryRegister.get())
        }
    }

    @Test fun registerWithoutInformation() {
        assertThrows(IllegalArgumentException::class.java) {
            runBlocking {
                inMemoryRegister.insert("")
            }
        }
    }

    @Test fun registerDuplicate() {
        runBlocking {
            inMemoryRegister.insert("jvprogramador")
            inMemoryRegister.insert("jvprogramador")
            assertEquals("jvprogramador", inMemoryRegister.get())
        }
    }

    @After fun tearDown() {
        inMemoryRegister.onClose()
    }
}

