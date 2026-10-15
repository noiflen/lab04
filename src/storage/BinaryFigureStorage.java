package storage;

import geometry2d.Figure;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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
