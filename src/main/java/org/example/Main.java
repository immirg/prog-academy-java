package org.example;

public class Main {
    public static void main(String[] args) {
        String groupName = "Group_1";
        Student student1 = new Student(11, groupName, "Daisy", "Dove", Gender.female);
        Student student2 = new Student(12, groupName, "Alice", "Amelia", Gender.female);
        Student student3 = new Student(13, groupName, "Mark", "Matthew", Gender.male);
        Student student4 = new Student(14, groupName, "James", "Joseph", Gender.male);

        Group group = new Group();
        addNewStudentToGroup(group, student1, groupName);
        addNewStudentToGroup(group, student2, groupName);
        addNewStudentToGroup(group, student3, groupName);
        addNewStudentToGroup(group, student4, groupName);

        Student[] sort = group.sortStudentsByLastName();
        for (Student student: sort) {
            System.out.println(student);
        }

        AddingNewStudentFromKeyboard newStudent = new AddingNewStudentFromKeyboard();
        Student student5 = newStudent.addNewStudentKeyboard();

        addNewStudentToGroup(group, student5, groupName);
        System.out.println(student5);

        Student student = new Student();
        System.out.println(student5.toCSVString(student5));

        Student studentFromFile = student.fromCSVString("student.csv");
        System.out.println(studentFromFile);
    }
    public static void addNewStudentToGroup(Group group, Student student, String groupName) {
        try {
            group.addStudent(student);
            group.setGroupName(groupName);
        } catch (GroupOverflowException e) {
            throw new RuntimeException(e);
        }
    }
}