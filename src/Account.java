
public class Account {
	private User user;
	private Line[] lines;
	private int lineCount;
	private Circle[] circles;
	private int circleCount;
	private Rectangle[] rectangles;
	private int rectangleCount;
	
	public Account(int maxCount) {
		//TODO Auto-generated constructor stub
		this.rectangleCount=0;
		this.circleCount=0;
		this.lineCount=0;
         user=new User();
		lines=new Line[maxCount];
		circles=new Circle[maxCount];
		rectangles=new Rectangle[maxCount];
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user.setPassword(user.getPassword()); 
		this.user.setUsername(user.getUsername());
	}
	public Line[] getLines() {
		return lines;
	}

	public int getLineCount() {
		return lineCount;
	}

	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}

	public int getCircleCount() {
		return circleCount;
	}

	public void setCircleCount(int circleCount) {
		this.circleCount = circleCount;
	}

	public int getRectangleCount() {
		return rectangleCount;
	}

	public void setRectangleCount(int rectangleCount) {
		this.rectangleCount = rectangleCount;
	}

	public Circle[] getCircles() {
		return circles;
	}

	public Rectangle[] getRectangles() {
		return rectangles;
	}
	
	public void addLine(Line line)
	{
		lines[lineCount]=new Line();
		
		lines[lineCount].setBegine(line.getBegine());
		lines[lineCount].setEnd(line.getEnd());
		lines[lineCount].setColor(line.getColor());
				lineCount++;
	}
	public void addCircle(Circle circle)
	{
		circles[circleCount]=new Circle();
		circles[circleCount].setBegine(circle.getBegine());
		circles[circleCount].setEnd(circle.getEnd());
		circles[circleCount].setColor(circle.getColor());
		circleCount++;
	}
	public void addRectangle(Rectangle rectangle)
	{
		rectangles[rectangleCount]=new Rectangle(); 
		rectangles[rectangleCount].setBegine(rectangle.getBegine());
		rectangles[rectangleCount].setEnd(rectangle.getEnd());
		rectangles[rectangleCount].setColor(rectangle.getColor());
		rectangleCount++;
	}
	
}
