public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            char c = (char) (columnNumber % 26 + 'A');
            sb.insert(0, c);
            columnNumber /= 26;
        }
        return sb.toString();
    }
}
