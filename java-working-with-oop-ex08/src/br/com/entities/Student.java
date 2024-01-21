package br.com.entities;

public class Student {

    private String name;
    private String email;
    private int room;

    public Student(String name, String email, int room) {
        this.email = email;
        this.name = name;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
    
    
}
