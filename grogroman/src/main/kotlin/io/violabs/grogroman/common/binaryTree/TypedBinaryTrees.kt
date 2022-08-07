package io.violabs.grogroman.common.binaryTree

import io.violabs.grogroman.common.BinaryTree

class IntBinaryTree(initialList: MutableList<Int>) :
  BinaryTree<Int>(initialList, comparator = Int::compareTo)

class StringBinaryTree(initialList: MutableList<String>) :
  BinaryTree<String>(initialList, comparator = String::compareTo)