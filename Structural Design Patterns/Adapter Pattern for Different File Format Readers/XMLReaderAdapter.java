public class XMLReaderAdapter implements FileReader {
    private final XMLReader xmlReader;

    public XMLReaderAdapter(XMLReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    @Override
    public String readFile(String filePath) {
        return xmlReader.readXML(filePath);
    }
}
