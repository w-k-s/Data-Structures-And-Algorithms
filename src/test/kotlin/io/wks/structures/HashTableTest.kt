package io.wks.structures

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class HashTableTest {

    @Nested
    inner class Create {
        @Test
        fun `GIVEN a hash table WHEN created THEN empty`() {
            // GIVEN
            val hashTable = HashTable<Int>()

            // THEN
            Assertions.assertThat(hashTable.toString()).isEqualTo("")
        }
    }

    @Nested
    inner class Set {
        @Test
        fun `GIVEN a hash table WHEN inserting a key value pair with no collision THEN single entry returned`() {
            // GIVEN
            val hashTable = HashTable<Int>()

            // WHEN
            hashTable["Sandwich"] = 100
            hashTable["Water"] = 0

            // THEN
            Assertions.assertThat(hashTable.toString()).isEqualTo("[Sandwich: '100'], [Water: '0']")
        }

        @Test
        fun `GIVEN a hash table WHEN inserting a key value pair with collision THEN multiple entries returned`() {
            // GIVEN
            val hashTable = HashTable<Int>()

            // WHEN
            hashTable["bolts"] = 100
            hashTable["washers"] = 0

            // THEN
            Assertions.assertThat(hashTable.toString()).isEqualTo("[bolts: '100',washers: '0']")
        }
    }

    @Nested
    inner class Get {
        @Test
        fun `GIVEN a hash table with no collisions WHEN lookup using key THEN value found`() {
            // GIVEN
            val hashTable = HashTable<Int>()

            // WHEN
            hashTable["Sandwich"] = 100
            hashTable["Water"] = 0

            // THEN
            Assertions.assertThat(hashTable["Sandwich"]).isEqualTo(100)
        }

        @Test
        fun `GIVEN a hash table with collisions WHEN lookup using key THEN value found`() {
            // GIVEN
            val hashTable = HashTable<Int>()

            // WHEN
            hashTable["bolts"] = 100
            hashTable["washers"] = 0

            // THEN
            Assertions.assertThat(hashTable["washers"]).isZero
        }

        @Test
        fun `GIVEN an empty hash table WHEN lookup  THEN returns null`() {
            // GIVEN
            val hashTable = HashTable<Int>()

            // THEN
            Assertions.assertThat(hashTable["washers"]).isNull()
        }

        @Test
        fun `GIVEN a hash table WHEN lookup by key for missing value THEN returns null`() {
            // GIVEN
            val hashTable = HashTable<Int>()

            // WHEN
            hashTable["Sandwich"] = 100
            hashTable["Water"] = 0

            // THEN
            Assertions.assertThat(hashTable["washers"]).isNull()
        }
    }

    @Nested
    inner class Keys {
        @Test
        fun `GIVEN empty hashtable WHEN listing keys THEN list is empty`() {
            // GIVEN
            val hashTable = HashTable<Int>()

            // THEN
            Assertions.assertThat(hashTable.keys()).isEmpty()
        }

        @Test
        fun `GIVEN a hash table with no collisions WHEN listing keys THEN all keys listed`() {
            // GIVEN
            val hashTable = HashTable<Int>()

            // WHEN
            hashTable["Sandwich"] = 100
            hashTable["Water"] = 0

            // THEN
            Assertions.assertThat(hashTable.keys()).isEqualTo(listOf("Sandwich", "Water"))
        }

        @Test
        fun `GIVEN a hash table with collisions WHEN listing keys THEN all keys listed`() {
            // GIVEN
            val hashTable = HashTable<Int>()

            // WHEN
            hashTable["bolts"] = 100
            hashTable["washers"] = 0

            // THEN
            Assertions.assertThat(hashTable.keys()).isEqualTo(listOf("bolts", "washers"))
        }
    }
}