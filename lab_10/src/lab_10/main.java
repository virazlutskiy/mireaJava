package lab_10;

import java.lang.reflect.Array;
import java.util.*;

public class main {
	public static void main(String[] args) {
		//new task1();
		//new task2_4();
	}
}
/*

1.	�������� ����� ��� ����������� ������� �����/����� � ������. 
2.	�������� �����, ������� ����� ������� � ���� ������ ����� ����� ������ (int, long etc.).
3.	����������� �����, ������� ���������� ����� ������� ������� �� �������.
4.	 �������� �������, ������� �������� ���������� �������� � ������ � ������� ������ 5 ��������� �� �����.
5.	*���������� ��������������� ������ � ������ Solution, ������� ������ ��������� ��������������� ��������� � �������� ���� ���������� �������. ������ newArrayList, newHashSet ���������������� ����� ����� T. ����� newHashMap ���������������� ����� <K, V>, �� ���� ������ �- ���� � V-��������. ��������� ������ newHashMap ������ ���������

*/
class task1{
	task1(){
		Integer arr[] = {1,2,3,4,5};
		ArrayList<Integer> lst = new ArrayList<Integer>();
		System.out.println(lst);
		ArrayToArrayList(arr,lst);
		System.out.println(lst);
		
		String strArr[] = {"Hi","buy","mine"};
		ArrayList<String> strLst = new ArrayList<String>();
		System.out.println(strLst);
		ArrayToArrayList(strArr,strLst);
		System.out.println(strLst);
		
		
	}
	<E> void ArrayToArrayList(E[] a,ArrayList<E> lst) 
	{		
		for (E e : a) {lst.add(e);}
	}
}
class task2_4{
	task2_4(){
		MyGenericArrayList GAL = new MyGenericArrayList();
		//2 task
		GAL.add(true);
		GAL.add("Two");
		GAL.add(3.0);
		GAL.add(4);
		GAL.add(5);
		//3 task
		System.out.println(GAL.get(0));
		System.out.println(GAL.get(1));
		System.out.println(GAL.get(2));
		//4 task
		MyGenericArrayListToList(GAL);
	}
	void MyGenericArrayListToList(MyGenericArrayList GAL){
		ArrayList list = new ArrayList();
		for(int i =0;i<GAL.size();i++)
		{
			list.add(GAL.get(i));
		}
		for(int i =0;i<list.size();i++)
		{
			if(i>=5)
				break;
			System.out.println(list.get(i));
		}
	}
}
class  MyGenericArrayList {
	   private int size;     // ���������� ���������
	   private Object[] elements;
	   
	   public MyGenericArrayList() {  // �����������
	      elements = new Object[10];  // �������� ������ ��� ������ 10 �������� 
	      size = 0;
	   }
	   
	   // ���������� �������� ����������������� ��� E �� Object, �� ���������, ��� �������� e ����� ��� E, ����� //�� ������������ ��� ����������� ������������ ����

	   public void add(Object e) {
	      if (size < elements.length) {
	         elements[size] = e;
	      } else {
	         // allocate a larger array and add the element, omitted
	      }
	      ++size;
	   }
	   
	   // ���������� �������� E �� Object � ������ �������� ����������� �������������� ����� (E <E>) ��� //���� ������������� �������� ��� ������ ������

	   public Object get(int index) {
	      if (index >= size)
	         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	      return (Object)elements[index];
	   }
	   
	   public int size() { 
	      return size; 
	   }
}

