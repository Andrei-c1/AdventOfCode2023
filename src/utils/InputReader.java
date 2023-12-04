package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {

    public static List<String> readInputByLine(String pathStr) {
        try {
            Path path = Paths.get(pathStr);
            return Files.lines(path)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
