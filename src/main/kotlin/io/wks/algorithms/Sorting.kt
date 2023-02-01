package io.wks.algorithms

// https://www.programiz.com/dsa/bubble-sort
interface Sorting<T : Comparable<T>> {
    fun sort(items: MutableList<T>)
}

/**
 * Largest number bubbles to the top.
 */
class BubbleSort<T : Comparable<T>> : Sorting<T> {
    override fun sort(items: MutableList<T>) {
        if (items.size == 1 || items.size == 0) return

        for (k in 0 until items.size - 1) {
            for (i in 0 until items.size - 1) {
                val left = items[i]
                val right = items[i + 1]

                if (left > right) {
                    items[i] = right
                    items[i + 1] = left
                }
            }
        }
    }
}

/**
 * Repeatedly searches for the smallest item in the list and puts it in the correct place.
 */
class SelectionSort<T : Comparable<T>> : Sorting<T> {
    override fun sort(items: MutableList<T>) {
        if (items.isEmpty() || items.size == 1) return

        // Iterate over each item i
        for (i in 0 until items.size - 1) {
            var minIndex = i

            // Find the smallest item since the current item
            for (j in i + 1 until items.size) {
                if (items[j] < items[minIndex]) {
                    minIndex = j
                }
            }

            // Swap the current item with the next smallest item
            val temp = items[i]
            items[i] = items[minIndex]
            items[minIndex] = temp
        }
    }
}

class InsertionSort<T : Comparable<T>> : Sorting<T> {
    override fun sort(items: MutableList<T>) {
        if (items.isEmpty() || items.size == 1) return


    }
}

class MergeSort<T : Comparable<T>> : Sorting<T> {
    override fun sort(items: MutableList<T>) {
        if (items.isEmpty() || items.size == 1) return


    }
}

class QuickSort<T : Comparable<T>> : Sorting<T> {
    override fun sort(items: MutableList<T>) {
        if (items.isEmpty() || items.size == 1) return


    }
}
