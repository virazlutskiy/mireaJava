public class main {

	public static void main(String[] args) {
		task_2 task = new task_2();

	}
}

class task_2
{
	public task_2()
	{
		Circle circle = new Circle(2,"Green",true);
		System.out.println(circle.toString());
		Rectangle rectangle = new Rectangle(10,10,"White",false);
		System.out.println(rectangle.toString());
		Square square = new Square(10);
		System.out.println(square.toString());
		
	}
	abstract class Shape
	{
		protected String color;
		protected boolean filled;
		
		Shape()
		{
			color = "Red";
			filled = true;
		}
		Shape(String color,boolean filled)
		{
			this.color = color;
			this.filled = filled;
		}
		String getColor() {return color;}
		void setColor(String color) {this.color = color;}
		boolean isFilled() {return filled;}
		
		abstract double getArea();
		abstract double getPerimeter();
		public abstract String toString();
	}
	
	class Circle extends Shape{

		protected double radius;
		
		public Circle() {
			radius = 0;
		}
		
		public Circle(double radius)
		{
			this.radius = radius;
		}
		public Circle(double radius,String color,boolean filled)
		{
			this.radius = radius;
			this.color = color;
			this.filled = filled;
		}
		
		double getRadius(){return radius;}
		
		void setRadius(double radius) {this.radius = radius;}
		
		@Override
		double getArea() {
			return Math.PI*radius*radius;
		}

		@Override
		double getPerimeter() {
			return 2*Math.PI*radius;
		}

		@Override
		public String toString() {
			return "Цвет: " + getColor() 
			+ " | Заливка: " + isFilled() 
			+ " | Радиус: " + radius 
			+ " | Периметр: " + getPerimeter() 
			+ " | Площадь: " + getArea();
		}
	
	}
	
	class Rectangle extends Shape{

		protected double width;
		protected double length;
		
		public Rectangle(){width = 0; length = 0;}
		public Rectangle(
				double width, 
				double length){
			this.width = width; 
			this.length = length;
			}
	
		public Rectangle(
				double width, 
				double length,
				String color,
				boolean filled){
			this.width = width; 
			this.length = length;
			this.color = color;
			this.filled = filled;
		}
		
		double getWidth() {return width;}
		double getLength() {return length;}
		
		void setWidth(double width) {this.width=width;}
		void setLength(double length) {this.length = length;}
		
		@Override
		double getArea() {
			return width*length;
		}

		@Override
		double getPerimeter() {
			return 2*(width+length);
		}

		@Override
		public String toString() {
			return "Цвет: " + getColor() 
			+ " | Заливка: " + isFilled() 
			+ " | Ширина: " + width 
			+ " | Длина: " + length 
			+ " | Периметр: " + getPerimeter() 
			+ " | Площадь: " + getArea();
		}
		
	}

	class Square extends Rectangle{
		protected double side;
		
		Square(){side = 0;}
		Square(double side){setSide(side);}
		Square(
			double side,
			String color,
			boolean filled)
		{
			setSide(side);
			this.color = color;
			this.filled = filled;
		}
		
		double getSide() {return side;}
		void setSide(double side) {
			this.side = side;
			this.width = side; 
			this.length = side;
			}
		
		@Override
		void setWidth(double side) {this.width = side; this.length = side;}
		
		@Override
		void setLength(double side) {this.width = side; this.length = side;}
		
		@Override
		public String toString() {
			return "Цвет: " + getColor() 
			+ " | Заливка: " + isFilled() 
			+ " | Сторона: " + side
			+ " | Периметр: " + getPerimeter() 
			+ " | Площадь: " + getArea();
		}
	}
}