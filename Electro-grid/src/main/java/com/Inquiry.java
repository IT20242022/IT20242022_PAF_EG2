package com;
import java.sql.*;
public class Inquiry
{
private Connection connect()
 {
 Connection con = null;
 try
 {
 Class.forName("com.mysql.jdbc.Driver");
 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/electrogrid", "root", "");
 }
 catch (Exception e)
 {
 e.printStackTrace();
 }
 return con;
 }
public String readInquiries()
 {
 String output = "";
 try
 {
 Connection con = connect();
 if (con == null)
 {
 return "Error while connecting to the database for reading.";
 }
 // Prepare the html table to be displayed
 output = "<table border='1'><tr><th>refNo</th><th>username</th><th>contact</th><th>email</th><th>city</th><th>date</th><th>remark</th>"+ "<th>Update</th><th>Remove</th></tr>";
 String query = "select * from inquiry";
 Statement stmt = con.createStatement();
 ResultSet rs = stmt.executeQuery(query);
 // iterate through the rows in the result set
 while (rs.next())
 {
 String id = Integer.toString(rs.getInt("id"));
 String refNo = rs.getString("refNo"); 
 String username = rs.getString("username");
 String contact = rs.getString("contact"); 
 String email = rs.getString("email");
 String city = rs.getString("city");
 String date = rs.getString("date");
 String remark = rs.getString("remark");
 // Add into the html table
output += "<tr><td><input id='hidInquiryIDUpdate' name='hidInquiryIDUpdate' type='hidden' value='" + id+ "'>" + refNo+ "</td>";
 output += "<td>" + username + "</td>";
 output += "<td>" + contact + "</td>";
 output += "<td>" + email + "</td>";
 output += "<td>" + city + "</td>";
 output += "<td>" + date + "</td>";
 output += "<td>" + remark + "</td>";
 // buttons
output += "<td><input name='btnUpdate'type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"+ "<td><input name='btnRemove' type='button' value='Remove'class='btnRemove btn btn-danger' data-id='"+ id + "'>" + "</td></tr>";
 }
 con.close();
 // Complete the html table
 output += "</table>";
 }
 catch (Exception e)
 {
 output = "Error while reading the inquries.";
 System.err.println(e.getMessage());
 }
 return output;
 }
public String insertInquiry(String refNo, String username,String contact, String email,String city,String date,String remark)
 {
 String output = "";
 try
 {
 Connection con = connect();
 if (con == null)
 {
 return "Error while connecting to the database for inserting.";
 }
 // create a prepared statement
 String query = " insert into inquiry(`id`,`refNo`,`username`,`contact`,`email`,`city`,`date`,`remark`)" + " values (?, ?, ?, ?, ?,?,?,?)";
 PreparedStatement preparedStmt = con.prepareStatement(query);
 // binding values
 preparedStmt.setInt(1, 0);
 preparedStmt.setString(2, refNo);
 preparedStmt.setString(3, username);
 preparedStmt.setString(4, contact);
 preparedStmt.setString(5, email);
 preparedStmt.setString(6, city);
 preparedStmt.setString(7, date);
 preparedStmt.setString(8, remark);
 // execute the statement
 preparedStmt.execute();
 con.close();
 String newInquiries = readInquiries();
 output = "{\"status\":\"success\", \"data\": \"" +newInquiries + "\"}";
 }
 catch (Exception e)
 {
 output = "{\"status\":\"error\", \"data\": \"Error while inserting the inquiry.\"}";
 System.err.println(e.getMessage());
 }
 return output;
 }
public String updateInquiry(String id, String refNo, String username,String contact, String email,String city,String date,String remark)
 {
 String output = "";
 try
 {
 Connection con = connect();
 if (con == null)
 {
 return "Error while connecting to the database for updating.";
 }
 // create a prepared statement
 String query = "UPDATE inquiry SET refNo=?,username=?,email=?,contact=?,city=?,date=?,remark=? WHERE id=?";
 PreparedStatement preparedStmt = con.prepareStatement(query);
 // binding values
 preparedStmt.setString(1, refNo);
 preparedStmt.setString(2, username);
 preparedStmt.setString(3, email);
 preparedStmt.setString(4, contact);
 preparedStmt.setString(5, city);
 preparedStmt.setString(6,date);
 preparedStmt.setString(7, remark);
 preparedStmt.setInt(5, Integer.parseInt(id)); 
 
 // execute the statement
 preparedStmt.execute();
 con.close();
 String newInquiries = readInquiries();
 output = "{\"status\":\"success\", \"data\": \"" + newInquiries + "\"}";
 }
 catch (Exception e)
 {
 output = "{\"status\":\"error\", \"data\":\"Error while updating the inquiry.\"}";
 System.err.println(e.getMessage());
 }
 return output;
 }
public String deleteInquiry(String id)
 {
 String output = "";
 try
 {
 Connection con = connect();
 if (con == null)
 {
 return "Error while connecting to the database for deleting.";
 }
 // create a prepared statement
 String query = "delete from inquiry where id=?";
 PreparedStatement preparedStmt = con.prepareStatement(query);
 // binding values
 preparedStmt.setInt(1, Integer.parseInt(id));
 // execute the statement
 preparedStmt.execute();
 con.close();
 String newInquiries = readInquiries();
 output = "{\"status\":\"success\", \"data\": \"" + newInquiries + "\"}";
 }
 catch (Exception e)
 {
 output = "{\"status\":\"error\", \"data\":\"Error while deleting the inquiry.\"}";
 System.err.println(e.getMessage());
 }
 return output;
 }
}