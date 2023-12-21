package com.isfa.home

import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test

class Calculator {

    fun sum(a: Int, b: Int): Int {
        return a + b
    }
}

interface CalculatorMock {
    fun sum(a: Int, b: Int): Int
}

class CalculatorMockImpl(val calculatorMock: CalculatorMock?) {

    fun sum(a: Int, b: Int): Int {
        return calculatorMock?.sum(a, b) ?: 0
    }
}

class ExerciseCalculator {

    private val calculatorMock = mockk<CalculatorMock>()

    @Test
    fun test_sum_of_two_variables_from_mock() {
        // Given
        val a = 2
        val b = 2
        val expectedValue = 4

        // Interception:
        // Jika ((calculatorMock.sum(a, b))) dipanggil, maka
        // Menghasilkan ((expectedValue))
        every { calculatorMock.sum(a, b) } returns expectedValue

        // When
        val calculator = CalculatorMockImpl(calculatorMock)

        val result = calculator.sum(a, b)

        // Then
        assertEquals(expectedValue, result)
    }

    @Test
    fun test_sum_of_two_variables_correctly() {
        // Given
        val a = 1
        val b = 2
        val expectedValue = 3

        // When
        val calculator = Calculator()
        val result = calculator.sum(a, b)

        // Then
        assertEquals(expectedValue, result)
    }
}