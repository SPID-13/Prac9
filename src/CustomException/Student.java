package CustomException;

import java.util.Comparator;
import java.util.Scanner;

public class Student implements Comparable<Student> {
    private int IDNumber;
    private String Name;
    private int Point;

    public Student(int IDNumber, String Name, int Point) {
        this.IDNumber = IDNumber;
        this.Name = Name;
        this.Point = Point;
    }

    public Student () {
        this.IDNumber = 0;
        this.Name = "";
        this.Point = 0;
    }

    public int getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber (int idNumber) {
        this.IDNumber = idNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName() throws EmptyStringException{
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        if (name.trim().length() != 0)
            Name = name;
        else
            throw new EmptyStringException();
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int point) {
        this.Point = point;
    }

    public String toString() {
        return ("< " + IDNumber + " > " + Name + " - " + Point);
    }

    @Override
    public int compareTo(Student o) {
        return (this.Name.compareTo(o.Name));
    }
}
