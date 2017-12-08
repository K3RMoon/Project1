package helperObjects;

public interface Stack<E>
{
	public E top();
	public E pop();
	public void push(E element);
	public int size();
	public boolean isEmpty();
	
}
