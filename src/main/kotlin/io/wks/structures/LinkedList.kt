package io.wks.structures

internal data class Node<T>(var value: T, var next: Node<T>?)

class LinkedList<T>() {

    private var head: Node<T>? = null
    private var length: Int = 0

    constructor(value: T) : this() {
        this.head = Node(value, next = null)
        this.length += 1
    }

    fun prepend(value: T) {
        this.head = Node(value = value, next = this.head)
        this.length += 1
    }

    fun append(value: T) {
        if (isEmpty) {
            this.head = Node(value = value, next = null)
            this.length += 1
            return
        }
        var current = this.head
        while (current?.next != null) {
            current = current.next
        }
        current?.next = Node(value = value, next = null)
        this.length += 1
    }

    fun pop() {
        if (length <= 1) {
            this.head = null
            this.length = 0
            return
        }
        var current = head
        while (current?.next != null) {
            current = current.next
            if (current?.next?.next == null) {
                current?.next = null
                length -= 1
                break
            }
        }
    }

    fun popFirst() {
        if (isEmpty) {
            return
        }
        this.head = this.head?.next
        this.length -= 1
    }

    operator fun get(index: Int): T {
        checkBounds(index)
        var i = 0
        var current = this.head
        while (i < index) {
            current = current?.next
            i++
        }
        return current!!.value
    }

    operator fun set(index: Int, value: T) {
        checkBounds(index)
        var i = 0
        var current = this.head
        while (i < index) {
            current = current?.next
            i++
        }
        current!!.value = value
    }

    fun insert(index: Int, value: T) {
        if (isEmpty && index != 0 || index >= length) {
            throw ArrayIndexOutOfBoundsException("Index: $index. Size: $length")
        }
        var i = 0
        var current = this.head
        while (i < index) {
            current = current?.next
            i++
        }
        current!!.next = Node(value = value, next = current.next)
        length += 1
    }

    //  index: 0
    //  i = 0
    //  1,2,3,4,5
    //  ^
    //  *


    fun remove(index: Int){
        if (isEmpty && index != 0 || index >= length) {
            throw ArrayIndexOutOfBoundsException("Index: $index. Size: $length")
        }
        if (index == 0){
            this.popFirst()
            return
        }
        var i = 0
        var previous: Node<T>? = this.head
        var current = this.head
        while (i < index) {
            previous = current
            current = current?.next
            i++
        }
        previous!!.next = current!!.next
        length -= 1
    }

    private fun checkBounds(index: Int) {
        if (isEmpty || index >= length) {
            throw ArrayIndexOutOfBoundsException("Index: $index. Size: $length")
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