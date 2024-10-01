import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of file to read (xml, json, csv):");
        String fileType = scanner.nextLine();

        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        FileReader fileReader = null;

    
        switch (fileType.toLowerCase()) {
            case "xml":
                fileReader = new XMLReaderAdapter(new XMLReader());
                break;
            case "json":
                fileReader = new JSONReaderAdapter(new JSONReader());
                break;
            case "csv":
                fileReader = new CSVReaderAdapter(new CSVReader());
                break;
            default:
                System.out.println("Unsupported file type!");
                break;
        }

        if (fileReader != null) {
            System.out.println(fileReader.readFile(filePath));
        }

        scanner.close();
    }
}
