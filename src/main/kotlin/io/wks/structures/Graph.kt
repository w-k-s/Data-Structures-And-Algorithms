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
        val firstList = adjacencyListOrThrow(firstVertex)
        val secondList = adjacencyListOrThrow(secondVertex)

        if (pair.first == pair.second) {
            return false
        }

        firstList.append(secondVertex)
        secondList.append(firstVertex)
        return true
    }

    fun removeEdge(pair: Pair<T, T>): Boolean {
        val firstVertex = Vertex(pair.first)
        val secondVertex = Vertex(pair.second)
        val firstList = adjacencyListOrThrow(firstVertex)
        val secondList = adjacencyListOrThrow(secondVertex)

        if (pair.first == pair.second) {
            return false
        }

        return firstList.remove(secondVertex) && secondList.remove(firstVertex)
    }

    fun removeVertex(value: T) {
        val vertex = Vertex(value)
        adjacencyList.remove(vertex)
        adjacencyList.forEach {
            it.value.remove(vertex)
        }
    }

    private fun adjacencyListOrThrow(value: Vertex<T>): LinkedList<Vertex<T>> {
        return requireNotNull(adjacencyList[value]) { "Graph does not contain a vertex labelled '${value}'" }
    }

    override fun toString() = adjacencyList.toString()

    private fun <T> LinkedList<T>.remove(value: T): Boolean {
        if (this.isEmpty) return false
        var index: Int? = null
        for (i in 0..this.size()) {
            if (this[i] == value) {
                index = i
                break
            }
        }
        if (index != null) {
            this.remove(index)
            return true
        }
        return false
    }
}