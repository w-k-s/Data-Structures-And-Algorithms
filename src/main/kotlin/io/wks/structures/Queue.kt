package io.wks.structures

class Queue<T>() {
    private data class Node<T>(val value: T, var next: Node<T>?)

    private var front: Node<T>? = null
    private var rear: Node<T>? = null
    private var length: Int = 0

    constructor(value: T) : this() {
        enqueue(value)
    }

    fun enqueue(value: T) {
        val newNode = Node(value = value, next = null)
        if (this.isEmpty) {
            this.front = newNode
            this.rear = this.front
        } else {
            this.rear!!.next = newNode
            this.rear = newNode
        }
        this.length += 1
    }

    fun dequeue(): T? {
        if (isEmpty) {
            return null
        }
        val temp = this.front
        this.front = temp!!.next
        val popped = temp.value
        temp.next = null
        length -= 1
        return popped
    }

    override fun toString(): String {
        var values = mutableListOf<T>()
        var current = front
        if (current != null) {
            values.add(current.value)
        }
        while (current?.next != null) {
            current = current.next
            current?.value?.let { values.add(it) }
        }
        return "[${values.joinToString(",")}]"
    }

    val isEmpty: Boolean get() = this.length == 0
    fun size() = length
}