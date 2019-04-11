package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date(DD/MM/YYYY)");
		Date b_date = sdf.parse(sc.next());

		Client client = new Client(name, email, b_date);

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status =OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(),status,client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("Enter #"+i+" item data:");
			System.out.print("Product name: ");
			String p_name = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			
			Product product = new Product(p_name,price);
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem item = new OrderItem(quantity,price,product);
			order.addItems(item);	
		}
		
		System.out.println();
		System.out.println("Order Sumary:");
		System.out.println(order);
		System.out.println();

		sc.close();
	}

}
