import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите операцию: \n" +
                    "1. Добавить продукт в корзину \n" +
                    "2. Показать текущую корзину продуктов \n" +
                    "3. Удалить выбранный товар из корзины \n" +
                    "4. Поиск по ключевому слову \n" +
                    "Для завершения программы введите end");
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }
            if (input.equals("1")) {
                System.out.println("Какой товар хотите добавить?");
                String add = scanner.nextLine();
                list.add(add);
                System.out.println("\nИтого в списке покупок: " + list.size());
            } else if (input.equals("2")) {
                if (list.isEmpty()) {
                    System.out.println("\nКорзина пока пуста, нечего выводить\n");
                    continue;
                }
                printList(list);
            } else if (input.equals("3")) {
                if (list.isEmpty()) {
                    System.out.println("\nКорзина пока пуста, нечего удалять\n");
                    continue;
                }
                System.out.println("Выберите товар из списка для удаления его из корзины: ");
                printList(list);
                String toDelete = scanner.nextLine();
                int num = 0;
                try {
                    num = Integer.parseInt(toDelete);
                } catch (NumberFormatException e) {};
                String toDeleteLower = toDelete.toLowerCase();
                System.out.println(toDeleteLower);
                for (int i = 0; i < list.size(); i++) {
                    String item = list.get(i);
                    String itemLower = item.toLowerCase();
                    if ((num - 1) == i || toDeleteLower.equals(itemLower)) {
                        list.remove(i);
                        System.out.println("Покупка " + item + " удалена из ваших покупок.");
                    }
                }
                printList(list);
            } else if (input.equals("4")) {
                System.out.println("Введите текст для поиска: ");
                String search = scanner.nextLine();
                String searchLower = search.toLowerCase();
                ArrayList<String> searchResults = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    String item = list.get(i);
                    String itemLower = item.toLowerCase();
                    if (itemLower.contains(searchLower)) {

                        searchResults.add((i+1) + ". " + item);
                    }
                }
                if (searchResults.size() == 0) {
                    System.out.println("Совпадений нет");
                } else {
                    System.out.println("Найдено:");
                    for (String s : searchResults) {
                        System.out.println(s);
                    }
                }
            } else {
                System.out.println("Введите корректное значение");
            }
        }
    }

    static void printList (List<String> list) {
        int num = 0;
        System.out.println("\nТекущий список покупок:");
        for (String s : list) {
            num++;
            System.out.println(num + ". " + s);
        }
    }
}