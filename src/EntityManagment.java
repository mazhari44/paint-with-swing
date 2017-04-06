import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntityManagment {
	

	public Connection connection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3322/paint?user=root&password=");

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;

	}

	public void addUser(User user) {
		
			try {
			PreparedStatement ps = connection().prepareStatement(
					"INSERT INTO user(username,password)" + " VALUES (?,?)");

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void deleteUser(String us) {
		try {

			PreparedStatement ps = connection().prepareStatement(
					"DELETE FROM userWHERE username like ?");

			ps.setString(1, us);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public boolean userExist(User user) {
		try {

			PreparedStatement ps = connection()
					.prepareStatement(
							"select * from user where username like ? and password like ?");

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;

	}
///////////______________ save____________////////////
	public void saveAccount(Account account) {
		
		saveLine(account);
		saveCircle(account);
		saveRectangle(account);
	}

	public void saveLine(Account account) {
		try {
			
			String username = account.getUser().getUsername();
			
			PreparedStatement ps1 = connection()
					.prepareStatement("select count(*) from line where username like ?");
			ps1.setString(1, username);
			ResultSet rs=ps1.executeQuery();
			rs.next();
			int existCount=rs.getInt(1);
			
			PreparedStatement ps = connection()
					.prepareStatement(
							"INSERT INTO line (xbegin, ybegin, xend, yend, color, username) VALUES (?,?,?,?,?,?)");
			
			int Count = account.getLineCount(), i = existCount;
			Line[] lines = account.getLines();

			while (i < Count) {

				ps.setDouble(1, lines[i].getBegine().x);
				ps.setDouble(2, lines[i].getBegine().y);
				ps.setDouble(3, lines[i].getEnd().x);
				ps.setDouble(4, lines[i].getEnd().y);
				ps.setInt(5, lines[i].getColor());
				ps.setString(6,username );
				ps.executeUpdate();
				i++;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveCircle(Account account) {

		try {
			String username = account.getUser().getUsername();
			
			PreparedStatement ps1 = connection()
					.prepareStatement("select count(*) from circle where username like ?");
			ps1.setString(1, username);
			ResultSet rs=ps1.executeQuery();
			rs.next();
			int existCount=rs.getInt(1);
			rs.close();
			ps1.close();
			
			PreparedStatement ps = connection()
					.prepareStatement(
							"INSERT INTO circle (xbegin, ybegin, xend, yend, color, username) VALUES (?,?,?,?,?,?)");
			int Count = account.getCircleCount(), i = existCount;
			Circle[] circles = account.getCircles();

			while (i < Count) {

				ps.setDouble(1, circles[i].getBegine().x);
				ps.setDouble(2, circles[i].getBegine().y);
				ps.setDouble(3, circles[i].getEnd().x);
				ps.setDouble(4, circles[i].getEnd().y);
				ps.setInt(5, circles[i].getColor());
				ps.setString(6,username);
				ps.executeUpdate();
				i++;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveRectangle(Account account) {

		try {
			String username = account.getUser().getUsername();
			
			PreparedStatement ps1 = connection()
					.prepareStatement("select count(*) from rectangle where username like ?");
			ps1.setString(1, username);
			ResultSet rs=ps1.executeQuery();
			rs.next();
			int existCount=rs.getInt(1);
			rs.close();
			ps1.close();
			
			PreparedStatement ps = connection()
					.prepareStatement(
							"INSERT INTO rectangle (xbegin, ybegin, xend, yend, color, username) VALUES (?,?,?,?,?,?)");
			int Count = account.getRectangleCount(), i = existCount;
			Rectangle[] rectangles = account.getRectangles();

			while (i < Count) {

				ps.setDouble(1, rectangles[i].getBegine().x);
				ps.setDouble(2, rectangles[i].getBegine().y);
				ps.setDouble(3, rectangles[i].getEnd().x);
				ps.setDouble(4, rectangles[i].getEnd().y);
				ps.setInt(5, rectangles[i].getColor());
				ps.setString(6, username);
				ps.executeUpdate();
				i++;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/////////////______________ load____________////////////

	public Account loadAccount(String username) {
		Account account = new Account(100);

		loadLine(account, username);
		loadCircle(account, username);
		loadRectangle(account, username);

		return account;
	}

	public void loadLine(Account account, String username) {

		try {
			Line line = new Line();
			Point point = new Point();

			PreparedStatement ps = connection().prepareStatement(
					"select * from line where username like ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				point.x = rs.getInt(1);
				point.y = rs.getInt(2);
				line.setBegine(point);				
				point.x = rs.getInt(3);
				point.y = rs.getInt(4);
				line.setEnd(point);
				line.setColor(rs.getInt(5));
				account.addLine(line);				  
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void loadCircle(Account account, String username) {
		try {
			Circle circle = new Circle();
			Point point = new Point();

			PreparedStatement ps = connection().prepareStatement(
					"select * from circle where username like ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				point.x = rs.getInt(1);
				point.y = rs.getInt(2);
				circle.setBegine(point);
				point.x = rs.getInt(3);
				point.y = rs.getInt(4);
				circle.setEnd(point);
				circle.setColor(rs.getInt(5));
				account.addCircle(circle);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void loadRectangle(Account account, String username) {
		try {
			Rectangle rectangle = new Rectangle();
			Point point = new Point();

			PreparedStatement ps = connection().prepareStatement(
					"select * from rectangle  where username like ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				point.x = rs.getInt(1);
				point.y = rs.getInt(2);
				rectangle.setBegine(point);
				point.x = rs.getInt(3);
				point.y = rs.getInt(4);
				rectangle.setEnd(point);
				rectangle.setColor(rs.getInt(5));
				account.addRectangle(rectangle);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
