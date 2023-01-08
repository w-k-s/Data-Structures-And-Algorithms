package io.wks.structures

class BinarySearchTree<T : Comparable<T>> {
    data class Node<T : Comparable<T>>(val value: T, var left: Node<T>? = null, var right: Node<T>? = null) {

        fun contains(value: T): Boolean {
            return value == this.value
                    || (left?.contains(value) ?: false)
                    || (right?.contains(value) ?: false)
        }

        override fun toString(): String {
            return with(mutableListOf<String>()) {
                left?.let { add(it.toString()) }
                add(value.toString())
                right?.let { add(it.toString()) }
                this
            }.joinToString(",")
        }
    }

    private var root: Node<T>? = null

    fun insert(value: T): Boolean {
        if (root == null) {
            this.root = Node(value = value)
            return true
        }

        var current = root!!
        while (true) {
            val currentValue = current.value
            if (value == currentValue) {
                return false
            } else if (value > currentValue) {
                when (val right = current.right) {
                    null -> {
                        current.right = Node(value = value)
                        return true
                    }

                    else -> current = right
                }
            } else {
                when (val left = current.left) {
                    null -> {
                        current.left = Node(value = value)
                        return true
                    }

                    else -> current = left
                }
            }
        }
    }

    operator fun contains(value: T) = root?.contains(value) ?: false

    // Non-recursive implementation of contains
    fun containsNonRecursive(value: T): Boolean {
        var current = this.root
        while (current != null) {
            if (current.value == value) {
                return true
            } else if (current.value > value) {
                current = current.left
            } else {
                current = current.right
            }
        }
        return false
    }

    override fun toString() = stringify(root)

    private fun stringify(node: Node<T>?): String {
        return with(mutableListOf<String>()) {
            node?.left?.let { add(stringify(it)) }
            add(node?.value.toString())
            node?.right?.let { add(stringify(it)) }
            this
        }.joinToString(",")
    }
}