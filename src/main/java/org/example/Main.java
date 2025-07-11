package org.example;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(11, "Group1", "Daisy", "Dove", Gender.female);
        Student student2 = new Student(12, "Group1", "Alice", "Amelia", Gender.female);
        Student student3 = new Student(13, "Group1", "Mark", "Matthew", Gender.male);
        Student student4 = new Student(14, "Group1", "James", "Joseph", Gender.male);

        Group group = new Group();
        String groupName = "New group";
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