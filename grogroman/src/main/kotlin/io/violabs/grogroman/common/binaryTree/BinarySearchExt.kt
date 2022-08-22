package io.violabs.grogroman.common.binaryTree

import com.fasterxml.jackson.annotation.JsonIgnore
import io.violabs.grogroman.common.t
import kotlin.math.abs

object BinarySearchExt {
  fun <T, B : BinaryTree<T>> isFullBinaryTree(tree: B): Boolean = tree.isFullBinaryTree()
  fun <T, B : BinaryTree<T>> isCompleteBinaryTree(tree: B): Boolean = tree.isCompleteBinaryTree()

  fun <T, B : BinaryTree<T>> isPerfectBinaryTree(tree: B): Boolean = tree.isPerfectBinaryTree()
  fun <T, B : BinaryTree<T>> isBalancedBinaryTree(tree: B): Boolean = tree.isBalancedBinaryTree()
  fun <T, B : BinaryTree<T>> isDegenerateBinaryTree(tree: B): Boolean = tree.isDegenerateBinaryTree()
  fun <T, B : BinaryTree<T>> isLeftSkewedBinaryTree(tree: B): Boolean = tree.isLeftSkewed()
  fun <T, B : BinaryTree<T>> isRightSkewedBinaryTree(tree: B): Boolean = tree.isRightSkewed()
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
fun <T> BinaryTree<T>.isFullBinaryTree(): Boolean = this.root?.isFullBinaryTree().t()

fun <T> BinaryTree.Node<T>.isFullBinaryTree(): Boolean {
  return this.isLeaf() || this.isFullRecursive()
}

fun <T> BinaryTree.Node<T>.isFullRecursive(): Boolean =
  left?.isFullBinaryTree().t() and right?.isFullBinaryTree().t()
//endregion isFullBinaryTree

//region isCompleteBinaryTree

fun <T> BinaryTree<T>.isCompleteBinaryTree(): Boolean = this.root?.isFullBinaryTree().t()

fun <T> BinaryTree.Node<T>.isCompleteBinaryTree(): Boolean {
  return this.isLeaf() || this.left?.isLeaf().t() || this.isCompletelyFull()
}

fun <T> BinaryTree.Node<T>.isCompletelyFull(): Boolean =
  left?.isCompleteBinaryTree().t() && right?.isCompleteBinaryTree().t()

//endregion isCompleteBinaryTree

//region isPerfectBinaryTree

fun <T> BinaryTree<T>.isPerfectBinaryTree(): Boolean =
  BinaryTreeCalculator.maxNodesAtHeight(this.height() + 1) == this.size

//endregion isPerfectBinaryTree

//region isBalancedBinaryTree

fun <T> BinaryTree<T>.isBalancedBinaryTree(): Boolean =
  (this.leftHeight() - this.rightHeight()).toDouble().let(::abs) <= 1

//endregion isBalancedBinaryTree

//region isDegenerate|isPathological
fun <T> BinaryTree<T>.isDegenerateBinaryTree(): Boolean = root?.isDegenerate().t()

fun <T> BinaryTree<T>.isPathological(): Boolean = this.isDegenerateBinaryTree()

fun <T> BinaryTree.Node<T>.isDegenerate(): Boolean {
  return this.isLeaf() || (!hasTwoChildren() && (left?.isDegenerate().t() || right?.isDegenerate().t()))
}

fun <T> BinaryTree.Node<T>.hasTwoChildren(): Boolean = left != null && right != null
//endregion isDegenerate|isPathological

//region isLeftSkewed
fun <T> BinaryTree<T>.isLeftSkewed(): Boolean = root?.isLeftSkewed().t()

fun <T> BinaryTree.Node<T>.isLeftSkewed(): Boolean {
  return this.isLeaf() || (left?.isLeftSkewed().t() && right == null)
}
//endregion isLeftSkewed

//region isRightSkewed
fun <T> BinaryTree<T>.isRightSkewed(): Boolean = root?.isRightSkewed().t()

fun <T> BinaryTree.Node<T>.isRightSkewed(): Boolean {
  return this.isLeaf() || (right?.isRightSkewed().t() && left == null)
}
//endregion isRightSkewed