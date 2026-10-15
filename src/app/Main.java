package app;

import geometry2d.Figure;
import geometry3d.Cylinder;
import storage.BinaryFigureStorage;
import storage.FigureStorage;
import storage.TextFigureStorage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Берем аргументы командной строки или значения по умолчанию
        String in = args.length > 0 ? args[0] : "src/data/input.txt";
        String out = args.length > 1 ? args[1] : "src/data/output.bin";

        FigureStorage textStorage = new TextFigureStorage();
        FigureStorage binStorage = new BinaryFigureStorage();

        List<Figure> figures = new ArrayList<>();
        try {
            figures = textStorage.read(Paths.get(in));
        } catch (Exception e) {
            System.err.println("Не удалось прочитать файл: " + e.getMessage());
        }

        System.out.println("--- Прочитанные фигуры ---");
        if (figures.isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            for (Figure f : figures) {
                System.out.printf("%s, Параметры: %s, Площадь: %.2f, Периметр: %.2f%n",
                        f.getClass().getSimpleName(), f, f.area(), f.perimeter());
            }
        }

        // Создание цилиндра со случайным основанием
        if (!figures.isEmpty()) {
            Figure randomBase = figures.get(new Random().nextInt(figures.size()));
            System.out.println("\n--- Создание цилиндра ---");
            System.out.println("Случайное основание: " + randomBase.getClass().getSimpleName());

            Scanner scanner = new Scanner(System.in); // Аналог std::cin
            System.out.print("Введите высоту цилиндра: ");
            double height = 0;

            while (true) {
                try {
                    height = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Ошибка. Введите корректное число: ");
                }
            }

            Cylinder cylinder = new Cylinder(randomBase, height);
            System.out.println("Цилиндр: " + cylinder);
            System.out.println("Объем: " + cylinder.volume());
        } else {
            System.out.println("\nСписок пуст, создание цилиндра пропущено.");
        }

        // Сохранение в бинарный файл
        try {
            binStorage.write(Paths.get(out), figures);
            System.out.println("\nСписок успешно сохранен в: " + out);
        } catch (Exception e) {
            System.err.println("Не удалось сохранить: " + e.getMessage());
        }
    }
}