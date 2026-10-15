package storage;

import geometry2d.Figure;
import java.nio.file.Path;
import java.util.List;

public interface FigureStorage {
    List<Figure> read(Path path) throws java.io.IOException;
    void write(Path path, List<Figure> figures) throws java.io.IOException;
}