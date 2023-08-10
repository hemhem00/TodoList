package ToDo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoApp {
	private static List<ToDo> todoList = new ArrayList<>();
	private static int idCounter = 1;
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1. Add task");
			System.out.println("2. Show task");
			System.out.println("3. Delete task");
			System.out.println("4. Exit");
			System.out.println("Select an option");
				int choice = scanner.nextInt();
				scanner.nextLine();
			
			switch(choice) {
			case 1:
				System.out.println("Enter task");
				String taskName = scanner.nextLine();
				addTask(taskName);
				break;
			case 2:
				showTasks();
				break;
			case 3:
				System.out.println("Enter task ID to delete");
				int taskId = scanner.nextInt();
				deleteTask(taskId);
				break;
			case 4:
				System.out.println("Exiting...");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice.");
			}
			
		}
		
	}

	private static void addTask(String taskName) {
		todoList.add(new ToDo(idCounter ++,taskName));
		System.out.println("Task added successfully");
	
	}
	
	private static void showTasks() {
		if(todoList.isEmpty()) {
		System.out.println("No tasks found");	
		return;
		}
		System.out.println("Todo List:");
		for(ToDo todo : todoList) {
			System.out.println(todo.getId()+ ". " + todo.getTask());
		}
	}
	
	private static void deleteTask(int taskId) {
		boolean removed = todoList.removeIf(todo -> todo.getId() == taskId);
		if(removed) {
			System.out.println("Task removed successfully.");
		}else {
			System.out.println("Task not found");
		}
		
	}
	
}
