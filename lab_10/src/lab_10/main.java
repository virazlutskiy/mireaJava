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

1.	Написать метод для конвертации массива строк/чисел в список. 
2.	Написать класс, который умеет хранить в себе массив любых типов данных (int, long etc.).
3.	Реализовать метод, который возвращает любой элемент массива по индексу.
4.	 Написать функцию, которая сохранит содержимое каталога в список и выведет первые 5 элементов на экран.
5.	*Реализуйте вспомогательные методы в классе Solution, которые должны создавать соответствующую коллекцию и помещать туда переданные объекты. Методы newArrayList, newHashSet параметризируйте общим типом T. Метод newHashMap параметризируйте парой <K, V>, то есть типами К- ключ и V-значение. Аргументы метода newHashMap должны принимать

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
	   private int size;     // количество элементов
	   private Object[] elements;
	   
	   public MyGenericArrayList() {  // конструктор
	      elements = new Object[10];  // выделяем память для первых 10 объектов 
	      size = 0;
	   }
	   
	   // Компилятор заменяет параметризованный тип E на Object, но проверяет, что параметр e имеет тип E, когда //он используется для обеспечения безопасности типа

	   public void add(Object e) {
	      if (size < elements.length) {
	         elements[size] = e;
	      } else {
	         // allocate a larger array and add the element, omitted
	      }
	      ++size;
	   }
	   
	   // Компилятор заменяет E на Object и вводит оператор понижающего преобразования типов (E <E>) для //типа возвращаемого значения при вызове метода

	   public Object get(int index) {
	      if (index >= size)
	         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	      return (Object)elements[index];
	   }
	   
	   public int size() { 
	      return size; 
	   }
}

