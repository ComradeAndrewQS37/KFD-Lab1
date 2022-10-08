import binarySearchTree.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class BSTTest {

    @Test
    fun constructTest() {
        val tree1 = BST<Int>()
        assert(tree1.isEmpty())
        assertEquals(tree1.size, 0)

        val tree2 = BST("ABC","DD","attr")
        assertEquals(tree2.size,3)

        val tree3 = BST('b','+','+','K')
        assertEquals(tree3.size,3)
    }

    @Test
    fun containsTest(){
        val tree1 = BST(12,-4,10,11,5,6,1)
        assert(tree1.contains(12))
        assert(tree1.containsAll(listOf(1,10,5,11,6,12,-4)))
        assert(tree1.containsAll(listOf(-4,12,11)))
        assertFalse(tree1.containsAll(listOf(10,11,12,13,14,15)))
    }

    @Test
    fun addTest(){
        val tree1 = BST<Int>()
        assert(tree1.add(12))
        assert(tree1.contains(12))
        assertEquals(tree1.size,1)

        assert(tree1.addAll(listOf(-4,10,11,5,6,1)))
        assert(tree1.containsAll(listOf(1,10,5,11,6,12,-4)))
        assert(tree1.isNotEmpty())
        assertEquals(tree1.size,7)

        assertFalse(tree1.add(12))
        assertEquals(tree1.size,7)

        assert(tree1.addAll(listOf(10,5,111111)))
        assertEquals(tree1.size,8)
    }


    @Test
    fun removeTest(){
        val tree1 = BST(56,11,-9,0,17,456,12_000,20)
        assertEquals(tree1.size,8)
        assert(tree1.remove(11))
        assertEquals(tree1.size,7)

        assertFalse(tree1.remove(-1))
        assertEquals(tree1.size,7)
        assert(tree1.removeAll(listOf(17,456,20,22,23)))
        assertEquals(tree1.size, 4)

        tree1.clear()
        assert(tree1.isEmpty())
    }


    @Test
    fun iteratorTest(){
        val strings = listOf("Mystery","Kotlin","Forest","Search")
        val tree = BST("Mystery","Kotlin","Forest","Search")
        var num = 0
        for(elem in tree){
            num++
            assert(elem in strings)
        }
        assertEquals(num,4)
    }

    @Test
    fun orderingTest(){
        val ints = listOf(11,-5,123,0,45,56,12,111,90,-67,-45)
        val tree = BST(ints)

        assertEquals(ints.sorted(), tree.toList())
    }

    @Test
    fun traverseTest(){
        val ints =  listOf(11,-5,123,0,45,56,12,111,90,-67,-45)
        val doubledInts = ints.map { it*2 }
        val tree1 = BST(ints)
        val tree2 = BST<Int>()

        tree1.traverse { tree2.add(it.value * 2) }

        assertEquals(doubledInts.sorted(), tree2.toList())
    }
}