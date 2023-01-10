package io.wks.structures

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class GraphTest {

    @Nested
    inner class Creation {
        @Test
        fun `GIVEN graph WHEN created THEN empty`() {
            assertThat(Graph<Int>().toString()).isEqualTo("{}")
        }
    }

    @Nested
    inner class AddVertex {
        @Test
        fun `GIVEN empty graph WHEN vertex is added THEN returns true`() {
            val graph = Graph<Int>()

            assertThat(graph.addVertex(5)).isTrue
            assertThat(graph.toString()).isEqualTo("{5=[]}")
        }
    }

    @Nested
    inner class AddEdge {
        @Test
        fun `GIVEN graph with vertices WHEN edge is added THEN returns true`() {
            val graph = Graph<Int>()

            assertThat(graph.addVertex(1)).isTrue
            assertThat(graph.addVertex(2)).isTrue
            assertThat(graph.addEdge(1 to 2)).isTrue
            assertThat(graph.toString()).isEqualTo("{1=[2], 2=[1]}")
        }

        @Test
        fun `GIVEN empty graph WHEN edge is added THEN throws IllegalArgumentException`() {
            val graph = Graph<Int>()

            assertThatThrownBy {
                graph.addEdge(1 to 2)
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Graph does not contain a vertex labelled '1'")
        }

        @Test
        fun `GIVEN graph with vertices WHEN edge is added between an existent and non-existent vertices THEN throws IllegalArgumentException`() {
            val graph = Graph<Int>()

            graph.addVertex(1)

            assertThatThrownBy {
                graph.addEdge(1 to 2)
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Graph does not contain a vertex labelled '2'")
        }

        @Test
        fun `GIVEN graph with vertices WHEN edge is added between the same vertex THEN returns false`() {
            val graph = Graph<Int>()

            graph.addVertex(1)

            assertThat(graph.addEdge(1 to 1)).isFalse
        }
    }
}