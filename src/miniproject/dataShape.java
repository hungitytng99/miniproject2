package miniproject;

public class dataShape {
	private double x = 0;
	private double y = 0;
	private int num = 0;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public dataShape(double x,double y,int num)
	{
		this.x = x;
		this.y = y;
		this.num = num;
	}
}
