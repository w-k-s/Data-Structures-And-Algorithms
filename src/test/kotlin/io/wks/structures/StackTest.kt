package io.wks.structures

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class StackTest {

    @Nested
    inner class Create {
        @Test
        fun `GIVEN a stack WHEN created THEN length of stack is 0`() {
            val stack = Stack<Int>()

            // THEN
            assertThat(stack.size()).isEqualTo(0)
            assertThat(stack.toString()).isEqualTo("[]")
        }

        @Test
        fun `GIVEN a stack WHEN created with a node THEN length of stack is 1`() {
            val stack = Stack(1)

            // THEN
            assertThat(stack.size()).isEqualTo(1)
            assertThat(stack.toString()).isEqualTo("[1]")
        }
    }

    @Nested
    inner class Push {

        @Test
        fun `GIVEN empty stack WHEN 3 items pushed THEN length = 3`() {
            // GIVEN
            val stack = Stack<Int>()

            // WHEN
            stack.push(1)
            stack.push(2)
            stack.push(3)

            // THEN
            assertThat(stack.size()).isEqualTo(3)
            assertThat(stack.toString()).isEqualTo("[3,2,1]")
        }
    }

    @Nested
    inner class Pop {

        @Test
        fun `GIVEN empty stack WHEN popped THEN returns null`() {
            // GIVEN
            val stack = Stack<Int>()

            // WHEN
            val popped = stack.pop()

            // THEN
            assertThat(popped).isNull()
            assertThat(stack.size()).isEqualTo(0)
            assertThat(stack.toString()).isEqualTo("[]")
        }

        @Test
        fun `GIVEN non-empty stack WHEN popped THEN last item added is pooped`() {
            // GIVEN
            val stack = Stack(5)

            // WHEN
            stack.push(4)
            stack.push(3)
            stack.push(2)
            stack.push(1)

            // THEN
            assertThat(stack.pop()).isEqualTo(1)
            assertThat(stack.size()).isEqualTo(4)
            assertThat(stack.toString()).isEqualTo("[2,3,4,5]")

            assertThat(stack.pop()).isEqualTo(2)
            assertThat(stack.size()).isEqualTo(3)
            assertThat(stack.toString()).isEqualTo("[3,4,5]")

            assertThat(stack.pop()).isEqualTo(3)
            assertThat(stack.size()).isEqualTo(2)
            assertThat(stack.toString()).isEqualTo("[4,5]")

            assertThat(stack.pop()).isEqualTo(4)
            assertThat(stack.size()).isEqualTo(1)
            assertThat(stack.toString()).isEqualTo("[5]")

            assertThat(stack.pop()).isEqualTo(5)
            assertThat(stack.size()).isEqualTo(0)
            assertThat(stack.toString()).isEqualTo("[]")

            assertThat(stack.isEmpty).isTrue
        }
    }
}