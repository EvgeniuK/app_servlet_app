package model;

public class User {
    String names;
    int id;

    public User(String names, int id) {
        this.names = names;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "names='" + names + '\'' +
                ", id=" + id +
                '}';
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
