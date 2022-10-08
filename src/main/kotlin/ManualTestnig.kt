import insertionSort.insertionSort
import kotlin.system.measureTimeMillis
import binarySearchTree.BST

fun manualTesting(){
    println("Введите последовательность чисел (каждое число с новой строки, 0 означает конец ввода):")
    val list = inputList()
    val time = measureTimeMillis { list.insertionSort() }
    println("Ваша последовательность чисел успешно отсортирована алгоритмом сортировки вставками:")
    println(list)
    println("На это ушло всего $time мс")

    val tree = BST(list)
    println("\nТакже мы сделали бинарное дерево на основе введённой последовательности")
    println("Все элементы дерева в порядке возрастания:")
    println(tree.toList())
}

fun inputList() : MutableList<Int>{
    val result = mutableListOf<Int>()
    while(true){
        val input = readln().toInt()
        if(input==0){
            break
        }else{
            result.add(input)
        }
    }

    return result
}