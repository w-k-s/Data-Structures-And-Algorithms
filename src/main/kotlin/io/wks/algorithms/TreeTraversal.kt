package io.wks.algorithms

import io.wks.structures.BinarySearchTree
import io.wks.structures.Queue

interface TreeTraversal<T : Comparable<T>> {
    fun traverse(tree: BinarySearchTree<T>): List<T>
}

class BreadthFirstSearch<T : Comparable<T>> : TreeTraversal<T> {
    override fun traverse(tree: BinarySearchTree<T>): List<T> {
        val queue = Queue<BinarySearchTree.Node<T>>()
        val results = mutableListOf<T>()

        val root = tree.root ?: return emptyList()

        queue.enqueue(root)
        while (!queue.isEmpty) {
            val node = queue.dequeue()!!
            results.add(node.value)
            node.left?.let { queue.enqueue(it) }
            node.right?.let { queue.enqueue(it) }
        }
        return results
    }
}

class PreOrderDepthFirstSearch<T : Comparable<T>> : TreeTraversal<T> {
    override fun traverse(tree: BinarySearchTree<T>) = when (val root = tree.root) {
        null -> emptyList()
        else -> traverse(root)
    }

    private fun traverse(node: BinarySearchTree.Node<T>): List<T> {
        val results = mutableListOf<T>()
        results.add(node.value)
        node.left?.let { results.addAll(traverse(it)) }
        node.right?.let { results.addAll(traverse(it)) }
        return results
    }
}

class PostOrderDepthFirstSearch<T : Comparable<T>> : TreeTraversal<T> {
    override fun traverse(tree: BinarySearchTree<T>) = when (val root = tree.root) {
        null -> emptyList()
        else -> traverse(root)
    }

    private fun traverse(node: BinarySearchTree.Node<T>): List<T> {
        val results = mutableListOf<T>()
        node.left?.let { results.addAll(traverse(it)) }
        node.right?.let { results.addAll(traverse(it)) }
        results.add(node.value)
        return results
    }
}

class InOrderDepthFirstSearch<T : Comparable<T>> : TreeTraversal<T> {
    override fun traverse(tree: BinarySearchTree<T>) = when (val root = tree.root) {
        null -> emptyList()
        else -> traverse(root)
    }

    private fun traverse(node: BinarySearchTree.Node<T>): List<T> {
        val results = mutableListOf<T>()
        node.left?.let { results.addAll(traverse(it)) }
        results.add(node.value)
        node.right?.let { results.addAll(traverse(it)) }
        return results
    }
}