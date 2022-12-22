package io.wks.structures

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LinkedListTest {

    @Nested
    inner class Prepend {
        @Test
        fun `GIVEN empty list WHEN item prepended THEN length of list is 1`() {
            // GIVEN
            val list = LinkedList<Int>()

            // WHEN
            list.prepend(1)

            // THEN
            assertThat(list.size()).isEqualTo(1)
            assertThat(list.toString()).isEqualTo("[1]")
        }

        @Test
        fun `GIVEN list with 1 item WHEN item prepended THEN length of list is 2`() {
            // GIVEN
            val list = LinkedList<Int>(2)

            // WHEN
            list.prepend(1)

            // THEN
            assertThat(list.size()).isEqualTo(2)
            assertThat(list.toString()).isEqualTo("[1,2]")
        }
    }

    @Nested
    inner class Append {
        @Test
        fun `GIVEN empty list WHEN item appended THEN length of list is 1`() {
            // GIVEN
            val list = LinkedList<Int>()

            // WHEN
            list.append(1)

            // THEN
            assertThat(list.size()).isEqualTo(1)
            assertThat(list.toString()).isEqualTo("[1]")
        }

        @Test
        fun `GIVEN list with 1 item WHEN item prepended THEN length of list is 2`() {
            // GIVEN
            val list = LinkedList(1)

            // WHEN
            list.append(2)

            // THEN
            assertThat(list.size()).isEqualTo(2)
            assertThat(list.toString()).isEqualTo("[1,2]")
        }
    }

    @Nested
    inner class Pop {
        @Test
        fun `GIVEN empty list WHEN popped THEN length of list is 0`() {
            // GIVEN
            val list = LinkedList<Int>()

            // WHEN
            list.pop()

            // THEN
            assertThat(list.size()).isEqualTo(0)
            assertThat(list.toString()).isEqualTo("[]")
        }

        @Test
        fun `GIVEN list with 1 item WHEN popped THEN length of list is 0`() {
            // GIVEN
            val list = LinkedList<Int>()

            // WHEN
            list.prepend(3)
            list.pop()

            // THEN
            assertThat(list.size()).isEqualTo(0)
            assertThat(list.toString()).isEqualTo("[]")
        }

        @Test
        fun `GIVEN list with 3 items WHEN popped THEN last item removed`() {
            // GIVEN
            val list = LinkedList<Int>()

            // WHEN
            list.prepend(3)
            list.prepend(2)
            list.prepend(1)
            list.pop()

            // THEN
            assertThat(list.size()).isEqualTo(2)
            assertThat(list.toString()).isEqualTo("[1,2]")
        }
    }

    @Nested
    inner class PopFirst {
        @Test
        fun `GIVEN empty list WHEN popped from beginning THEN length of list is 0`() {
            // GIVEN
            val list = LinkedList<Int>()

            // WHEN
            list.popFirst()

            // THEN
            assertThat(list.size()).isEqualTo(0)
            assertThat(list.toString()).isEqualTo("[]")
        }

        @Test
        fun `GIVEN list with 1 item WHEN popped from beginning THEN length of list is 0`() {
            // GIVEN
            val list = LinkedList<Int>()

            // WHEN
            list.append(3)
            list.popFirst()

            // THEN
            assertThat(list.size()).isEqualTo(0)
            assertThat(list.toString()).isEqualTo("[]")
        }

        @Test
        fun `GIVEN list with 3 items WHEN popped from beginning THEN first item removed`() {
            // GIVEN
            val list = LinkedList<Int>()

            // WHEN
            list.append(1)
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
            val list = LinkedList<Int>()

            // WHEN
            assertThatThrownBy { list[0] }
                .isInstanceOf(ArrayIndexOutOfBoundsException::class.java)
                .hasMessage("Index: 0. Size: 0")
        }

        @Test
        fun `GIVEN list with 1 item WHEN get at index 1 THEN array index out of bounds exception`() {
            /// GIVEN
            val list = LinkedList(1)

            // WHEN
            assertThatThrownBy { list[1] }
                .isInstanceOf(ArrayIndexOutOfBoundsException::class.java)
                .hasMessage("Index: 1. Size: 1")
        }

        @Test
        fun `GIVEN non empty list WHEN get item at index THEN correct value returned`() {
            // GIVEN
            val list = LinkedList<Int>()

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
            val list = LinkedList<Int>()

            // WHEN
            assertThatThrownBy { list[0] = 1 }
                .isInstanceOf(ArrayIndexOutOfBoundsException::class.java)
                .hasMessage("Index: 0. Size: 0")
        }

        @Test
        fun `GIVEN list with 1 item WHEN set at index 1 THEN array index out of bounds exception`() {
            /// GIVEN
            val list = LinkedList(1)

            // WHEN
            assertThatThrownBy { list[1] = 2 }
                .isInstanceOf(ArrayIndexOutOfBoundsException::class.java)
                .hasMessage("Index: 1. Size: 1")
        }

        @Test
        fun `GIVEN non empty list WHEN set item at index THEN correct value returned`() {
            // GIVEN
            val list = LinkedList<Int>()
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
        fun `GIVEN empty list WHEN insert at index 0 THEN array index out of bounds exception`() {
            // GIVEN
            val list = LinkedList<Int>()

            // WHEN
            assertThatThrownBy { list.insert(0, 1) }
                .isInstanceOf(ArrayIndexOutOfBoundsException::class.java)
                .hasMessage("Index: 0. Size: 0")
        }

        @Test
        fun `GIVEN list with 1 item WHEN insert at index 1 THEN array index out of bounds exception`() {
            /// GIVEN
            val list = LinkedList(1)

            // WHEN
            assertThatThrownBy { list.insert(1, 2) }
                .isInstanceOf(ArrayIndexOutOfBoundsException::class.java)
                .hasMessage("Index: 1. Size: 1")
        }

        @Test
        fun `GIVEN non empty list WHEN set item at index THEN correct value returned`() {
            // GIVEN
            val list = LinkedList<Int>()
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
            val list = LinkedList<Int>()

            // WHEN
            assertThatThrownBy { list.remove(0) }
                .isInstanceOf(ArrayIndexOutOfBoundsException::class.java)
                .hasMessage("Index: 0. Size: 0")
        }

        @Test
        fun `GIVEN list with 1 item WHEN remove at index 1 THEN array index out of bounds exception`() {
            /// GIVEN
            val list = LinkedList(1)

            // WHEN
            assertThatThrownBy { list.remove(1) }
                .isInstanceOf(ArrayIndexOutOfBoundsException::class.java)
                .hasMessage("Index: 1. Size: 1")
        }

        @Test
        fun `GIVEN non empty list WHEN remove item at index THEN correct value returned`() {
            // GIVEN
            val list = LinkedList<Int>()
            list.append(1)
            list.append(2)
            list.append(3)
            list.append(4)
            list.append(5)

            // WHEN
            list.remove(0)
            assertThat(list.toString()).isEqualTo("[2,3,4,5]")
            assertThat(list.size()).isEqualTo(4)

            list.remove(3)
            assertThat(list.toString()).isEqualTo("[2,3,4]")
            assertThat(list.size()).isEqualTo(3)

            list.remove(1)
            assertThat(list.toString()).isEqualTo("[2,4]")
            assertThat(list.size()).isEqualTo(2)

            list.remove(1)
            assertThat(list.toString()).isEqualTo("[2]")
            assertThat(list.size()).isEqualTo(1)

            list.remove(0)
            assertThat(list.toString()).isEqualTo("[]")
            assertThat(list.size()).isEqualTo(0)
        }
    }


}