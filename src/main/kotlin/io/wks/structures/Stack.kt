package io.wks.structures

class Stack<T>() {
    private data class Node<T>(var value: T, var next: Node<T>?)

    private var top: Node<T>? = null
    private var height: Int = 0

    constructor(value: T) : this() {
        this.push(value)
    }

    fun push(value: T) {
        this.top = Node(value = value, next = this.top)
        this.height += 1
    }

    fun pop(): T? {
        if (this.isEmpty) {
            return null
        }
        val current = this.top
        this.top = current!!.next
        current.next = null
        this.height -= 1
        return current.value
    }

    override fun toString(): String {
        var values = mutableListOf<T>()
        var current = top
        if (current != null) {
            values.add(current.value)
        }
        while (current?.next != null) {
            current = current.next
            current?.value?.let { values.add(it) }
        }
        return "[${values.joinToString(",")}]"
    }

    val isEmpty: Boolean get() = this.height == 0
    fun size() = height
}