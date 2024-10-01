public class JSONReaderAdapter implements FileReader {
    private final JSONReader jsonReader;

    public JSONReaderAdapter(JSONReader jsonReader) {
        this.jsonReader = jsonReader;
    }

    @Override
    public String readFile(String filePath) {
        return jsonReader.readJSON(filePath);
    }
}
