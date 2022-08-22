package io.violabs.grogroman.common.binaryTree

import com.fasterxml.jackson.annotation.JsonIgnore
import io.violabs.grogroman.common.t

object BinarySearchExt {
  fun <T, B : BinaryTree<T>> isFullBinaryTree(tree: B): Boolean = tree.isFullBinaryTree()
  fun <T, B : BinaryTree<T>> isCompleteBinaryTree(tree: B): Boolean = tree.isCompleteBinaryTree()
}

//region findIndex
fun <T> BinaryTree<T>.findIndex(item: T): Int = root?.findIndex(item, comparator) ?: -1
fun <T> BinaryTree.Node<T>.findIndex(item: T, comparator: Comparator<T>): Int {
  if (key == item) return index ?: -1

  val compared: Int = comparator.compare(key, item)

  if (compared == 1) return left?.findIndex(item, comparator) ?: -1

  return right?.findIndex(item, comparator) ?: -1
}
//endregion findIndex

//region findNode
fun <T> BinaryTree<T>.findNode(item: T): BinaryTree.Node<T>? = root?.findNode(item, comparator)

fun <T> BinaryTree.Node<T>.findNode(item: T, comparator: Comparator<T>): BinaryTree.Node<T>? {
  if (key == item) return this

  val compared: Int = comparator.compare(key, item)

  if (compared == 1) return left?.findNode(item, comparator)

  return right?.findNode(item, comparator)
}
//endregion findNode

//region isLeaf
@JsonIgnore
fun <T> BinaryTree<T>.isLeaf(item: T): Boolean? = this.findNode(item)?.isLeaf()
@JsonIgnore
fun <T> BinaryTree.Node<T>.isLeaf(): Boolean = left == null && right == null
//endregion isLeaf

//region isFullBinaryTree
fun <T> BinaryTree<T>.isFullBinaryTree(): Boolean =  this.root?.isFullBinaryTree().t()

fun <T> BinaryTree.Node<T>.isFullBinaryTree(): Boolean {
  return this.isLeaf() || this.isFull()
}

fun <T> BinaryTree.Node<T>.isFull(): Boolean =
  left?.isFullBinaryTree().t() and right?.isFullBinaryTree().t()
//endregion isFullBinaryTree

//region isCompleteBinaryTree

fun <T> BinaryTree<T>.isCompleteBinaryTree(): Boolean =  this.root?.isFullBinaryTree().t()

fun <T> BinaryTree.Node<T>.isCompleteBinaryTree(): Boolean {
  return this.isLeaf() || this.left?.isLeaf().t() || this.isCompletelyFull()
}

fun <T> BinaryTree.Node<T>.isCompletelyFull(): Boolean =
  left?.isCompleteBinaryTree().t() && right?.isCompleteBinaryTree().t()

//endregion isCompleteBinaryTree