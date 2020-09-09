package lab_3;

public class main {

	public static void main(String[] args) {
		Plate plate = new Plate("�������",100,"�����",20,3);
		Cup cup = new Cup("�����",250,"�������",300);
		System.out.println(plate.toString());
		System.out.println(cup.toString());
	}

}

abstract class Dish{
	private String name;
	private int value;// ��������� ������ ��������
	private String color; //���� ������
	
	public String getName() {return name;}
	public int getValue() {return value;}
	public String getColor() {return color;}
	
	public void setName(String name) {this.name = name;}
	public void setValue(int value) {this.value = value;}
	public void setColor(String color) {this.color = color;}
	
}

class Plate extends Dish{
	private int diametr;
	private int amount;
	
	public Plate(
			String name,
			int value, 
			String color,
			int diametr,
			int amount)
	{
		setName(name); //�.�. name - private, � �� protected, �� ���������� ��� ����� ���� ����� ����� public
		setValue(value);
		setColor(color);
		this.diametr = diametr;
		this.amount = amount;
	}
	
	public int getDiametr() {return diametr;}
	public int getAmount() {return amount;}
	public int getTottalCost() {return getValue()*amount;}
	
	public void setAmount(int amount) {this.amount = amount;}
	
	public String toString() {
		return "��������: " + getName() 
		+ " | ���������: RUB" + getValue() 
		+ " | �����������: RUB" + amount 
		+ " | �����: " + getTottalCost() 
		+ " | ����: " + getColor() 
		+ " | �������: " + diametr;
	}
}

class Cup extends Dish{
	private int volume;
	public Cup(
			String name,
			int value, 
			String color,
			int volume)
	{
		setName(name); //�.�. name - private, � �� protected, �� ���������� ��� ����� ���� ����� ����� public
		setValue(value);
		setColor(color);
		this.volume = volume;
	}
	
	public int getVolume() {return volume;}
	
	public void setVolume(int volume) {this.volume = volume;}
	
	public String toString() {
		return "��������: " + getName() 
		+ " | ���������: RUB" + getValue() 
		+ " | �����: RUB" + getValue() 
		+ " | ����: " + getColor() 
		+ " | �����: " + volume;
	}
}
