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

    root!!.add(1, item, i, comparator)
  }

  fun find(item: T): Int {
    return root?.find(item, comparator) ?: -1
  }

  fun print() {
    root?.print()
  }

  private class Node<T>(
    var key: T? = null,
    var index: Int? = null,
    var level: Int = 0,
    var left: Node<T>? = null,
    var right: Node<T>? = null
  ) {
    fun find(item: T, comparator: Comparator<T>): Int {
      if (key == item) return index ?: -1

      val compared: Int = comparator.compare(key, item)

      if (compared == 1) return left?.find(item, comparator) ?: -1

      return right?.find(item, comparator) ?: -1
    }

    fun add(level: Int, item: T, index: Int, comparator: Comparator<T>) {
      if (key == null) {
        key = item
        this.index = index
        this.level = level
        return
      }

      val nextLevel = level + 1

      val compared: Int = comparator.compare(key, item)

      if (compared == 1) {
        if (left != null) return left!!.add(nextLevel, item, index, comparator)

        left = Node(key = item, index = index, level = nextLevel)
        return
      }

      if (compared == -1) {
        if (right != null) return right!!.add(nextLevel, item, index, comparator)

        right = Node(key = item, index = index, level = nextLevel)
        return
      }
    }

    fun print() {
      left?.print()

      right?.print()

      println("level: $level, index: $index, value: $key")
    }
  }
}