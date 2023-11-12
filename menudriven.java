package com.menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class menudriven {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/menudb","root","root");
			boolean repeat=true;
			do {
				System.out.println("_____________________________Welcome to Taj Hotel_________________________");
				System.out.println("1:AddMenu\n2:DeleteMenu\n3:UpdateMenu\n4Dispaly\n5.exit");
				System.out.println("Enter your choice");
				int ch=sc.nextInt();
				switch(ch) {
				case 1:
				{
					PreparedStatement preparedStatement= connection.prepareStatement("insert into menudriven values(?,?,?,?,?)");
					System.out.println("Enter the id");
					preparedStatement.setInt(1,sc.nextInt());
					System.out.println("Enter the item name");
					preparedStatement.setString(2,sc.next());
					System.out.println("Enter the type of item");
					preparedStatement.setString(3,sc.next());
					System.out.println("Enter the rating");
					preparedStatement.setString(4,sc.next());
					System.out.println("Enter the price");
					preparedStatement.setDouble(5,sc.nextDouble());
	                preparedStatement.execute();
	                System.out.println("Menu added succesfully");
				}
				break;
				case 2:{
					PreparedStatement preparedStatement = connection.prepareStatement("delete from menudriven where id=? ");
					System.out.println("Enter the menu ID ");
					preparedStatement.setInt(1, sc.nextInt());
					System.out.println("Menu Deleted Successfully");
				}
				break;
				case 3:{
					PreparedStatement preparedStatement = connection.prepareStatement("update from menudriven set name=?");
					System.out.println("Enter the menu name ");
					preparedStatement.setString(1, sc.next());
					System.out.println("Menu Updated Successfully");
				}
				break;
				case 4:{
					PreparedStatement preparedStatement = connection.prepareStatement("select * from menudriven");
					System.out.println("Menu Successfully Displayed");
				}
				break;
				case 5:
				{
					repeat=false;
					System.out.println("Thank you");
				}
				break;
				default:
				    System.out.println("Invalid choice");
				    break;
					}
			}while(repeat);
			connection.close();

		} catch (ClassNotFoundException | SQLException e)
		{
          
			e.printStackTrace();
		}
}
}
