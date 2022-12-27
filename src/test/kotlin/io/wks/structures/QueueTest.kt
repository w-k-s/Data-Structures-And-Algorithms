package io.wks.structures

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class QueueTest {

    @Nested
    inner class Create {
        @Test
        fun `GIVEN a queue WHEN created THEN length of queue is 0`() {
            val queue = Queue<Int>()

            // THEN
            Assertions.assertThat(queue.size()).isEqualTo(0)
            Assertions.assertThat(queue.toString()).isEqualTo("[]")
        }

        @Test
        fun `GIVEN a queue WHEN created with a node THEN length of queue is 1`() {
            val queue = Queue(1)

            // THEN
            Assertions.assertThat(queue.size()).isEqualTo(1)
            Assertions.assertThat(queue.toString()).isEqualTo("[1]")
        }
    }

    @Nested
    inner class Enqueue {

        @Test
        fun `GIVEN empty queue WHEN 3 items pushed THEN length = 3`() {
            // GIVEN
            val queue = Queue<Int>()

            // WHEN
            queue.enqueue(1)
            queue.enqueue(2)
            queue.enqueue(3)

            // THEN
            Assertions.assertThat(queue.size()).isEqualTo(3)
            Assertions.assertThat(queue.toString()).isEqualTo("[1,2,3]")
        }
    }

    @Nested
    inner class Dequeue {

        @Test
        fun `GIVEN empty queue WHEN popped THEN returns null`() {
            // GIVEN
            val queue = Queue<Int>()

            // WHEN
            val popped = queue.dequeue()

            // THEN
            Assertions.assertThat(popped).isNull()
            Assertions.assertThat(queue.size()).isEqualTo(0)
            Assertions.assertThat(queue.toString()).isEqualTo("[]")
        }

        @Test
        fun `GIVEN non-empty stack WHEN popped THEN last item added is pooped`() {
            // GIVEN
            val queue = Queue(1)

            // WHEN
            queue.enqueue(2)
            queue.enqueue(3)
            queue.enqueue(4)
            queue.enqueue(5)

            // THEN
            Assertions.assertThat(queue.dequeue()).isEqualTo(1)
            Assertions.assertThat(queue.size()).isEqualTo(4)
            Assertions.assertThat(queue.toString()).isEqualTo("[2,3,4,5]")

            Assertions.assertThat(queue.dequeue()).isEqualTo(2)
            Assertions.assertThat(queue.size()).isEqualTo(3)
            Assertions.assertThat(queue.toString()).isEqualTo("[3,4,5]")

            Assertions.assertThat(queue.dequeue()).isEqualTo(3)
            Assertions.assertThat(queue.size()).isEqualTo(2)
            Assertions.assertThat(queue.toString()).isEqualTo("[4,5]")

            Assertions.assertThat(queue.dequeue()).isEqualTo(4)
            Assertions.assertThat(queue.size()).isEqualTo(1)
            Assertions.assertThat(queue.toString()).isEqualTo("[5]")

            Assertions.assertThat(queue.dequeue()).isEqualTo(5)
            Assertions.assertThat(queue.size()).isEqualTo(0)
            Assertions.assertThat(queue.toString()).isEqualTo("[]")

            Assertions.assertThat(queue.isEmpty).isTrue
        }
    }
}