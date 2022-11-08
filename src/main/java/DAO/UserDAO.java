package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.User;

public class UserDAO {
	private final String user = "root";
	private final String pass = "2434";
	private final String url = "jdbc:mysql://localhost/gatyasimu";
	
	public User findUser(String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT user_id, name, password FROM users WHERE name = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			User user = new User(rs.getInt("user_id"), rs.getString("name"), rs.getString("password"));
			rs.close();
			stmt.close();
			con.close();
			return user;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void registerUser(String name, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			con.setAutoCommit(false);
			try {
				String sql = "INSERT INTO users(name, password) VALUES(?, ?);";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, name);
				stmt.setString(2, password);
				stmt.executeUpdate();
				con.commit();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				con.rollback();
				e.printStackTrace();
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}