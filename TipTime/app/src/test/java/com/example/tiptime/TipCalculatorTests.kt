package com.example.tiptime

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat


// Test local
class TipCalculatorTests {
    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.0
        val tipPercent = 20.0
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount, tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }
}