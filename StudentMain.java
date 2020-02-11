package stream;

import message.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StudentMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String studentSurname[]={"Петр", "Василий", "Михаил", "Александр", "Илья", "Андрей", "Вячеслав", "Сергей", "Владимир", "Игорь"};
        String studentName[]={"Скрипкин", "Моисеенко", "Петров", "Иванов", "Сидоров", "Федосеев", "Нестерчук", "Борис", "Корнелаев", "Мазуркевич"};
        String studentMiddlename[]={"Иванович", "Петрович", "Николаевич", "Владимирович", "Сергеевич", "Александрович", "Вячеславович", "Игоревич", "Андреевич", "Михайлович"};

        Integer studentMark[]={1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<Student> students=new ArrayList<>();

        for (int i=0; i<9; i++) {
            for (int j=1; j<10; j++) {
                students.add(new Student(studentName[j],studentSurname[j-1], studentMiddlename[j], studentMark[10-j]));
            }
        }
        List<Student> studentsSort = new ArrayList<>();

        students.stream().
                sorted((s1,s2)->s1.getMark().compareTo(s2.getMark())).
                filter((s)->s.getMark()<=7).
                forEach(s -> studentsSort.add(s));


        FileOutputStream fileOutputStream = new FileOutputStream("file2");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(studentsSort);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("file2");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        List<Student> studentsSort2 = new ArrayList<>();
        studentsSort2 =(List<Student>) objectInputStream.readObject();
        objectInputStream.close();

            studentsSort2.remove(1);
            studentsSort2.remove(5);
            studentsSort2.remove(7);

        FileOutputStream fileOutputStream1 = new FileOutputStream("file2");
        ObjectOutputStream objectOutputStream1=new ObjectOutputStream(fileOutputStream1);
        objectOutputStream1.writeObject(studentsSort2);
        objectOutputStream1.close();


    }
}

