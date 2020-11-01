package CustomException;

import java.lang.Exception;
import java.util.Scanner;

public class Ex1 {
    public static void main (String[] args) throws Exception{

        Buyer client = new Buyer();
        Scanner scName = new Scanner(System.in);
        String INN = "";

        System.out.print("Практическая работа № 9.\nЗадание № 1.\n\n");
        System.out.print("Для оформления заказа вам необходимо ввести ФИО и ИНН.\n");
        System.out.print("Введите ФИО: ");
        client.setName(scName.nextLine());
        System.out.print("Введите ИНН: ");
        client.setINN();

        System.out.print("\nФИО: " + client.getName() + ", ИНН: " + client.getINN());

    }

}
