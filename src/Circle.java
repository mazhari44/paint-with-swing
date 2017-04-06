import java.awt.Point;


public class Circle  {
	
	
	private Point begine;
	private Point end;
	private int color;
	
	public Circle() {
		begine=new Point();
		end=new Point();
		// TODO Auto-generated constructor stub
	}
	
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public Point getBegine() {
		return begine;
	}
	public void setBegine(Point begine) {
		
		this.begine.x = begine.x;
		this.begine.y = begine.y;
	}
	public Point getEnd() {
		return end;
	}
	public void setEnd(Point end) {
		this.end.x = end.x;
		this.end.y=end.y;
	}

}
