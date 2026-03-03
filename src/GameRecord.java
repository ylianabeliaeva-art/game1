/*import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GameRecord {
    private static final String RECORD_FILE = "game_record.txt";
    private static long bestTime = 0;

    // Загрузить рекорд при старте игры
    public static void load() {
        try {
            if (Files.exists(Paths.get(RECORD_FILE))) {
                String content = new String(Files.readAllBytes(Paths.get(RECORD_FILE)));
                bestTime = Long.parseLong(content.trim());
            }
        } catch (Exception e) {
            bestTime = 0;
        }
    }

    // Сохранить новый рекорд
    public static void save(long newTime) {
        if (newTime > bestTime) {
            bestTime = newTime;
            try {
                Files.write(Paths.get(RECORD_FILE), String.valueOf(bestTime).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Получить текущий рекорд
    public static long getBestTime() {
        return bestTime;
    }
}*/