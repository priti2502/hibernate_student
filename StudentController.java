package hibernate_student.controller;

import java.util.Scanner;

import hibernate_student.dao.StudentDao;
import hibernate_student.dto.Student;

public class StudentController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your choice \n1.Save Student \n2.Fetch Student \n3.Update Student \n4.Delete Student "
				+ "\n5.GetAllStudent \n6.GetStudentByPhone \n7.GetStudentByEmail");
		Student student = new Student();
		StudentDao dao = new StudentDao();
		int choice = scanner.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("Enter your id");
			int id = scanner.nextInt();
			System.out.println("Enter your name");
			String name = scanner.next();
			System.out.println("Enter your marks");
			int marks = scanner.nextInt();
			System.out.println("Enter your phone");
			long phone = scanner.nextLong();
			System.out.println("Enter your address");
			String address = scanner.next();
			System.out.println("Enter your email");
			String email = scanner.next();
			student.setId(id);
			student.setName(name);
			student.setMarks(marks);
			student.setAddress(address);
			student.setPhone(phone);
			student.setEmail(email);
			dao.saveStudent(student);
			break;
		}

		case 2: {
			System.out.println("Enter your id");
			int id = scanner.nextInt();

			dao.getStudent(id);
			break;
		}

		case 3: {
			System.out.println("Enter your id");
			int id = scanner.nextInt();
			System.out.println("Enter your name");
			String name = scanner.next();
			System.out.println("Enter your marks");
			int marks = scanner.nextInt();
			System.out.println("Enter your phone");
			long phone = scanner.nextLong();
			System.out.println("Enter your address");
			String address = scanner.next();
			System.out.println("Enter your email");
			String email = scanner.next();
			student.setId(id);
			student.setName(name);
			student.setMarks(marks);
			student.setAddress(address);
			student.setPhone(phone);
			student.setEmail(email);

			dao.updateStudent(student);
			break;
		}
		case 4: {
			System.out.println("Enter your id");
			int id = scanner.nextInt();

			dao.deleteStudent(id);
			break;

		}
		case 5: {
			dao.getAllStudent();
			break;

		}
		case 6: {
			System.out.println("enter phone");
			long phone = scanner.nextLong();
			dao.getStudent(phone);
			break;

		}
		case 7: {
			System.out.println("enter email");
			String email = scanner.next();
			dao.getStudent(email);
			break;

		}
		default: {
			System.out.println("wrong choice");
		}
		}
	}
}
