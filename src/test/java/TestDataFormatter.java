import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import student.model.DomainNameModel.DNRecord;
import student.model.formatters.DataFormatter;
import student.model.formatters.Formats;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class TestDataFormatter {

    /**
     * test prettyPrint() returns correct string.
     * test calls write() --> calls prettyPrint() --> calls prettySingle().
     * ByteArrayOutputStream: writes everything into an in-memory byte array.
     * DataFormatter.write() only requires some OutputStream — it doesn't care which kind.
     */
    @Test
    public void testPrettyPrint() {
        DNRecord record = new DNRecord("hostname.com", "0.0.0.0", "city",
                "region", "country", "00000", 0, 0);
        List<DNRecord> records = List.of(record);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataFormatter.write(records, Formats.PRETTY, baos);
        String actual = baos.toString();
        String expected = "hostname.com\n"
                + "             IP: 0.0.0.0\n"
                + "       Location: city, region, country, 00000\n"
                + "    Coordinates: 0.0, 0.0\n"
                + "\n";
        assertEquals(expected, actual);
    }

    /**
     *  Produces output structure for Jackson CSV.
     *  Because I don't yet know what Jackson's CSV output looks like.
     * @throws Exception
     */
    @Test
    public void experimentCsv() throws Exception {
        DNRecord record = new DNRecord("google.com", "0.0.0.0", "city",
                "region", "country", "00000", 0, 0);

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(DNRecord.class).withHeader();

        String result = mapper.writer(schema).writeValueAsString(record);
        System.out.println("RESULT START>>>" + result + "<<<RESULT END");
    }

    /**
     * Produces output structure for Jackson CSV for multiple records.
     * Because I don't yet know what Jackson's CSV output looks like.
     *
     * Output:
     * google.com,0.0.0.0,city,region,country,00000,0.0,0.0
     * github.com,1.1.1.1,city2,region2,country2,11111,1.0,1.0
     * @throws Exception
     */
    @Test
    public void experimentCsvMulti() throws Exception {
        DNRecord record1 = new DNRecord("google.com", "0.0.0.0", "city",
                "region", "country", "00000", 0, 0);
        DNRecord record2 = new DNRecord("github.com", "1.1.1.1", "city2",
                "region2", "country2", "11111", 1, 1);
        List<DNRecord> records = List.of(record1, record2);

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(DNRecord.class).withHeader();

        String result = mapper.writer(schema).writeValueAsString(records);
        System.out.println("RESULT START>>>" + result + "<<<RESULT END");
    }


}
