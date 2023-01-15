package io.wks.algorithms

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FactorialTest{

    @Test
    fun `Given n WHEN calculating factorial THEN result is correct`(){
        assertThat(factorial(4)).isEqualTo(24)
    }
}