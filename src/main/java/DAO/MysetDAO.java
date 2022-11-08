package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Contents;
import Entity.User;

public class MysetDAO {
	private final String user = "";
	private final String pass = "";
	private final String url = "jdbc:mysql://localhost/gatyasimu";
	
	public List<String> findName(User loginUser) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT name FROM myset_name WHERE user_id = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, loginUser.getId());
			ResultSet rs = stmt.executeQuery();
			List<String> mysetNames = new ArrayList<>();
			while(rs.next()) {
				mysetNames.add(rs.getString("name"));
			}
			rs.close();
			stmt.close();
			con.close();
			return mysetNames;
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Contents findContents(User loginUser, String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT name_id FROM myset_name where user_id = ? AND name = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, loginUser.getId());
			stmt.setString(2, name);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int nameId = rs.getInt("name_id");
			rs.close();
			stmt.close();
			
			sql = "SELECT rarity, probability FROM myset_contents WHERE name_id = ?;";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, nameId);
			rs= stmt.executeQuery();
			Contents contents = new Contents();
			while(rs.next()) {
				contents.setRarity(rs.getString("rarity"));
				contents.setProbability(rs.getDouble("probability"));
			}
			rs.close();
			stmt.close();
			con.close();
			return contents;
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void registerMyset(User loginUser, String name, Contents contents) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			con.setAutoCommit(false);
			try {
				String sql = "INSERT INTO myset_name(user_id, name) VALUES(?, ?);";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, loginUser.getId());
				stmt.setString(2, name);
				stmt.executeUpdate();
				stmt.close();
				
				sql = "SELECT name_id FROM myset_name where user_id = ? AND name = ?;";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, loginUser.getId());
				stmt.setString(2, name);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				int nameId = rs.getInt("name_id");
				rs.close();
				stmt.close();
				
				sql = "INSERT INTO myset_contents(name_id, rarity, probability) VALUES(?, ?, ?);";
				stmt = con.prepareStatement(sql);
				for(int i = 0; i < contents.getRarity().size(); i++) {
					stmt.setInt(1, nameId);
					stmt.setString(2, contents.getRarity().get(i));
					stmt.setDouble(3, contents.getProbability().get(i));
					stmt.executeUpdate();
				}
				
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
	
	public void deleteMyset(User loginUser, String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT name_id FROM myset_name where user_id = ? AND name = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, loginUser.getId());
			stmt.setString(2, name);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int nameId = rs.getInt("name_id");
			rs.close();
			stmt.close();
			
			sql = "DELETE FROM myset_contents WHERE name_id = ?;";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, nameId);
			stmt.executeUpdate();
			stmt.close();
			
			sql = "DELETE FROM myset_name WHERE name_id = ?;";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, nameId);
			stmt.executeUpdate();
			stmt.close();
			
			con.close();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}