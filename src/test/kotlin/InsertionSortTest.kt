import insertionSort.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class InsertionSortTest{

    @Test
    fun simpleListTest1(){
        val list = listOf(4,7,1,-4,11,3,0)
        val sortedList = list.sorted()
        assertEquals(sortedList,list.insertionSorted())
    }

    @Test
    fun simpleListTest2(){
        val list = mutableListOf(4,7,1,-4,11,3,0)
        val copyList = list.toMutableList()
        list.sort()
        copyList.insertionSort()
        assertEquals(copyList,list)
    }

    @Test
    fun simpleListTestDesc1(){
        val list = listOf('b','-','9','+','п','v','*')
        val sortedList = list.sortedDescending()
        assertEquals(sortedList,list.insertionSortedDescending())
    }

    @Test
    fun simpleListTestDesc2(){
        val list = mutableListOf('b','-','9','+','п','v','*')
        val copyList = list.toMutableList()
        list.sortDescending()
        copyList.insertionSortDescending()
        assertEquals(copyList,list)
    }

    @Test
    fun simpleListTestWith1(){
        val list = listOf("Sammy","Alexander","L","Ben","Mr. Serious")
        val sortedList = list.sortedWith(compareBy{it.length})
        assertEquals(sortedList,list.insertionSortedWith(compareBy{it.length}))
    }

    @Test
    fun simpleListTestWith2(){
        val list = mutableListOf("Sam","Alexander","L","Ben","Mr. Serious")
        val copyList = list.toMutableList()
        list.sortWith(compareBy{it.length})
        copyList.insertionSortWith(compareBy{it.length})
        assertEquals(copyList,list)
    }

    @Test
    fun emptyListTest(){
        val emptyList = listOf<Int>()
        assertEquals(emptyList,emptyList.insertionSorted())
        assertEquals(emptyList,emptyList.insertionSortedDescending())
        assertEquals(emptyList,emptyList.insertionSortedWith( compareBy{it.toString().length}))
    }
}