package io.wks.algorithms

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class SortingTest {

    @Nested
    inner class Bubble {

        @Test
        fun `GIVEN empty list WHEN sorted THEN list unchanged`() {
            // GIven
            val list = mutableListOf<Int>()

            // When
            BubbleSort<Int>().sort(list)

            // Then
            assertThat(list)
                .containsExactly()
        }

        @Test
        fun `GIVEN singleton list WHEN sorted THEN list unchanged`() {
            // GIven
            val list = mutableListOf(1)

            // When
            BubbleSort<Int>().sort(list)

            // Then
            assertThat(list)
                .containsExactly(1)
        }

        @Test
        fun `GIVEN sorted list WHEN sorted THEN list unchanged`() {
            // GIven
            val list = mutableListOf(1, 2, 3)

            // When
            BubbleSort<Int>().sort(list)

            // Then
            assertThat(list)
                .containsExactly(1, 2, 3)
        }

        @Test
        fun `GIVEN unsorted list WHEN sorted THEN sorted correct`() {
            // GIven
            val list = mutableListOf(45, 12, 65, 16, 34, 73, 11, 75, 90)

            // When
            BubbleSort<Int>().sort(list)

            // Then
            assertThat(list)
                .containsExactly(11, 12, 16, 34, 45, 65, 73, 75, 90)
        }
    }

    @Nested
    inner class Selection {

        @Test
        fun `GIVEN empty list WHEN sorted THEN list unchanged`() {
            // GIven
            val list = mutableListOf<Int>()

            // When
            SelectionSort<Int>().sort(list)

            // Then
            assertThat(list)
                .containsExactly()
        }

        @Test
        fun `GIVEN singleton list WHEN sorted THEN list unchanged`() {
            // GIven
            val list = mutableListOf(1)

            // When
            SelectionSort<Int>().sort(list)

            // Then
            assertThat(list)
                .containsExactly(1)
        }

        @Test
        fun `GIVEN sorted list WHEN sorted THEN list unchanged`() {
            // GIven
            val list = mutableListOf(1, 2, 3)

            // When
            SelectionSort<Int>().sort(list)

            // Then
            assertThat(list)
                .containsExactly(1, 2, 3)
        }

        @Test
        fun `GIVEN unsorted list WHEN sorted THEN sorted correct`() {
            // GIven
            val list = mutableListOf(45, 12, 65, 16, 34, 73, 11, 75, 90)

            // When
            SelectionSort<Int>().sort(list)
            print(list)
            // Then
            assertThat(list)
                .containsExactly(11, 12, 16, 34, 45, 65, 73, 75, 90)
        }
    }
}