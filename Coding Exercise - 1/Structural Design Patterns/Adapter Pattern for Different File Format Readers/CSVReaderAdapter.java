public class CSVReaderAdapter implements FileReader {
    private final CSVReader csvReader;

    public CSVReaderAdapter(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    @Override
    public String readFile(String filePath) {
        return csvReader.readCSV(filePath);
    }
}
