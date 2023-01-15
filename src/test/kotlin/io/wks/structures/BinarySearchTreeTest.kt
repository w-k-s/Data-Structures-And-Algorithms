package io.wks.structures

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.random.Random.Default.nextInt

internal class BinarySearchTreeTest {

    @Nested
    inner class Insert {

        @Test
        fun `GIVEN a tree WHEN insert value THEN value is inserted`() {
            val tree = BinarySearchTree<Int>()

            assertThat(tree.insert(1)).isTrue

            assertThat(tree.toString()).isEqualTo("1")
        }

        @Test
        fun `GIVEN a tree WHEN insert value smaller than root THEN inserted on left`() {
            val tree = BinarySearchTree<Int>()

            assertThat(tree.insert(3)).isTrue
            assertThat(tree.insert(2)).isTrue

            assertThat(tree.toString()).isEqualTo("2,3")
        }

        @Test
        fun `GIVEN a tree WHEN insert value greater than root THEN inserted on right`() {
            val tree = BinarySearchTree<Int>()

            assertThat(tree.insert(3)).isTrue
            assertThat(tree.insert(5)).isTrue

            assertThat(tree.toString()).isEqualTo("3,5")
        }

        @Test
        fun `GIVEN a tree WHEN value inserted THEN inserted in right place`() {
            val tree = BinarySearchTree<Int>()

            assertThat(tree.insert(5)).isTrue
            assertThat(tree.insert(1)).isTrue
            assertThat(tree.insert(4)).isTrue
            assertThat(tree.insert(3)).isTrue
            assertThat(tree.insert(10)).isTrue

            assertThat(tree.toString()).isEqualTo("1,3,4,5,10")
        }
    }

    @Nested
    inner class Contains {

        @Test
        fun `GIVEN a tree WHEN empty THEN contains returns false`() {
            val tree = BinarySearchTree<Int>()

            assertThat(tree.contains(nextInt())).isFalse
        }

        @Test
        fun `GIVEN a tree containing a value WHEN checking if tree contains the value  THEN returns true`() {
            val tree = BinarySearchTree<Int>()

            val min = 1
            val max = 3
            for (i in min..max) {
                tree.insert(i)
            }

            val random = nextInt(from = min, until = max)
            assertThat(tree.contains(random)).`as`("contains $random").isTrue
        }

        @Test
        fun `GIVEN a tree not containing a value WHEN checking if tree contains the value  THEN returns false`() {
            val tree = BinarySearchTree<Int>()

            val min = 1
            val max = 100
            for (i in min..max) {
                tree.insert(i)
            }

            assertThat(tree.contains(nextInt(from = max, until = Integer.MAX_VALUE))).isFalse
        }

    }
}