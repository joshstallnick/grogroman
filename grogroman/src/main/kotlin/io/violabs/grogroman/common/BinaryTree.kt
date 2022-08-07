package io.violabs.grogroman.common

import com.fasterxml.jackson.annotation.JsonIgnore

open class BinaryTree<T>(initialList: MutableList<T>, var root: Node<T>? = null, private val comparator: Comparator<T>) {
  var size: Int = 0

  init {
    initialList.forEachIndexed(::add)
  }

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

  fun add(item: T) = add(size, item)

  private fun calculateSize() { this.size = root?.calculateSize() ?: 0 }

  fun findIndex(item: T): Int {
    return root?.findIndex(item, comparator) ?: -1
  }

  fun findNode(item: T): Node<T>? = root?.findNode(item, comparator)

  @JsonIgnore
  fun isLeaf(item: T): Boolean? = this.findNode(item)?.isLeaf()

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

    fun findIndex(item: T, comparator: Comparator<T>): Int {
      if (key == item) return index ?: -1

      val compared: Int = comparator.compare(key, item)

      if (compared == 1) return left?.findIndex(item, comparator) ?: -1

      return right?.findIndex(item, comparator) ?: -1
    }

    fun findNode(item: T, comparator: Comparator<T>): Node<T>? {
      if (key == item) return this

      val compared: Int = comparator.compare(key, item)

      if (compared == 1) return left?.findNode(item, comparator)

      return right?.findNode(item, comparator)
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

    fun calculateSize(): Int {
      val leftSize = left?.calculateSize() ?: 0
      val rightSize = right?.calculateSize() ?: 0
      val thisSize = 1

      return leftSize + rightSize + thisSize
    }

    @JsonIgnore
    fun isLeaf(): Boolean = left == null && right == null

    data class Details<T>(val level: Int, val item: T, val index: Int, val comparator: Comparator<T>) {
      fun copyWithNextLevel(): Details<T> = this.copy(level = level + 1)
    }
  }
}