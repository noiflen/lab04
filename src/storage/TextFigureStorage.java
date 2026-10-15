package storage;

import geometry2d.*;
import exceptions.InvalidParameterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TextFigureStorage implements FigureStorage {

    @Override
    public List<Figure> read(Path path) throws IOException {
        List<Figure> figures = new ArrayList<>();
        BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                if (parts[0].equalsIgnoreCase("CIRCLE")) {
                    figures.add(new Circle(Double.parseDouble(parts[1])));
                } else if (parts[0].equalsIgnoreCase("RECTANGLE")) {
                    figures.add(new Rectangle(Double.parseDouble(parts[1]), Double.parseDouble(parts[2])));
                }
            }
        } catch (InvalidParameterException | NumberFormatException e) {
            throw new IOException("Ошибка формата или параметров: " + e.getMessage(), e);
        } finally {

            try {
                reader.close();
            } catch (IOException e) {
                System.err.println("Не удалось закрыть файл: " + e.getMessage());
            }
        }
        return figures;
    }

    @Override
    public void write(Path path, List<Figure> figures) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);

        try {
            for (Figure f : figures) {
                if (f instanceof Circle c) {
                    writer.write("CIRCLE " + c.getRadius());
                } else if (f instanceof Rectangle r) {
                    writer.write("RECTANGLE " + r.getWidth() + " " + r.getHeight());
                }
                writer.newLine();
            }
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.err.println("Не удалось закрыть файл для записи: " + e.getMessage());
            }
        }
    }
}