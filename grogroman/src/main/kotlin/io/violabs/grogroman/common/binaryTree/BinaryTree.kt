package io.violabs.grogroman.common.binaryTree

open class BinaryTree<T>(initialList: MutableList<T>, var root: Node<T>? = null, val comparator: Comparator<T>) {
  var size: Int = 0

  init {
    initialList.forEachIndexed(::add)
  }

  fun add(item: T) = add(size, item)

  fun print() {
    root?.print()
  }

  fun height(): Int = root?.height()?.plus(1) ?: 0

  fun leftHeight(): Int = root?.left?.height()?.plus(1) ?: 0
  fun rightHeight(): Int = root?.right?.height()?.plus(1) ?: 0

  fun diameter(): Int = leftHeight() + rightHeight() - 1

  private fun add(i: Int, item: T) {
    if (root == null) {
      root = Node(item, i)
      size++
      return
    }

    val details = Node.Details(1, item, i, comparator)

    root!!.add(details)

    size++
  }

  private fun calculateSize() { this.size = root?.calculateSize() ?: 0 }

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

    fun calculateSize(): Int {
      val leftSize = left?.calculateSize() ?: 0
      val rightSize = right?.calculateSize() ?: 0
      val thisSize = 1

      return leftSize + rightSize + thisSize
    }

    fun height(): Int {
      val leftLowest = left?.height() ?: level
      val rightLowest = right?.height() ?: level

      if (level >= leftLowest && level >= rightLowest) return level

      if (leftLowest > rightLowest) return leftLowest

      return rightLowest
    }

    data class Details<T>(val level: Int, val item: T, val index: Int, val comparator: Comparator<T>) {
      fun copyWithNextLevel(): Details<T> = this.copy(level = level + 1)
    }
  }
}