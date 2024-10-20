import java.util.Scanner;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        System.out.println("Введите имя файла:");

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        try {
            CharDictionaryWriter charDictionaryWriter = new CharDictionaryWriter(fileName);
            charDictionaryWriter.writeDictionary();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}