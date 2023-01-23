package io.wks.structures

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.random.Random.Default.nextInt

internal class RecursiveBinarySearchTreeTest {

    @Nested
    inner class Insert {

        @Test
        fun `GIVEN a tree WHEN insert value THEN value is inserted`() {
            val tree = RecursiveBinarySearchTree<Int>()

            assertThat(tree.insert(1)).isTrue

            assertThat(tree.toString()).isEqualTo("1")
            assertThat(tree.minimum()).isEqualTo(1)
        }

        @Test
        fun `GIVEN a tree WHEN insert value smaller than root THEN inserted on left`() {
            val tree = RecursiveBinarySearchTree<Int>()

            assertThat(tree.insert(3)).isTrue
            assertThat(tree.insert(2)).isTrue

            assertThat(tree.toString()).isEqualTo("2,3")
            assertThat(tree.minimum()).isEqualTo(2)
        }

        @Test
        fun `GIVEN a tree WHEN insert value greater than root THEN inserted on right`() {
            val tree = RecursiveBinarySearchTree<Int>()

            assertThat(tree.insert(3)).isTrue
            assertThat(tree.insert(5)).isTrue

            assertThat(tree.toString()).isEqualTo("3,5")
            assertThat(tree.minimum()).isEqualTo(3)
        }

        @Test
        fun `GIVEN a tree WHEN value inserted THEN inserted in right place`() {
            val tree = RecursiveBinarySearchTree<Int>()

            assertThat(tree.insert(5)).isTrue
            assertThat(tree.insert(1)).isTrue
            assertThat(tree.insert(4)).isTrue
            assertThat(tree.insert(3)).isTrue
            assertThat(tree.insert(10)).isTrue

            assertThat(tree.toString()).isEqualTo("1,3,4,5,10")
            assertThat(tree.minimum()).isEqualTo(1)
        }
    }

    @Nested
    inner class Contains {

        @Test
        fun `GIVEN a tree WHEN empty THEN contains returns false`() {
            val tree = RecursiveBinarySearchTree<Int>()

            assertThat(nextInt() in tree).isFalse
        }

        @Test
        fun `GIVEN a tree containing a value WHEN checking if tree contains the value  THEN returns true`() {
            val tree = RecursiveBinarySearchTree<Int>()

            val min = 1
            val max = 3
            for (i in min..max) {
                tree.insert(i)
            }

            val random = nextInt(from = min, until = max)
            assertThat(random in tree).`as`("contains $random").isTrue
        }

        @Test
        fun `GIVEN a tree not containing a value WHEN checking if tree contains the value  THEN returns false`() {
            val tree = RecursiveBinarySearchTree<Int>()

            val min = 1
            val max = 100
            for (i in min..max) {
                tree.insert(i)
            }

            assertThat(nextInt(from = max, until = Integer.MAX_VALUE) in tree).isFalse
        }

    }
}