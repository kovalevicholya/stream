package stream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private String name;
    private String surname;
    private String middlename;
    private Integer mark;

    public Student(String name, String surname, String middlename, Integer mark) {
        this.name=name;
        this.surname=surname;
        this.middlename=middlename;
        this.mark=mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname=surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename=middlename;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark=mark;
    }

    @Override
    public String toString() {
        return "Student{"+
                "name='"+name+'\''+
                ", surname='"+surname+'\''+
                ", middlename='"+middlename+'\''+
                ", mark="+mark+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student=(Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(middlename, student.middlename) &&
                Objects.equals(mark, student.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, middlename, mark);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(name);
        out.writeObject(surname);
        out.writeObject(middlename);
        out.writeInt(mark);


    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        name=(String) in.readObject();
        surname=(String) in.readObject();
        middlename=(String) in.readObject();
        mark=in.readInt();

    }
}
