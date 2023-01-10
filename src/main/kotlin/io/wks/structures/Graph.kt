package io.wks.structures

class Graph<T>(private val adjacencyList: MutableMap<Vertex<T>, LinkedList<Vertex<T>>> = mutableMapOf()) {
    data class Vertex<T>(val value: T) {
        override fun toString() = value.toString()
    }

    fun addVertex(value: T): Boolean {
        val vertex = Vertex(value)
        if (adjacencyList.keys.contains(vertex)) {
            return false
        }
        adjacencyList[vertex] = LinkedList()
        return true
    }

    fun addEdge(pair: Pair<T, T>): Boolean {
        val firstVertex = Vertex(pair.first)
        val secondVertex = Vertex(pair.second)
        val firstList =
            requireNotNull(adjacencyList[firstVertex]) { "Graph does not contain a vertex labelled '${pair.first}'" }
        val secondList =
            requireNotNull(adjacencyList[secondVertex]) { "Graph does not contain a vertex labelled '${pair.second}'" }

        if (pair.first == pair.second) {
            return false
        }

        firstList.append(secondVertex)
        secondList.append(firstVertex)
        return true
    }

    override fun toString() = adjacencyList.toString()
}