import java.io.*;
import java.util.ArrayList;

public class ReadFile {
    public static String[] readLines(String filePath) {
        ArrayList<String> list = new ArrayList<>();

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (!line.isEmpty()) {
                    String[] parts = line.split("\\|");

                    if (parts.length >= 2) {
                        String category = parts[0].trim();
                        String product = parts[1].trim();
                        list.add(category + "|" + product);
                    }
                }
            }
            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return list.toArray(new String[0]);
    }
}