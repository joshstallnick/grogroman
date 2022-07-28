package io.violabs.grogroman.common

data class BinaryTree<T>(val list: MutableList<T>, var root: Node<T>? = null, private val comparator: Comparator<T>) {


  init {
    list.forEachIndexed(this::add)
  }

  fun add(i: Int, item: T) {
    if (root == null) {
      root = Node(item, i)
      return
    }

    val details = Node.Details(1, item, i, comparator)

    root!!.add(details)
  }

  fun find(item: T): Int {
    return root?.find(item, comparator) ?: -1
  }

  fun print() {
    root?.print()
  }

  data class Node<T>(
    var key: T? = null,
    var index: Int? = null,
    var level: Int = 0,
    var left: Node<T>? = null,
    var right: Node<T>? = null
  ) {

    constructor(details: Details<T>) : this(
      key = details.item,
      index = details.index,
      level = details.level
    )

    fun find(item: T, comparator: Comparator<T>): Int {
      if (key == item) return index ?: -1

      val compared: Int = comparator.compare(key, item)

      if (compared == 1) return left?.find(item, comparator) ?: -1

      return right?.find(item, comparator) ?: -1
    }

    fun add(details: Details<T>) {
      when (details.comparator.compare(key, details.item)) {
        1  -> addLeft(details)
        -1 -> addRight(details)
      }
    }

    private fun addLeft(details: Details<T>) {
      val copy: Details<T> = details.copyWithNextLevel()

      if (left != null) return left!!.add(copy)

      left = Node(details)
    }

    private fun addRight(details: Details<T>) {
      val copy: Details<T> = details.copyWithNextLevel()

      if (right != null) return right!!.add(copy)

      right = Node(details)
    }

    fun print() {
      left?.print()

      right?.print()

      println("level: $level, index: $index, value: $key")
    }

    data class Details<T>(val level: Int, val item: T, val index: Int, val comparator: Comparator<T>) {
      fun copyWithNextLevel(): Details<T> = this.copy(level = level + 1)
    }
  }
}