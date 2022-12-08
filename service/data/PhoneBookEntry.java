package OOP_dz_sem5.service.data;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class PhoneBookEntry {

    protected ArrayList<User> book;
    private int cur_entry;

    public PhoneBookEntry() {
        book = new ArrayList(10);
        cur_entry = 0;
    }

    public boolean full() {
        return (cur_entry == 10);
    }

    public boolean add(User e) {
        if (cur_entry == 10) return false;

        book.add(cur_entry,e);
        cur_entry++;
        return true;
    }

    public void printBook() {

        System.out.println("Вот все текущие записи: ");
        for (int i=0; i<cur_entry; i++)
            System.out.println(i+". "+book.get(i));
    }

    public void search(String lastname) {

        for (int i=0; i<cur_entry; i++)
            if (book.get(i).getSecondName().equals(lastname))
                System.out.println(i+". "+book.get(i));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBookEntry that = (PhoneBookEntry) o;
        return cur_entry == that.cur_entry && Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, cur_entry);
    }

    public int searchNumMatches(String lastname) {

        int cnt = 0;
        for (int i=0; i<cur_entry; i++)
            if (book.get(i).getSecondName().equals(lastname))
                cnt++;
        return cnt;
    }

    public int getIndex(String lastname) {

        for (int i=0; i<cur_entry; i++)
            if (book.get(i).getSecondName().equals(lastname))
                return i;
        return -1;
    }

    public void changeLastName(int index, String newlastname) {
        book.get(index).rename(newlastname);
    }

    public void changeNumber(int index, String newNumber) {
        book.get(index).changeNumber(newNumber);
    }

    public static void menu() {

        System.out.println("Выберите действие: ");
        System.out.println("1. Добавить запись в телефонную книгу. ");
        System.out.println("2. Распечатать все записи телефонной книги. ");
        System.out.println("3. Поиск записи. ");
        System.out.println("4. Изменить записанную фамилию. ");
        System.out.println("5. Изменить записанный номер телефона. ");
        System.out.println("6. Выход. ");
    }

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

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        PhoneBookEntry book = new PhoneBookEntry();

        menu();
        int ans = scanner.nextInt();
        while (ans != 6) {
            if (ans == 1) {
                if (book.full())
                    System.out.print("Извините, телефонная книга заполнена, запись не может быть добавлена. ");
                else {
                    System.out.print("Введите имя, фамилию, номер телефона пользователя через пробел\n");
                    scanner.nextLine();
                    String data = scanner.nextLine();
                    String[] arr = data.split(" ");
                    User e = new User(arr[0],arr[1],arr[2]);
                    book.add(e);
                    System.out.println("Запись была добавлена. ");
                }
            }

            else if (ans == 2)
                book.printBook();

            else if (ans == 3) {
                System.out.println("Какая фамилия для вашего поиска? ");
                scanner.nextLine();
                String last = scanner.nextLine();
                if (book.searchNumMatches(last) > 0) {
                    System.out.println("Вот записи, соответствующие вашему запросу. ");
                    book.search(last);
                }
                else
                    System.out.println("Извините, по вашему запросу ничего не найдено. ");
            }

            else if (ans == 4)
                book.doChangeName(scanner);

            else if (ans == 5)
                book.doChangeNumber(scanner);

            else if (ans != 6)
                System.out.println("Извините, это неверный выбор меню.\n");

            menu();
            ans = scanner.nextInt();
        }
    }

}
