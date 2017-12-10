package helperObjects;


public class SLLQueue<E> implements Queue<E> {

	private static class Node<E> { 
		private E element; 
		private Node<E> next; 
		@SuppressWarnings("unused")
		public Node() {}
		public Node(E e) { 
			element = e; 
			next = null; 
		}
		@SuppressWarnings("unused")
		public Node(E e, Node<E> n) { 
			element = e; 
			next = n; 
		}
		public E getElement() {
			return element;
		}
		@SuppressWarnings("unused")
		public void setElement(E element) {
			this.element = element;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
		public void clean() { 
			element = null; 
			next = null; 
		}
	}
	
	private Node<E> first, last; 
	private int size; 
	
	public SLLQueue() { 
		first = last = null; 
		size = 0; 
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E first() {
		if (isEmpty()) return null;
		return first.getElement(); 
	}

	@Override
	public E dequeue() {
		if (isEmpty()) return null;		
		Node<E> ntr = first; 
		first = first.getNext(); 
		size--; 
		if (size == 0) 
			last = null; 
		E etr = ntr.getElement(); 
		ntr.clean();
		return etr; 
	}

	@Override
	public void enqueue(E e) {
		if (size == 0) 
			first = last = new Node<>(e); 
		else { 
			last.setNext(new Node<>(e));
			last = last.getNext(); 
		}
		size++; 
	}

	public Queue<E> clone()
	{
		Queue<E> clone = new SLLQueue<E>();
		for(int i = 0; i < this.size(); i++)
        {
            clone.enqueue(this.first());
            this.enqueue(this.dequeue());
        }

        return clone;
	}

}
