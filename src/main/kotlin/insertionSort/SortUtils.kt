package insertionSort

/**
 * Меняет местами элементы MutableList
 */
fun <T> MutableList<T>.swap(index1:Int, index2:Int) {
    if (index1 < 0 || index2 < 0) {
        throw IllegalArgumentException("Index ${if (index1 < 0) index1 else index2} was negative")
    }
    if (index1 >= this.size || index2 >= this.size) {
        throw IndexOutOfBoundsException(if (index1 >= this.size) index1 else index2)
    }
    val buff = this[index1]
    this[index1] = this[index2]
    this[index2] = buff
}

/**
 * Возвращает Comparator, сравнивающий объекты в порядке, обратном естественному
 */
fun<T : Comparable<T>> reverseComparator(): Comparator<T> {
    return Comparator{ a, b -> b.compareTo(a) }

}