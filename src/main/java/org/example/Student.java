package org.example;

public class Student extends Human{
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
    public String toString() {
        return "Student{" + "id=" + id + ", groupName='" + groupName + '\'' + ", lastName=" + getLastName() + ", name="
                + getName() + ", gender=" + getGender() + '}';
    }
}