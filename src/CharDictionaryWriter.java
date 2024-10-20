import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CharDictionaryWriter {
    private String inputFileName;
    private String outputFileName;

    CharDictionaryWriter(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    CharDictionaryWriter(String inputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = "output.txt";
    }

    public void writeDictionary() throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inputFileName));

        int data;
        StringBuilder input = new StringBuilder();

        while ((data = inputStream.read()) != -1) {
            input.append((char) data);
        }
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : input.toString().toCharArray()) {
            if (frequencyMap.containsKey(c)) {
                frequencyMap.put(c, frequencyMap.get(c) + 1);
            } else {
                if (c > 64 && c < 91 || c > 96 && c < 123) {
                    frequencyMap.put(c, 1);
                }
            }
        }

        try (FileWriter writer = new FileWriter(outputFileName)) {
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }
    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }
}
