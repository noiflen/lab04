package storage;

import geometry2d.Figure;
import geometry2d.Circle;
import geometry2d.Rectangle;
import exceptions.InvalidParameterException;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class BinaryFigureStorage implements FigureStorage {
@Override
    @SuppressWarnings("unchecked")
    public List<Figure> read(Path path) throws IOException {
        ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path));
        try {
            return (List<Figure>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Ошибка десериализации", e);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                System.err.println("Не удалось закрыть поток: " + e.getMessage());
            }
        }
    }

    @Override
    public void write(Path path, List<Figure> figures) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path));
        try {
            out.writeObject(figures);
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                System.err.println("Не удалось закрыть поток записи: " + e.getMessage());
            }
        }
    }
}
