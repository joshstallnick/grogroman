package io.violabs.grogroman.common

class BinaryTree<T>(val list: MutableList<T>, private val comparator: Comparator<T>) {
  private var root: Node<T>? = null

  init {
    list.forEachIndexed(this::add)
  }

  private fun add(i: Int, item: T) {
    if (root == null) {
      root = Node(item, i)
      return
    }

    root!!.add(item, i, comparator)
  }

  fun find(item: T): Int {
    return root?.find(item, comparator) ?: -1
  }

  private class Node<T>(
    var key: T? = null,
    var index: Int? = null,
    var left: Node<T>? = null,
    var right: Node<T>? = null
  ) {
    fun find(item: T, comparator: Comparator<T>): Int {
      if (key == item) return index ?: -1

      val compared: Int = comparator.compare(key, item)

      if (compared == 1) return left?.find(item, comparator) ?: -1

      return right?.find(item, comparator) ?: -1
    }

    fun add(item: T, index: Int, comparator: Comparator<T>) {
      if (key == null) {
        key = item
        return
      }

      val compared: Int = comparator.compare(key, item)

      if (compared == 1) {
        if (left != null) return left!!.add(item, index, comparator)

        left = Node(key = item, index = index)
        return
      }

      if (compared == -1) {
        if (right != null) return right!!.add(item, index, comparator)

        right = Node(key = item, index = index)
        return
      }
    }
  }
}