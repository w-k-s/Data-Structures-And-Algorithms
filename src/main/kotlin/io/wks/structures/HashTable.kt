package io.wks.structures

/**
 * It is recommended to use a prime number as the initial size of a hash table.
 * Due to the way hash functions work, using a prime number improves the randomness of how the key-value pairs are distributed
 * in a hashtable.
 */
class HashTable<V>(size: Int = 7) {

    data class Entry<V>(val key: String, val value: V) {
        override fun toString(): String {
            return "$key: '$value'"
        }
    }

    private val buckets = Array<LinkedList<Entry<V>>?>(size) { null }

    fun keys(): List<String> {
        return buckets
            .filterNotNull()
            .map { slots ->
                mutableListOf<String>().apply {
                    for (i in 0 until slots.size()) {
                        add(slots[i].key)
                    }
                }
            }.flatten()
            .sorted()
    }

    private fun hash(key: String): Int {
        var hashCode = 0
        for (letter in key) {
            hashCode = (hashCode + (23 * letter.code)) % buckets.size
        }
        return hashCode
    }

    operator fun set(key: String, value: V) {
        val index = hash(key)
        if (buckets[index] == null) {
            buckets[index] = LinkedList()
        }
        buckets[index]?.append(Entry(key, value))
    }

    operator fun get(key: String): V? {
        val index = hash(key)
        val slots = buckets[index] ?: return null
        for (i in 0..slots.size()) {
            val entry = slots[i]
            if (entry.key == key)
                return entry.value
        }
        return null
    }

    override fun toString(): String {
        return buckets
            .filterNotNull()
            .map { entries -> entries.toString() }
            .sorted()
            .joinToString()
    }
}