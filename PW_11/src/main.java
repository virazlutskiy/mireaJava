import java.util.ArrayList;
import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		//new ArrayQueueModuleTest();
		//new ArrayQueueADTTest();
		//new ArrayQueueTest();
		new calculator();
	}

}
class ArrayQueueTest{
	ArrayQueueTest(){
		ArrayQueue AQ = new ArrayQueue(4);
		AQ.enqueue(1);
		AQ.enqueue(2);
		AQ.enqueue(3);
		AQ.enqueue(4);
		AQ.enqueue(5);
		System.out.println(AQ.dequeue());
		System.out.println(AQ.dequeue());
		System.out.println(AQ.dequeue());
		System.out.println(AQ.dequeue());
	}
}
class ArrayQueueADTTest{
	ArrayQueueADTTest(){
		ArrayQueueADT AQADT = new ArrayQueueADT();
		for(int i = 0;i<20;i++)
		{
			AQADT.enqueue(AQADT,i);
		}
		for(int i = 0;i<20;i++)
		{
			System.out.println(AQADT.dequeue(AQADT));
		}
		for(int i = 20;i<30;i++)
		{
			AQADT.enqueue(AQADT,i);
		}
		for(int i = 0;i<10;i++)
		{
			System.out.println(AQADT.dequeue(AQADT));
		}
		System.out.println(AQADT.isEmpty(AQADT));
		AQADT.clear(AQADT);
		System.out.println(AQADT.isEmpty(AQADT));
	}
}
class ArrayQueueModuleTest
{
	ArrayQueueModuleTest(){
		for(int i = 0;i<20;i++)
		{
			ArrayQueueModule.enqueue(i);
		}
		for(int i = 0;i<20;i++)
		{
			System.out.println(ArrayQueueModule.dequeue());
		}
		for(int i = 20;i<30;i++)
		{
			ArrayQueueModule.enqueue(i);
		}
		for(int i = 0;i<10;i++)
		{
			System.out.println(ArrayQueueModule.dequeue());
		}
		System.out.println(ArrayQueueModule.isEmpty());
		ArrayQueueModule.clear();
		System.out.println(ArrayQueueModule.isEmpty());
	}
}
interface Queue{
		void enqueue(Object o); 
		Object element();
		Object dequeue(); 
		int size ();
		boolean isEmpty(); 
		void clear();
}

class ArrayQueueADT{

	private int read,size,write;
	private Object[] queue = new Object[10];
	
	ArrayQueueADT() {
		size = 0;
		read= 0;
		write = 0;
	}
	public void enqueue(ArrayQueueADT AQADT,Object o) {
		if(AQADT.size+1>AQADT.queue.length)
		{
			AQADT.queue = Arrays.copyOf(AQADT.queue, 2*AQADT.queue.length);
		}
		AQADT.queue[write++] = o;
		size++;
	}

	
	public Object element(ArrayQueueADT AQADT) {
		return AQADT.queue[read];
	}

	
	public Object dequeue(ArrayQueueADT AQADT) {
		return AQADT.queue[read++];
	}

	
	public int size(ArrayQueueADT AQADT) {
		return AQADT.size;
	}
	
	public boolean isEmpty(ArrayQueueADT AQADT) {
		return AQADT.size == 0;
	}	
	
	public void clear(ArrayQueueADT AQADT) {
		AQADT.queue = new Object[10];
		AQADT.size = 0;
	}

}
class ArrayQueueModule {

	private static int read;
	private static int size;
	private static int write;
	private static Object[] queue = new Object[10];
	ArrayQueueModule() {
		size = 0;
		read= 0;
		write = 0;
	}
	public static void enqueue(Object o) {
		if(size+1>queue.length)
		{
			queue = Arrays.copyOf(queue, 2*queue.length);
		}
		queue[write++] = o;
		size++;
		
	}

	
	public static Object element() {
		return queue[read];
	}

	
	public static Object dequeue() {
		 return queue[read++];
	}

	
	public static int size() {
		return size;
	}

	
	public static boolean isEmpty() {
		return size == 0;
	}

	
	public static void clear() {
		size = 0;
		read= 0;
		write = 0;
		queue = new Object[10];
	}
}

class ArrayQueue extends AbstractQueue implements Queue
{
	private int size,start,end;
	private Object[] queue;
	
	ArrayQueue(int size){
		this.size = size;
		start = size-1;
		end = size-1;
		queue = new Object[size];
	}
	
	@Override
	public void enqueue(Object o) {
		queue[end] = o;
		end -= 1;
		if(end<0)
		{
			end = size - 1;
		}
	}

	@Override
	public Object element() {
		return queue[start];
	}

	@Override
	public Object dequeue() {
		Object result = queue[start];
		if(result == null)
			throw new NullPointerException();
		queue[start] = null;
		start -=1;
		if(start<0)
			start = size - 1;
		
		return result;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}
	@Override
	public void clear() {
		this.size = size;
		start = size-1;
		end = size-1;
		queue = new Object[10];
	}
}

class LinkedQueue extends AbstractQueue implements Queue {
	ArrayList<Object> queue = new ArrayList<Object>();
	
	@Override
	public void enqueue(Object o) {
		queue.add(o);	
	}
	@Override
	public Object element() {
		return queue.get(0);
	}
	@Override
	public Object dequeue() {
		return queue.remove(0);
	}
	@Override
	public int size() {
		return queue.size();
	}
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	@Override
	public void clear() {
		queue.clear();
	}
}
class AbstractQueue {

}

