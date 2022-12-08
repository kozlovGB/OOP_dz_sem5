package OOP_dz_sem5.service.inter;

import OOP_dz_sem5.service.data.PhoneBookEntry;
import OOP_dz_sem5.service.data.User;

import java.io.IOException;
import java.util.Scanner;

import static OOP_dz_sem5.service.inter.menu.menu;

public class App {
    public static void ButtonClick() throws IOException {

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
