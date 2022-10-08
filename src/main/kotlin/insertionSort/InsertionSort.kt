package insertionSort

/**
 * Сортировка вставками прямо в переданном списке согласно их естественному порядку (по возрастанию)
 */
fun <T:Comparable<T>> MutableList<T>.insertionSort(){
    if(size <= 1){
        return
    }
    for (i in 1 until size){
        var movedElemIndex = i
        while(movedElemIndex>0){
            if(this[movedElemIndex] < this[movedElemIndex-1]){
                this.swap(movedElemIndex-1,movedElemIndex)
                movedElemIndex --
            }else{
                break
            }
        }
    }
}

/**
 * Возвращает список, упорядоченный сортировкой вставками согласно естественному порядку (по возрастанию)
 */
fun <T:Comparable<T>> List<T>.insertionSorted() : List<T> {
    return this.toMutableList()
        .also {
            it.insertionSort()
        }
        .toList()
}

/**
 * Сортировка вставками прямо в переданном списке согласно переданному [comparator]
 */
fun <T> MutableList<T>.insertionSortWith(comparator:Comparator<T>){
    if(size <= 1){
        return
    }
    for (i in 1 until size){
        var movedElemIndex = i
        while(movedElemIndex>0){
            if(comparator.compare(this[movedElemIndex],this[movedElemIndex-1])<0){
                // если рассматриваемый элемент меньше предыдущего в списке
                this.swap(movedElemIndex-1,movedElemIndex)
                movedElemIndex --
            }else{
                break
            }
        }
    }
}

/**
 * Возвращает список, упорядоченный сортировкой вставками согласно переданному [comparator]
 */
fun <T> List<T>.insertionSortedWith(comparator:Comparator<T>) : List<T> {
    return this.toMutableList()
        .also {
            it.insertionSortWith(comparator)
        }
        .toList()
}

/**
 * Сортировка вставками прямо в переданном списке обратно их естественному порядку (по убыванию)
 */
fun <T:Comparable<T>> MutableList<T>.insertionSortDescending(){
    insertionSortWith(reverseComparator())
}

/**
 * Возвращает список, упорядоченный сортировкой вставками обратно естественному порядку (по убыванию)
 */
fun <T:Comparable<T>> List<T>.insertionSortedDescending() : List<T> {
    return this.insertionSortedWith(reverseComparator())
}
