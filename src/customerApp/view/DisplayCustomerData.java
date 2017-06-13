package customerApp.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import customerApp.controller.ConnectionManager;

public class DisplayCustomerData {

	ConnectionManager cm = new ConnectionManager();
	Statement stmt;
	ResultSet rs;
	
	
	public void display(String lastName){
	Connection con = cm.getConnection();
		String query = "select CustomerID, Title, FirstName, LastName, StreetAddress, ZipCode, EmailAddress from customers where LastName ='" + lastName + "'";
		try{
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while(rs.next()){
			System.out.print("Customer Number:  ");
			System.out.print(rs.getString("CustomerID"));
			System.out.println();
			System.out.print(rs.getString("Title"));
			System.out.print("  ");
			System.out.print(rs.getString("FirstName"));
			System.out.print("  ");
			System.out.print(rs.getString("LastName"));
			System.out.println();
			System.out.print(rs.getString("StreetAddress"));
			System.out.println(",");
			System.out.println(rs.getString("ZipCode"));
			System.out.println(rs.getString("EmailAddress"));
			/*System.out.print(rs.getString("StreetAddress"));
			System.out.print(rs.getString("StreetAddress"));
			System.out.print(rs.getString("StreetAddress"));*/
			System.out.println();
		}
		}catch(SQLException ec) {
			ec.printStackTrace();
		}
	}
	
	public void update(int customerID,String address, String zipCode){
		Connection con = cm.getConnection();
		String updateAddress ="UPDATE customers SET StreetAddress ='" + address + "'"+ " ZipCode ='" + zipCode + "' WHERE CustomerID ='" + customerID + "'";
			

		try (
			PreparedStatement pstmt = con.prepareStatement(updateAddress)) {
            // prepare data for update
            pstmt.setString(1, address);
            pstmt.setString(2, zipCode);
            pstmt.setInt(3, customerID);
            pstmt.executeUpdate();
            System.out.println("Updated successfully!");
	}catch(SQLException ec) {
		ec.printStackTrace();
	}
}
}
