package helperObjects;

public interface Queue<E>
{
	public E first();
	public void enqueue(E element);
	public E dequeue();
	public int size();
	public boolean isEmpty();
	public Queue<E> clone();
	
}
