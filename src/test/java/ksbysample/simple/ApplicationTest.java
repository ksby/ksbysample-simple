package ksbysample.simple;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ApplicationTest {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testCommandLineOverrides() throws Exception {
        // 標準のPort番号(8080)以外で起動して、"Started Application" のメッセージが出力されるかテストする
        Application.main(new String[] {"--server.port=8081"});
        String output = this.outputCapture.toString();
        assertTrue(output, output.contains("Started Application"));
        // Exceptionが出力されていないかテストする
        assertFalse(output, output.contains("Exception"));
    }

}
