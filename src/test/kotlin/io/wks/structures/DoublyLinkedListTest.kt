package io.wks.structures

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DoublyLinkedListTest {

    @Test
    fun `GIVEN a doubly linked list WHEN created with initial value THEN length is 1`() {
        val list = DoublyLinkedList(1)

        assertThat(list.size()).isEqualTo(1)
        assertThat(list.toString()).isEqualTo("[1]")
    }

    @Nested
    inner class Append {

        @Test
        fun `GIVEN empty list WHEN append item THEN length is 1`() {
            // GIVEN
            val list = DoublyLinkedList<Int>()

            // WHEN
            list.append(1)

            // THEN
            assertThat(list.size()).isEqualTo(1)
            assertThat(list.toString()).isEqualTo("[1]")
        }

        @Test
        fun `GIVEN non-empty list WHEN append item THEN item added to end`() {
            // GIVEN
            val list = DoublyLinkedList(1)

            // WHEN
            list.append(2)

            // THEN
            assertThat(list.size()).isEqualTo(2)
            assertThat(list.toString()).isEqualTo("[1,2]")
        }
    }

    @Nested
    inner class Prepend {

        @Test
        fun `GIVEN empty list WHEN prepend item THEN length is 1`() {
            // GIVEN
            val list = DoublyLinkedList<Int>()

            // WHEN
            list.prepend(1)

            // THEN
            assertThat(list.size()).isEqualTo(1)
            assertThat(list.toString()).isEqualTo("[1]")
        }

        @Test
        fun `GIVEN non-empty list WHEN prepend item THEN item added to beginning`() {
            // GIVEN
            val list = DoublyLinkedList(3)

            // WHEN
            list.prepend(2)
            list.prepend(1)

            // THEN
            assertThat(list.size()).isEqualTo(3)
            assertThat(list.toString()).isEqualTo("[1,2,3]")
        }
    }

    @Nested
    inner class Pop {

        @Test
        fun `GIVEN empty list WHEN pop THEN length is 0`() {
            // GIVEN
            val list = DoublyLinkedList<Int>()

            // WHEN
            list.pop()

            // THEN
            assertThat(list.size()).isEqualTo(0)
            assertThat(list.toString()).isEqualTo("[]")
        }

        @Test
        fun `GIVEN non-empty list WHEN pop THEN last item returned`() {
            // GIVEN
            val list = DoublyLinkedList(1)

            // WHEN
            list.append(2)
            list.pop()

            // THEN
            assertThat(list.size()).isEqualTo(1)
            assertThat(list.toString()).isEqualTo("[1]")
        }
    }

    @Nested
    inner class PopFirst {

        @Test
        fun `GIVEN empty list WHEN pop first THEN length is 0`() {
            // GIVEN
            val list = DoublyLinkedList<Int>()

            // WHEN
            list.popFirst()

            // THEN
            assertThat(list.size()).isEqualTo(0)
            assertThat(list.toString()).isEqualTo("[]")
        }

        @Test
        fun `GIVEN non-empty list WHEN pop first THEN first item returned`() {
            // GIVEN
            val list = DoublyLinkedList(1)

            // WHEN
            list.append(2)
            list.append(3)
            list.popFirst()

            // THEN
            assertThat(list.size()).isEqualTo(2)
            assertThat(list.toString()).isEqualTo("[2,3]")
        }
    }

    @Nested
    inner class Get {
        @Test
        fun `GIVEN empty list WHEN get THEN array index out of bounds exception`() {
            // GIVEN
            val list = DoublyLinkedList<Int>()

            // WHEN
            Assertions.assertThatThrownBy { list[0] }
                .isInstanceOf(IndexOutOfBoundsException::class.java)
                .hasMessage("Index: 0. Size: 0")
        }

        @Test
        fun `GIVEN list with 1 item WHEN get at index 1 THEN array index out of bounds exception`() {
            /// GIVEN
            val list = DoublyLinkedList(1)

            // WHEN
            Assertions.assertThatThrownBy { list[1] }
                .isInstanceOf(IndexOutOfBoundsException::class.java)
                .hasMessage("Index: 1. Size: 1")
        }

        @Test
        fun `GIVEN non empty list WHEN get item at index THEN correct value returned`() {
            // GIVEN
            val list = DoublyLinkedList<Int>()

            // WHEN
            list.append(1)
            list.append(2)
            list.append(3)

            // THEN
            assertThat(list[0]).isEqualTo(1)
            assertThat(list[1]).isEqualTo(2)
            assertThat(list[2]).isEqualTo(3)
        }
    }

    @Nested
    inner class Set {
        @Test
        fun `GIVEN empty list WHEN set THEN array index out of bounds exception`() {
            // GIVEN
            val list = DoublyLinkedList<Int>()

            // WHEN
            Assertions.assertThatThrownBy { list[0] = 1 }
                .isInstanceOf(IndexOutOfBoundsException::class.java)
                .hasMessage("Index: 0. Size: 0")
        }

        @Test
        fun `GIVEN list with 1 item WHEN set at index 1 THEN array index out of bounds exception`() {
            /// GIVEN
            val list = DoublyLinkedList(1)

            // WHEN
            Assertions.assertThatThrownBy { list[1] = 2 }
                .isInstanceOf(IndexOutOfBoundsException::class.java)
                .hasMessage("Index: 1. Size: 1")
        }

        @Test
        fun `GIVEN non empty list WHEN set item at index THEN correct value returned`() {
            // GIVEN
            val list = DoublyLinkedList<Int>()
            list.append(1)
            list.append(2)
            list.append(3)

            // WHEN
            list[0] = list[0] * 2
            list[1] = list[1] * 2
            list[2] = list[2] * 2

            // THEN
            assertThat(list[0]).isEqualTo(2)
            assertThat(list[1]).isEqualTo(4)
            assertThat(list[2]).isEqualTo(6)
            assertThat(list.size()).isEqualTo(3)
        }
    }

    @Nested
    inner class Insert {
        @Test
        fun `GIVEN empty list WHEN insert at index 0 THEN item added`() {
            // GIVEN
            val list = DoublyLinkedList<Int>()

            list.insert(0, 1)

            // WHEN
            assertThat(list.size()).isEqualTo(1)
            assertThat(list.toString()).isEqualTo("[1]")
        }

        @Test
        fun `GIVEN list with 1 item WHEN insert at index 2 THEN array index out of bounds exception`() {
            /// GIVEN
            val list = DoublyLinkedList(1)

            // WHEN
            Assertions.assertThatThrownBy { list.insert(3, 2) }
                .isInstanceOf(IndexOutOfBoundsException::class.java)
                .hasMessage("Index: 3. Size: 1")
        }

        @Test
        fun `GIVEN non empty list WHEN set item at index THEN correct value returned`() {
            // GIVEN
            val list = DoublyLinkedList<Int>()
            list.append(1)
            list.append(2)
            list.append(3)
            list.append(5)

            // WHEN
            list.insert(2, 4)

            // THEN
            assertThat(list[0]).isEqualTo(1)
            assertThat(list[1]).isEqualTo(2)
            assertThat(list[2]).isEqualTo(3)
            assertThat(list[3]).isEqualTo(4)
            assertThat(list[4]).isEqualTo(5)
            assertThat(list.size()).isEqualTo(5)
        }
    }

    @Nested
    inner class Remove {
        @Test
        fun `GIVEN empty list WHEN remove at index 0 THEN array index out of bounds exception`() {
            // GIVEN
            val list = DoublyLinkedList<Int>()

            // WHEN
            Assertions.assertThatThrownBy { list.remove(0) }
                .isInstanceOf(IndexOutOfBoundsException::class.java)
                .hasMessage("Index: 0. Size: 0")
        }

        @Test
        fun `GIVEN list with 1 item WHEN remove at index 1 THEN array index out of bounds exception`() {
            /// GIVEN
            val list = DoublyLinkedList(1)

            // WHEN
            Assertions.assertThatThrownBy { list.remove(1) }
                .isInstanceOf(IndexOutOfBoundsException::class.java)
                .hasMessage("Index: 1. Size: 1")
        }

        @Test
        fun `GIVEN non empty list WHEN remove item at index THEN correct value returned`() {
            // GIVEN
            val list = DoublyLinkedList<Int>()
            list.append(1)
            list.append(2)
            list.append(3)
            list.append(4)
            list.append(5)

            // WHEN
            list.remove(0)
            assertThat(list.toString()).`as`("Length = 5, Remove at index 0").isEqualTo("[2,3,4,5]")
            assertThat(list.size()).isEqualTo(4)

            list.remove(3)
            assertThat(list.toString()).`as`("Length = 4, Remove at index 3").isEqualTo("[2,3,4]")
            assertThat(list.size()).isEqualTo(3)

            list.remove(1)
            assertThat(list.toString()).`as`("Length = 3, Remove at index 1").isEqualTo("[2,4]")
            assertThat(list.size()).isEqualTo(2)

            list.remove(1)
            assertThat(list.toString()).`as`("Length = 2, Remove at index 1").isEqualTo("[2]")
            assertThat(list.size()).isEqualTo(1)

            list.remove(0)
            assertThat(list.toString()).`as`("Length = 1, Remove at index 0").isEqualTo("[]")
            assertThat(list.size()).isEqualTo(0)
        }
    }

}
