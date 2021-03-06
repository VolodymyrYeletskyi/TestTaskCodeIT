import java.lang.RuntimeException

interface SimpleLinkedList<E> {

    fun size(): Int

    @Throws(RuntimeException::class)
    fun add(index: Int, element: E)

    @Throws(RuntimeException::class)
    fun remove(index: Int)

    fun clear()

    @Throws(RuntimeException::class)
    fun indexOf(element: E): Int
}