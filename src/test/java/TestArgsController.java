import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import student.controller.ArgsController;
import student.model.formatters.Formats;

public class TestArgsController {
    /**
     * test that ArgsController returns the correct default values.
     * new String[]{} creates new, empty array of Strings.
     */
    @Test
    public void testDefaultValues() {
        ArgsController controller = new ArgsController(new String[]{});
        assertEquals(Formats.PRETTY, controller.getFormat());
        assertEquals(System.out, controller.getOutput());
        assertEquals("all", controller.getHostname());
    }

    /**
     * test getFormat() returns correct JSON structure.
     */
    @Test
    public void testFormatJson() {
        ArgsController controller = new ArgsController(new String[]{"-f", "json"});
        assertEquals(Formats.JSON, controller.getFormat());
    }
}
