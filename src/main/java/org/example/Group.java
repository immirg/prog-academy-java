package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
    private String groupName;
    Student[] student = new Student[10];

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public void addStudent(Student student) throws GroupOverflowException{
        for (int i = 0; i < this.student.length; i++) {
            if (this.student[i] == null) {
                this.student[i] = student;
                return;
            }
        }
        throw new GroupOverflowException("Группа переполнена, новый студент добавлен не был");
    }
    public String getGroupName() {
        return groupName;
    }
    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (Student value : student) {
            if (value != null && value.getLastName().equals(lastName)) {
                return value;
            }
        }
        throw new StudentNotFoundException("Студент не был найден");
    }
    public boolean removeStudentByID(int id) {
        for (int i = 0; i < student.length; i++) {
            if (student[i] != null && student[i].getId() == id) {
                student[i] = null;
                return true;
            }
        }
        return false;
    }
    public Student[] sortStudentsByLastName(){
        Arrays.sort(student, Comparator.nullsLast(new StudentsLastNameComparator()));
        return student;
    }
    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", student=" + Arrays.toString(student) +
                '}';
    }
}
