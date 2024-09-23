import net.sourceforge.plantuml.SourceStringReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PlantUMLNewParser {
    public static void main(String[] args) {
        // Указываем путь к файлу PlantUML
        String inputFilePath = "C:\\Users\\ABarkhatov\\Downloads\\documents_search_sequence-browserRequest.puml";
        // Чтение PlantUML из файла
        StringBuilder sourceBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Фильтрация строк
                if (!line.startsWith("@") && !line.contains("activate") && !line.contains("deactivate")) {
                    sourceBuilder.append(line.trim()).append("\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            return;
        }

        String source = sourceBuilder.toString();
        // Генерация текстового представления и вывод в консоль
        System.out.println("Текстовое представление диаграммы:\n" + source);
    }
}