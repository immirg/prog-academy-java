package org.example;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Human implements CSVConvert{
    private int id;
    private String groupName;

    public void setId(int id) {
        this.id = id;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public int getId() {
        return id;
    }
    public String getGroupName() {
        return groupName;
    }
    public Student() {
    }
    public Student(int id, String groupName, String name, String lastName, Gender gender) {
        super(name, lastName, gender);
        this.id = id;
        this.groupName = groupName;
    }
    @Override
    public String toCSVString(Student student) {
        String studentData = String.format("%d,%s,%s,%s,%s", student.getId(), student.getGroupName(), student.getName(), student.getLastName(), student.getGender());
        File file = new File("student.csv");
        String fields = "id,groupName,name,lastName,gender";

        try (PrintWriter pw = new PrintWriter(file)){
            pw.println(fields);
            pw.println(studentData);
            return "Данные студента добавлены в файл student.csv";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Студент добавлен не был";
    }
    @Override
    public Student fromCSVString(String str) {
        Student student = new Student();
        try (Scanner sc = new Scanner(new File(str))) {
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] st = line.split(",");

                student.setId(Integer.parseInt(st[0]));
                student.setGroupName(st[1]);
                student.setName(st[2]);
                student.setLastName(st[3]);
                student.setGender(Gender.valueOf(st[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return student;
    }
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", groupName='" + groupName + '\'' + ", lastName=" + getLastName() + ", name="
                + getName() + ", gender=" + getGender() + '}';
    }
}