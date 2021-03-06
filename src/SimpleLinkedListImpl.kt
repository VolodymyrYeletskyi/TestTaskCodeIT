import java.lang.RuntimeException

class SimpleLinkedListImpl<E> : SimpleLinkedList<E> {

    private var head: Node<E>? = null

    override fun size(): Int {
        var current = head
        var size = 0
        if(head?.element == null) return size
        while (current != null) {
            current = current.next
            size++
        }
        return size
    }

    override fun add(index: Int, element: E) {
        if (index == 0) {
            val node = Node(head, null, element)
            head?.prev = node
            head = node
            return
        }

        if(index < 0 || index >= size()) throw RuntimeException()

        var prev = head
        var current = prev?.next
        var count = 1
        while (current != null) {
            if (count == index) {
                val node = Node(current, prev, element)
                current.prev = node
                prev?.next = node
                return
            }
            prev = current
            current = prev.next
            count++
        }
    }

    override fun remove(index: Int) {
        if(index < 0 || index >= size()) throw RuntimeException()

        if (index == 0) {
            val next = head?.next
            head?.element = null
            head?.next = null
            next?.prev = null
            head = next
            return
        }

        var prev = head
        var current = prev?.next
        var count = 1
        while (current != null) {
            if (count == index) {
                prev?.next = current.next
                current.next?.prev = prev
                current.prev = null
                current.next = null
                current.element = null
                return
            }
            prev = current
            current = prev.next
            count++
        }
    }

    override fun clear() {
        var current: Node<E>? = head

        do {
            current?.prev = null
            current?.element = null
            current = current?.next
            current?.prev?.next = null
        } while (current != null)
    }

    override fun indexOf(element: E): Int {
        var current = head
        var index = 0

        do {
            if (current?.element == element) return index
            current = current?.next
            index++
        } while (current != null)

        throw RuntimeException()
    }
}