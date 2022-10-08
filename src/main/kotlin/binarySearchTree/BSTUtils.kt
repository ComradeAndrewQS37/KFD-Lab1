package binarySearchTree

/**
 * Вершина бинарного дерева поиска со значением [value]
 */
class TreeNode<T>(val value: T,
    var left : TreeNode<T>? = null,
    var right : TreeNode<T>? = null,)