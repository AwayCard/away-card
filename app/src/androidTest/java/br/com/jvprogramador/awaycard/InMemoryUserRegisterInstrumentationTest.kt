package br.com.jvprogramador.awaycard

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import br.com.jvprogramador.awaycard.data.AppDatabase
import br.com.jvprogramador.awaycard.data.InMemoryUserRegister
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class InMemoryUserRegisterInstrumentationTest {
    private val inMemoryRegister by lazy { InMemoryUserRegister(dbApp) }

    private val dbApp by lazy {
        Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
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
        runBlocking {
            assertThrows<IllegalArgumentException> {
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
}

