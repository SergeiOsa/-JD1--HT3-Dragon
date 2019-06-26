package by.oskerko.layer_architect.dragon_treasure.view;

import java.util.Scanner;

import by.oskerko.layer_architect.dragon_treasure.controller.Controller;

public class View {

	public void menu() {
		
		String request = "";
		String response = "";
		Controller controller = new Controller();
		
		System.out.println("Что нужно?");
		System.out.println("Введи 1, если хочешь увидеть все сокровища");
		System.out.println("Введи 2, если хочешь увидеть самое дорогое сокровище");
		System.out.println("Введи 3, если хочешь узнать какие сокровища есть на заданную сумму");
		System.out.println("Введи 4, если хочешь добавить новое сокровище");
		System.out.println("Введи 5, если хочешь удалить сокровище");
		System.out.println("Жми что-нибудь");

		int choice = 0;

		Scanner sc = new Scanner(System.in);
		
		do {
			
			while (!sc.hasNextInt()) {
				System.out.println("Нужен int");
				sc.nextLine();
			}
			
			choice = sc.nextInt();
			
			if (choice < 1 || choice > 5) {
				System.out.println("Жми 1, 2, 3, 4 или 5!!!!!");
			}
			
		} while (choice < 1 || choice > 5);
		
		if(choice == 1) {
			request = "see_all_treasures";
			response = controller.doAction(request);
			System.out.println(response);
		}
		
		if(choice == 2) {
			request = "most_expensive_treasure";
			response = controller.doAction(request);
			System.out.println(response);
		}
		
		if(choice == 3) {
			int sum;
			System.out.println("Введите макс сумму");
			while (!sc.hasNextInt()) {
				System.out.println("Нужен int");
				sc.nextLine();
			}
			sum = sc.nextInt();
			
			request = "selection_treasure  " + sum;
			response = controller.doAction(request);
			System.out.println(response);
		}
		
		if(choice == 4) {
			int id;
			String name;
			int price;
			
			System.out.println("Введите id сокровища");
			while (!sc.hasNextInt()) {
				System.out.println("Нужен int");
				sc.nextLine();
			}
			id = sc.nextInt();
			
			System.out.println("Введите имя сокровища");
			name = sc.next();
			
			System.out.println("Введите цену сокровища");
			while (!sc.hasNextInt()) {
				System.out.println("Нужен int");
				sc.nextLine();
			}
			price = sc.nextInt();
			
			request = "save_treasure  " + id + "  " + name + "  " + price;
			response = controller.doAction(request);
			System.out.println(response);
		}
		
		if(choice == 5) {
			int id;
			String name;
			int price;
			
			System.out.println("Введите id сокровища");
			while (!sc.hasNextInt()) {
				System.out.println("Нужен int");
				sc.nextLine();
			}
			id = sc.nextInt();
			
			System.out.println("Введите имя сокровища");
			name = sc.next();
			
			System.out.println("Введите цену сокровища");
			while (!sc.hasNextInt()) {
				System.out.println("Нужен int");
				sc.nextLine();
			}
			price = sc.nextInt();
			
			request = "remove_treasure  " + id + "  " + name + "  " + price;
			response = controller.doAction(request);
			System.out.println(response);
		}
				
	}

}
