package OOP_dz_sem5.service;

import OOP_dz_sem5.service.data.PhoneBookEntry;

import java.io.IOException;
import java.util.Scanner;

public class BookController extends PhoneBookEntry {
    public void doChangeName(Scanner stdin) throws IOException {

        System.out.println("Какую фамилию вы хотите изменить? ");
        String last = stdin.next();
        int nummatches = searchNumMatches(last);

        if (nummatches == 0)
            System.out.println("Извините, нет записей, соответствующих этой фамилии. ");

        else if (nummatches == 1) {
            System.out.println("Совпала ровно одна запись: ");
            search(last);

            System.out.println("Какая новая фамилия? ");
            String newln = stdin.next();
            changeLastName(getIndex(last), newln);
        }

        else {
            System.out.println("Вот совпадающие записи: ");
            search(last);

            System.out.println("Введите номер записи, которую вы хотите изменить. ");
            int changei = stdin.nextInt();

            System.out.println("Какая новая фамилия? ");
            String newln = stdin.next();
            changeLastName(changei, newln);
        }
    }

    public void doChangeNumber(Scanner stdin) throws IOException {

        System.out.println("Какая фамилия у номера, который вы хотите изменить? ");
        String last = stdin.next();
        int nummatches = searchNumMatches(last);

        if (nummatches == 0)
            System.out.println("Извините, нет записей, соответствующих этой фамилии. ");

        else if (nummatches == 1) {
            System.out.println("Совпала ровно одна запись: ");
            search(last);

            System.out.println("Какой номер телефона? ");
            stdin.nextLine();
            String num = stdin.nextLine();
            changeNumber(getIndex(last), num);
        }

        else {
            System.out.println("Вот совпадающие записи: ");
            search(last);
            System.out.println("Введите номер записи, которую вы хотите изменить. ");
            int changeIndex = stdin.nextInt();

            System.out.println("Какой новый номер телефона? ");
            stdin.nextLine();
            String num = stdin.nextLine();
            changeNumber(changeIndex, num);
        }
    }
}
