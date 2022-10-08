package binarySearchTree

import java.util.*

typealias BST<T> = BinarySearchTree<T>

class BinarySearchTree<T : Comparable<T>>() : MutableCollection<T> {

    private var root: TreeNode<T>? = null
    override var size: Int = 0

    // создать дерево с элементами values
    constructor(vararg values:T) : this(){
        for (value in values){
            this.add(value)
        }
    }

    // создать дерево с элементами values
    constructor(values: Iterable<T>) : this(){
        for (value in values){
            this.add(value)
        }
    }

    // рекурсивно обойти дерево и применить action к каждой вершине
    fun traverse(action: (TreeNode<T>)->Unit) {
        root?.let { traverseRecursive(action, it) }
    }

    // реализация рекурсивного обхода из заданной вершины
    private fun traverseRecursive(action: (TreeNode<T>)->Unit, node: TreeNode<T>){
        node.left?.let { traverseRecursive (action, it) }
        action(node)
        node.right?.let { traverseRecursive (action, it) }
    }

    override fun add(element:T) : Boolean{
        if(root == null){
            root = TreeNode(element)
            size++
            return true
        }
        var currentNode = root!!
        while(true){
            if(element < currentNode.value){
                if(currentNode.left != null){
                    currentNode = currentNode.left!!
                }else{
                    currentNode.left = TreeNode(element)
                    size++
                    return true
                }
            }else if (element > currentNode.value){
                if(currentNode.right != null){
                    currentNode = currentNode.right!!
                }else{
                    currentNode.right = TreeNode(element)
                    size++
                    return true
                }
            }else{
                // это значение уже хранится в дереве
                return false
            }
        }
    }

    override fun clear() {
        root?.let { clearRecursive(it) }
        root = null
    }

    private fun clearRecursive(node: TreeNode<T>){
        node.left?.let { clearRecursive (it) }
        node.right?.let { clearRecursive (it) }
        node.left = null
        node.right = null
    }

    override fun addAll(elements: Collection<T>): Boolean {
        var toReturn = false
        for (element in elements){
            val wasAdded = add(element)
            toReturn = toReturn || wasAdded
        }
        return toReturn
    }

    override fun isEmpty(): Boolean = (root == null)

    override fun iterator(): MutableIterator<T> {
        return BSTMutableIterator()
    }

    inner class BSTMutableIterator: MutableIterator<T>{
        // стек, хранящий непосещённые вершины
        private val nodeStack = Stack<TreeNode<T>>()

        init{
            var current = root
            while(current!=null){
                nodeStack.push(current)
                current = current.left
            }
        }


        override fun hasNext(): Boolean = nodeStack.isNotEmpty()

        override fun next(): T {
            val toReturnNode = nodeStack.pop()
            var current = toReturnNode.right
            while(current!=null){
                nodeStack.push(current)
                current = current.left
            }

            return toReturnNode.value
        }

        override fun remove() {
            TODO("Not yet implemented")
        }

    }

    override fun retainAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var toReturn = false
        for(element in elements){
            val wasRemoved = remove(element)
            toReturn = toReturn || wasRemoved
        }
        return toReturn
    }


    override fun remove(element: T): Boolean {
        var currentNode: TreeNode<T>? = root
        // родитель вершины, которую нужно удалить
        var currentNodeParent: TreeNode<T>? = null

        // ищем вершину, которую надо удалить
        while (true) {
            if (currentNode == null) {
                // element отсутсвует в списке
                return false
            }
            if (currentNode.value == element) {
                // element найден
                break
            }
            if (element < currentNode.value) {
                currentNodeParent = currentNode
                currentNode = currentNode.left
            } else {
                currentNodeParent = currentNode
                currentNode = currentNode.right
            }
        }
        val toRemove = currentNode as TreeNode<T>
        val toRemoveParent = currentNodeParent

        // у удаляемой вершины меньше двух детей
        if (toRemove.left == null || toRemove.right == null) {
            val toRemoveChild = toRemove.left ?: toRemove.right
            // если нет детей, то toRemoveChild будет null
            // если есть ребёнок, то toRemoveChild будет ссылаться на него
            if (toRemoveParent == null) {
                // удаляем корень
                root = toRemoveChild
            } else {
                when (toRemove.value) {
                    toRemoveParent.left?.value -> toRemoveParent.left = toRemoveChild
                    toRemoveParent.right?.value -> toRemoveParent.right = toRemoveChild
                }
            }
        }
        // у удаляемой вершины двое детей
        else {
            // находим наибольший элемент в левом поддереве и его родителя
            var toReplaceWith = toRemove.left!!
            var toReplaceWithParent = toRemove
            while (toReplaceWith.right != null) {
                toReplaceWithParent = toReplaceWith
                toReplaceWith = toReplaceWith.right!!
            }

            // на случай наличия левого потомка у вершины nodeToReplace
            if (toReplaceWithParent != toRemove) {
                toReplaceWithParent.right = toReplaceWith.left
            }
            toReplaceWith.left = toRemove.left
            toReplaceWith.right = toRemove.right

            if (toRemoveParent == null) {
                // удаляем корень
                root = toReplaceWith
            } else {
                when (toRemove.value) {
                    toRemoveParent.left?.value -> toRemoveParent.left = toReplaceWith
                    toRemoveParent.right?.value -> toRemoveParent.right = toReplaceWith
                }
            }
        }
        // удалили вершину
        size--
        return true
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for(element in elements){
            if(!this.contains(element)){
                return false
            }
        }
        return true
    }

    override fun contains(element: T): Boolean {
        var current = root
        while (current != null) {
            if (current.value == element) {
                return true
            }
            current = if (element < current.value) {
                current.left
            } else {
                current.right
            }
        }
        // element не найден
        return false
    }


}