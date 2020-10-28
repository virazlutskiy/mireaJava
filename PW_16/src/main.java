import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


interface Item{
	double getCost();
	String getName();
	String getDescription();
}

final class Drink implements Item{
	final double cost;
	final String name;
	final String description;
	Drink(String name, String description, double cost){
		this.name = name;
		this.description = description;
		this.cost = cost;
	}
	Drink(String name, String description){
		this.name = name;
		this.description = description;
		this.cost = 0;
	}
	public double getCost() {
		return cost;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
}
final class Dish implements Item{
	final double cost;
	final String name;
	final String description;
	Dish(String name, String description, double cost){
		this.name = name;
		this.description = description;
		this.cost = cost;
	}
	Dish(String name, String description){
		this.name = name;
		this.description = description;
		this.cost = 0;
	}
	public double getCost() {
		return cost;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
}

class Order{
	HashMap<Item, Integer> order = new HashMap<>();
	public void add(Item item,int amount) {
		order.put(item, amount);
	}
	public void remove(Item item) {
		order.remove(item);
	}
}
class TablesOrderManager{
	HashMap<Integer, Order> tablesOrders = new HashMap<>();
	public void add(int tableID, Order order) {
		tablesOrders.put(tableID,order);
	}
	public void remove(int tableId) {
		tablesOrders.remove(tableId);
	}
}
class InternetOrder{
	class LinkedList{
		protected int previous;
		protected int next;
		protected Order order;
		LinkedList(int previous, int next, Order order){
			setPrevious(previous);
			setNext(next);
			
		}
		
		int getPrevious() {return previous;}
		void setPrevious(int previous) {this.previous = previous;}
		
		int getNext() {return next;}
		void setNext(int next) {this.next = next;}
		
		Order getOrder() {return order;}
		void setOrder(Order order) {this.order = order;}
	}
	LinkedList head;
	HashMap<Integer, LinkedList> internetOrders = new HashMap<>();
	
	InternetOrder(Order[] orders){
		head.setNext(0);
		head.setPrevious(0);
		
		
		for(Order order : orders)
		{
			
			LinkedList LL = new LinkedList(0, 0, order);
		}
		LinkedList LL = new LinkedList(0, 0, order);
		head.setPrevious(1);
		head.setNext(1);
		internetOrders.put(0, head);
		internetOrders.put(1, LL);
	}
}