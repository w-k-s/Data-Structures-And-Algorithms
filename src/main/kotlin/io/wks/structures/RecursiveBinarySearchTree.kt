package io.wks.structures

class RecursiveBinarySearchTree<T : Comparable<T>> {
    data class Node<T : Comparable<T>>(val value: T, var left: Node<T>? = null, var right: Node<T>? = null) {
        override fun toString() = value.toString()
    }

    private var root: Node<T>? = null

    fun insert(value: T): Boolean {
        return when (val root = root) {
            null -> {
                this.root = Node(value)
                return true
            }

            else -> insert(root, value)
        }
    }

    private fun insert(currentNode: Node<T>, value: T): Boolean {
        return if (value > currentNode.value) {
            when (val right = currentNode.right) {
                null -> {
                    currentNode.right = Node(value)
                    true
                }

                else -> insert(right, value)
            }
        } else if (value < currentNode.value) {
            when (val left = currentNode.left) {
                null -> {
                    currentNode.left = Node(value)
                    true
                }

                else -> insert(left, value)
            }
        } else return false
    }

    operator fun contains(value: T): Boolean {
        return root?.let { contains(it, value) } ?: false
    }

    private fun contains(currentNode: Node<T>?, value: T): Boolean {
        if (currentNode == null) return false
        if (currentNode.value == value) return true
        if (value > currentNode.value) return contains(currentNode.right, value)
        if (value < currentNode.value) return contains(currentNode.left, value)
        return false
    }

    fun minimum() = minimum(root)

    private fun minimum(currentNode: Node<T>?): T? {
        if (currentNode == null) return null
        return when (val left = currentNode.left) {
            null -> currentNode.value
            else -> minimum(left)
        }
    }

    override fun toString() = toString(root)

    private fun toString(node: Node<T>?): String {
        return with(mutableListOf<String>()) {
            node?.left?.let { add(toString(it)) }
            add(node?.value.toString())
            node?.right?.let { add(toString(it)) }
            this
        }.joinToString(",")
    }
}