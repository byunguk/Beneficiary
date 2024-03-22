package com.example.beneficiaries

import com.example.beneficiaries.util.formatDob
import com.example.beneficiaries.util.formatSsn
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UtilsUnitTest {
    @Test
    fun test_formatSsn() {
        assertEquals("123-45-6789", "123456789".formatSsn())
        assertEquals("1234567890", "1234567890".formatSsn())
    }

    @Test
    fun test_formatDob() {
        assertEquals("12/30/2000", "12302000".formatDob())
        assertEquals("01/30/2001", "13302000".formatDob())
    }
}