package io.wks.structures

class DoublyLinkedList<T>() {

    internal data class Node<T>(
        var value: T,
        var next: Node<T>?,
        var previous: Node<T>?
    )

    private var head: Node<T>? = null
    private var length: Int = 0

    constructor(value: T) : this() {
        this.head = Node(value, next = null, previous = null)
        this.length += 1
    }

    fun append(value: T) {
        if (this.isEmpty) {
            this.head = Node(value, next = null, previous = null)
        } else {
            var previous = this.head
            var current = this.head
            while (current!!.next != null) {
                previous = current
                current = current.next
            }
            current.next = Node(value = value, next = null, previous = previous)
        }
        length += 1
    }

    fun prepend(value: T) {
        this.head = Node(value = value, next = this.head, previous = null)
        this.length += 1
    }

    fun pop(): T? {
        if (isEmpty) {
            return null
        }
        val popped: T
        if (length == 1) {
            popped = this.head!!.value
            this.head = null
        } else {
            var current = this.head
            while (current!!.next != null) {
                current = current.next
            }
            popped = current.value
            current.previous!!.next = null
        }
        length -= 1
        return popped
    }

    fun popFirst(): T? {
        if (this.isEmpty) {
            return null
        }
        val popped = this.head!!.value
        if (this.length == 1) {
            this.head = null
        } else {
            this.head = this.head!!.next
            this.head!!.previous = null
        }
        length -= 1
        return popped
    }

    operator fun get(index: Int): T {
        checkBounds(index)
        var i = 0
        var current = this.head
        while (i < index) {
            i += 1
            current = current!!.next
        }
        return current!!.value
    }

    operator fun set(index: Int, value: T) {
        checkBounds(index)
        var i = 0
        var current = this.head
        while (i < index) {
            i += 1
            current = current!!.next
        }
        current!!.value = value
    }

    fun insert(index: Int, value: T) {
        if (isEmpty) {
            this.prepend(value)
            return
        }
        if (index == length) {
            this.append(value)
            return
        }
        checkBounds(index)

        var i = 0
        var current = this.head
        while (i < index) {
            i += 1
            current = current!!.next
        }
        current!!.next = Node(value = value, previous = current, next = current.next)
        length += 1
    }

    fun remove(index: Int) {
        checkBounds(index)
        if (index == 0) {
            this.popFirst()
            return
        }

        var i = 0
        var current = this.head
        while (i < index - 1) {
            i += 1
            current = current!!.next
        }
        val newNext = current?.next?.next
        current!!.next = newNext
        newNext?.previous = current
        length -= 1
    }

    private fun checkBounds(index: Int) {
        if (index < 0 || index >= this.length) {
            throw IndexOutOfBoundsException("Index: $index. Size: ${this.length}")
        }
    }

    override fun toString(): String {
        var values = mutableListOf<T>()
        var current = head
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