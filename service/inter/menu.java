package OOP_dz_sem5.service.inter;

import OOP_dz_sem5.service.data.PhoneBookEntry;

public class menu extends PhoneBookEntry {
    public static void menu() {

        System.out.println("Выберите действие: ");
        System.out.println("1. Добавить запись в телефонную книгу. ");
        System.out.println("2. Распечатать все записи телефонной книги. ");
        System.out.println("3. Поиск записи. ");
        System.out.println("4. Изменить записанную фамилию. ");
        System.out.println("5. Изменить записанный номер телефона. ");
        System.out.println("6. Выход. ");
    }
}
