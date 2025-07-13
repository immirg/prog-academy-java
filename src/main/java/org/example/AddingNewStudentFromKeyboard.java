package org.example;
import java.util.Scanner;

public class AddingNewStudentFromKeyboard {
    public Student addNewStudentKeyboard() {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите id: ");
        int id = console.nextInt();
        console.nextLine();
        System.out.println("Введите groupName: ");
        String groupName = console.nextLine();
        System.out.println("Введите name: ");
        String name = console.nextLine();
        System.out.println("Введите lastName: ");
        String lastName = console.nextLine();

        Gender gender;
        while (true) {
            System.out.println("Введите gender female or male: ");
            String studentGander = (console.nextLine());

            if (studentGander.equals("male")) {
                gender = Gender.male;
                break;
            }
            if (studentGander.equals("female")) {
                gender = Gender.female;
                break;
            } else {
                System.out.println("Введен некоррекный gender");
            }
        }
        return new Student(id, groupName, name, lastName, gender);
    }
}
