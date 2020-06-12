import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * User: dengin
 * Date: 24.05.2020
 */
public class Temizleme
{
    public static void main(String[] args)
    {
//        dergiparkTemizle();
        sobiadTemizle();
    }

    private static void dergiparkTemizle()
    {
        String content = "";
        try
        {
            content = new String ( Files.readAllBytes( Paths.get("D:/dergipark.txt") ) );
            content = content.replaceAll("[^0-9a-zA-Z ıiüğşöçÜİĞŞÇÖ<>,.;:!'\"+%&/()=?_#${\\[\\]}|*-@]", "");
            content = content.replaceAll("&", "&#38;");
            content = content.replaceAll("< ", "&#60; ");
            content = content.replaceAll("<1", "&#60;1");
            content = content.replaceAll("<2", "&#60;2");
            content = content.replaceAll("<3", "&#60;3");
            content = content.replaceAll("<4", "&#60;4");
            content = content.replaceAll("<5", "&#60;5");
            content = content.replaceAll("<6", "&#60;6");
            content = content.replaceAll("<7", "&#60;7");
            content = content.replaceAll("<8", "&#60;8");
            content = content.replaceAll("<9", "&#60;9");
            content = content.replaceAll("<0", "&#60;0");
            content = content.replaceAll("<A", "&#60;A");
            content = content.replaceAll("<B", "&#60;B");
            content = content.replaceAll("<C", "&#60;C");
            content = content.replaceAll("<Ç", "&#60;Ç");
            content = content.replaceAll("<D", "&#60;D");
            content = content.replaceAll("<E", "&#60;E");
            content = content.replaceAll("<F", "&#60;F");
            content = content.replaceAll("<G", "&#60;G");
            content = content.replaceAll("<Ğ", "&#60;Ğ");
            content = content.replaceAll("<H", "&#60;H");
            content = content.replaceAll("<I", "&#60;I");
            content = content.replaceAll("<İ", "&#60;İ");
            content = content.replaceAll("<J", "&#60;J");
            content = content.replaceAll("<K", "&#60;K");
            content = content.replaceAll("<L", "&#60;L");
            content = content.replaceAll("<M", "&#60;M");
            content = content.replaceAll("<N", "&#60;N");
            content = content.replaceAll("<O", "&#60;O");
            content = content.replaceAll("<Ö", "&#60;Ö");
            content = content.replaceAll("<P", "&#60;P");
            content = content.replaceAll("<R", "&#60;R");
            content = content.replaceAll("<S", "&#60;S");
            content = content.replaceAll("<Ş", "&#60;Ş");
            content = content.replaceAll("<T", "&#60;T");
            content = content.replaceAll("<U", "&#60;U");
            content = content.replaceAll("<Ü", "&#60;Ü");
            content = content.replaceAll("<V", "&#60;V");
            content = content.replaceAll("<Y", "&#60;Y");
            content = content.replaceAll("<Z", "&#60;Z");
            content = content.replaceAll("<X", "&#60;X");
            content = content.replaceAll("<Q", "&#60;Q");
            content = content.replaceAll("<W", "&#60;W");
            content = content.replaceAll("<ht", "&#60;ht");
            content = content.replaceAll("<=", "&#60;=");
            content = content.replaceAll("<w", "&#60;w");
            content = content.replaceAll("<e", "&#60;e");
            content = content.replaceAll("<me", "&#60;me");
            content = content.replaceAll("<!", "&#60;!");
            content = content.replaceAll("<\\(", "&#60;(");
            content = content.replaceAll("<\\)", "&#60;)");
            content = content.replaceAll("<>", "&#60;>");
            content = content.replaceAll("<%", "&#60;%");
            content = content.replaceAll("<&", "&#60;&");
            content = content.replaceAll("<\\|", "&#60;|");
            content = content.replaceAll("<;", "&#60;;");
            content = content.replaceAll("<:", "&#60;:");
            content = content.replaceAll("<\\+", "&#60;+");
            content = content.replaceAll("<\\*", "&#60;*");
            content = content.replaceAll("<\\.", "&#60;.");
            content = content.replaceAll("<\\,", "&#60;,");
            content = content.replaceAll("<\n" +
                    "            ", "");
            content = content.replaceAll("<\n" +
                    "            ", "");

            BufferedWriter writer = new BufferedWriter(new FileWriter("D:/dergipark2.txt"));
            writer.write(content.trim());
            writer.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void sobiadTemizle()
    {
        String content = "";
        try
        {
            content = new String ( Files.readAllBytes( Paths.get("makalelerin hepsini iceren xml formatli dosyanin adresi") ) );
            content = content.replaceAll("[^0-9a-zA-Z ıiüğşöçÜİĞŞÇÖ<>,.;:!'\"+%&/()=?_#${\\[\\]}|*-@]", "");
            content = content.replaceAll("&", "&#38;");
            content = content.replaceAll("< ", "&#60; ");
            content = content.replaceAll("<1", "&#60;1");
            content = content.replaceAll("<2", "&#60;2");
            content = content.replaceAll("<3", "&#60;3");
            content = content.replaceAll("<4", "&#60;4");
            content = content.replaceAll("<5", "&#60;5");
            content = content.replaceAll("<6", "&#60;6");
            content = content.replaceAll("<7", "&#60;7");
            content = content.replaceAll("<8", "&#60;8");
            content = content.replaceAll("<9", "&#60;9");
            content = content.replaceAll("<0", "&#60;0");
            content = content.replaceAll("<A", "&#60;A");
            content = content.replaceAll("<B", "&#60;B");
            content = content.replaceAll("<C", "&#60;C");
            content = content.replaceAll("<Ç", "&#60;Ç");
            content = content.replaceAll("<D", "&#60;D");
            content = content.replaceAll("<E", "&#60;E");
            content = content.replaceAll("<F", "&#60;F");
            content = content.replaceAll("<G", "&#60;G");
            content = content.replaceAll("<Ğ", "&#60;Ğ");
            content = content.replaceAll("<H", "&#60;H");
            content = content.replaceAll("<I", "&#60;I");
            content = content.replaceAll("<İ", "&#60;İ");
            content = content.replaceAll("<J", "&#60;J");
            content = content.replaceAll("<K", "&#60;K");
            content = content.replaceAll("<L", "&#60;L");
            content = content.replaceAll("<M", "&#60;M");
            content = content.replaceAll("<N", "&#60;N");
            content = content.replaceAll("<O", "&#60;O");
            content = content.replaceAll("<Ö", "&#60;Ö");
            content = content.replaceAll("<P", "&#60;P");
            content = content.replaceAll("<R", "&#60;R");
            content = content.replaceAll("<S", "&#60;S");
            content = content.replaceAll("<Ş", "&#60;Ş");
            content = content.replaceAll("<T", "&#60;T");
            content = content.replaceAll("<U", "&#60;U");
            content = content.replaceAll("<Ü", "&#60;Ü");
            content = content.replaceAll("<V", "&#60;V");
            content = content.replaceAll("<Y", "&#60;Y");
            content = content.replaceAll("<Z", "&#60;Z");
            content = content.replaceAll("<X", "&#60;X");
            content = content.replaceAll("<Q", "&#60;Q");
            content = content.replaceAll("<W", "&#60;W");
            content = content.replaceAll("<ht", "&#60;ht");
            content = content.replaceAll("<=", "&#60;=");
            content = content.replaceAll("<w", "&#60;w");
            content = content.replaceAll("<e", "&#60;e");
            content = content.replaceAll("<me", "&#60;me");
            content = content.replaceAll("<!", "&#60;!");
            content = content.replaceAll("<\\(", "&#60;(");
            content = content.replaceAll("<\\)", "&#60;)");
            content = content.replaceAll("<>", "&#60;>");
            content = content.replaceAll("<%", "&#60;%");
            content = content.replaceAll("<&", "&#60;&");
            content = content.replaceAll("<\\|", "&#60;|");
            content = content.replaceAll("<;", "&#60;;");
            content = content.replaceAll("<:", "&#60;:");
            content = content.replaceAll("<\\+", "&#60;+");
            content = content.replaceAll("<\\*", "&#60;*");
            content = content.replaceAll("<\\.", "&#60;.");
            content = content.replaceAll("<\\,", "&#60;,");
            content = content.replaceAll("<\n" +
                    "            ", "");
            content = content.replaceAll("<\n" +
                    "            ", "");

            BufferedWriter writer = new BufferedWriter(new FileWriter("D:/sobiad_temiz.txt"));
            writer.write(content.trim());
            writer.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
