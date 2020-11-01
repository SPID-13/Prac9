package CustomException;

import java.util.Comparator;
import java.util.Scanner;

public class LabClassDriver {

    public static void main (String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Практическая работа № 9.\nЗадание № 2.\n\n");
        System.out.print("Введите кол-во студентов: ");
        int N = sc.nextInt();
        int number;
        String findName = "";

        Student[] students = new Student[N];

        for (int i = 0; i < N; i++) {
            students[i] = new Student();
            System.out.print("\nВведите ID номер студента: ");
            students[i].setIDNumber(sc.nextInt());
            System.out.print("Введите ФИО студента: ");
            students[i].setName();
            System.out.print("Введите средний балл студента: ");
            students[i].setPoint(sc.nextInt());
        }

        System.out.print("\n");

        do {
            System.out.print("Что сделать со списком студентов?\n\n< 1 > Вывести список.\n< 2 > Отсортировать список по среднему баллу.\n< 3 > Найти студента в списке.\n< 0 > Выйти\n\n");
            number = sc.nextInt();
            switch (number) {

                case 1: {
                    System.out.print("\n");
                    printStudents(students);
                    System.out.print ("\nСписок выведен.\n\n");
                } break;

                case 2: {
                    selectionSort(students, Comparator.comparing(Student::getPoint));
                    System.out.print ("\nСписок отсортирован.\n\n");
                } break;

                case 3: {
                    Scanner scName = new Scanner (System.in);
                    System.out.print("\nВведите ФИО студента, которого хотите найти в списке: ");
                    System.out.print(findStudent(students, scName.nextLine()) + "\n\n");
                } break;

                case 0: break;

                default:
                    System.out.print("Неверный ввод.\n\n");
                    break;

            }

        } while (number != 0);

    }

    public static void selectionSort (Student[] students, Comparator<Student> c) {
        for (int index = 0; index < students.length; index ++) {
            for (int sub = index; sub >= 1; sub--) {
                if (c.compare(students[sub], students[sub - 1]) > 0) {
                    Student temp = students[sub];
                    students[sub] = students[sub - 1];
                    students[sub - 1] = temp;
                }
                else {
                    break;
                }
            }
        }
    }

    public static String findStudent (Student[] students, String Name) {
        int k = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getName().equals(Name)) {
                k++;
            }
        }
        if (k != 0)
            return ("Студент " + Name + " есть в списке.");
        else
           throw new StudentNotFoundException();
    }

    private static void printStudents(Student[] students) {
        int num = 1;
        for (Student student : students) {
            System.out.printf("%1d: %s;\n", num++, student);
        }
    }


}
