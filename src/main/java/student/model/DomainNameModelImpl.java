package student.model;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DomainNameModelImpl implements DomainNameModel {
    /** the list of records. */
    private List<DNRecord> records;

    /** the database file path. */
    private String database;

    /**
     * constructor to store database path & load XML file into records list.
     * @param database file path like ("data/hostrecords.xml").
     */
    public DomainNameModelImpl(String database) {
        // store file path string into database field.
        this.database = database;
        try {
            // create new XML mapper - tool that knows how to read and write XML.
            XmlMapper mapper = new XmlMapper();
            // opens file at database path as an InputStream.
            FileInputStream fis = new FileInputStream(database);
            // read XML from stream & deserialize it into a List<DNRecord>.
            // TypeReference<List<DNRecord>>(){} : tell Jackson you want back a List of DNRecords.
            // needed because Java's generics erased at runtime.
            records = mapper.readValue(fis, new TypeReference<List<DNRecord>>() {});
        } catch (Exception error) {
            records = new ArrayList<>();  // instead of crashing, start with empty list.
        }
    }

    /**
     * make sure records are immutable / unmodifiable.
     * @return records list.
     */
    @Override
    public List<DNRecord> getRecords() {
        return Collections.unmodifiableList(records);
    }

    @Override
    public DNRecord getRecord(String hostname) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
