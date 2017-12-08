package helperObjects;

public class LLStack<E> implements Stack<E>
{
	private SNode<E> top; 
	private int size; 
	
	public LLStack() 
	{
		top = null; 
		size = 0; 
	}
	
	public E pop()
	{
		if (isEmpty())
			return null; 
		E etr = top.getElement(); 
		SNode<E> ntr = top;
		top = top.getNext();
		size--;
		ntr.clean();
		return etr;
	}

	public void push(E e) 
	{

		top = new SNode<E>(e, top);
		size++; 
	}

	public E top() 
	{
		if (isEmpty())
			return null; 
		return top.getElement();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
 
}
