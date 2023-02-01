package io.wks.algorithms

import io.wks.structures.BinarySearchTree
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class TreeTraversalTests {

    @Nested
    inner class BreadthFirst {

        @Test
        fun `GIVEN an empty tree WHEN traversed THEN empty list returned`() {
            // GIVEN
            val tree = BinarySearchTree<Int>()

            // WHEN
            val results = BreadthFirstSearch<Int>().traverse(tree)

            // THEN
            assertThat(results)
                .isEqualTo(emptyList<Int>())
        }

        @Test
        fun `GIVEN a single item tree WHEN traversed THEN singleton list returned`() {
            // GIVEN
            val tree = BinarySearchTree<Int>().apply { insert(10) }

            // WHEN
            val results = BreadthFirstSearch<Int>().traverse(tree)

            // THEN
            assertThat(results)
                .containsExactly(10)
        }

        @Test
        fun `GIVEN a tree WHEN traversed THEN list returned with items in the correct order`() {
            // GIVEN
            val tree = BinarySearchTree<Int>().apply {
                insert(47)
                insert(21)
                insert(76)
                insert(18)
                insert(27)
                insert(52)
            }

            // WHEN
            val results = BreadthFirstSearch<Int>().traverse(tree)

            // THEN
            assertThat(results)
                .containsExactly(47, 21, 76, 18, 27, 52)
        }
    }

    @Nested
    inner class DepthFirst {

        @Nested
        inner class PreOrder {
            @Test
            fun `GIVEN an empty tree WHEN traversed THEN empty list returned`() {
                // GIVEN
                val tree = BinarySearchTree<Int>()

                // WHEN
                val results = PreOrderDepthFirstSearch<Int>().traverse(tree)

                // THEN
                assertThat(results)
                    .isEqualTo(emptyList<Int>())
            }

            @Test
            fun `GIVEN a single item tree WHEN traversed THEN singleton list returned`() {
                // GIVEN
                val tree = BinarySearchTree<Int>().apply { insert(10) }

                // WHEN
                val results = PreOrderDepthFirstSearch<Int>().traverse(tree)

                // THEN
                assertThat(results)
                    .containsExactly(10)
            }

            @Test
            fun `GIVEN a tree WHEN traversed THEN list returned with items in the correct order`() {
                // GIVEN
                val tree = BinarySearchTree<Int>().apply {
                    insert(47)
                    insert(21)
                    insert(76)
                    insert(18)
                    insert(27)
                    insert(52)
                }

                // WHEN
                val results = PreOrderDepthFirstSearch<Int>().traverse(tree)

                // THEN
                assertThat(results)
                    .containsExactly(47, 21, 18, 27, 76, 52)
            }
        }

        @Nested
        inner class PostOrder {
            @Test
            fun `GIVEN an empty tree WHEN traversed THEN empty list returned`() {
                // GIVEN
                val tree = BinarySearchTree<Int>()

                // WHEN
                val results = PostOrderDepthFirstSearch<Int>().traverse(tree)

                // THEN
                assertThat(results)
                    .isEqualTo(emptyList<Int>())
            }

            @Test
            fun `GIVEN a single item tree WHEN traversed THEN singleton list returned`() {
                // GIVEN
                val tree = BinarySearchTree<Int>().apply { insert(10) }

                // WHEN
                val results = PostOrderDepthFirstSearch<Int>().traverse(tree)

                // THEN
                assertThat(results)
                    .containsExactly(10)
            }

            @Test
            fun `GIVEN a tree WHEN traversed THEN list returned with items in the correct order`() {
                // GIVEN
                val tree = BinarySearchTree<Int>().apply {
                    insert(47)
                    insert(21)
                    insert(76)
                    insert(18)
                    insert(27)
                    insert(52)
                    insert(82)
                }

                // WHEN
                val results = PostOrderDepthFirstSearch<Int>().traverse(tree)

                // THEN
                assertThat(results)
                    .containsExactly(18, 27, 21, 52, 82, 76, 47)
            }
        }

        @Nested
        inner class InOrder {
            @Test
            fun `GIVEN an empty tree WHEN traversed THEN empty list returned`() {
                // GIVEN
                val tree = BinarySearchTree<Int>()

                // WHEN
                val results = InOrderDepthFirstSearch<Int>().traverse(tree)

                // THEN
                assertThat(results)
                    .isEqualTo(emptyList<Int>())
            }

            @Test
            fun `GIVEN a single item tree WHEN traversed THEN singleton list returned`() {
                // GIVEN
                val tree = BinarySearchTree<Int>().apply { insert(10) }

                // WHEN
                val results = InOrderDepthFirstSearch<Int>().traverse(tree)

                // THEN
                assertThat(results)
                    .containsExactly(10)
            }

            @Test
            fun `GIVEN a tree WHEN traversed THEN list returned with items in the correct order`() {
                // GIVEN
                val tree = BinarySearchTree<Int>().apply {
                    insert(47)
                    insert(21)
                    insert(76)
                    insert(18)
                    insert(27)
                    insert(52)
                    insert(82)
                }

                // WHEN
                val results = InOrderDepthFirstSearch<Int>().traverse(tree)

                // THEN
                assertThat(results)
                    .containsExactly(18, 21, 27, 47, 52, 76, 82)
            }
        }
    }
}