import com.ksomon.progressive.goals.model.Goal;
import com.ksomon.progressive.goals.parser.GoalParser;
import com.ksomon.progressive.goals.parser.GoalsReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ParserTest {

    private File testFile;

    private final GoalParser goalParser = new GoalParser();

    private GoalsReader goalsReader;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        testFile = File.createTempFile("test", ".csv");
        writeToFile();
        testFile.deleteOnExit();
        goalsReader = new GoalsReader(testFile, goalParser);
    }

    @Test
    void testGetHeaders() throws IOException {
        Map<String, Integer> headers = goalsReader.getHeaders();

        assertEquals(2, headers.size());
        assertEquals(0, headers.get("name"));
        assertEquals(1, headers.get("amount"));
    }

    @Test
    void testGetAllGoals() throws IOException {
        List<Goal> goals = goalsReader.getAllGoals();

        assertEquals(2, goals.size());
        assertEquals("goal1", goals.get(0).getName());
        assertEquals(1, goals.get(0).getAmount());
        assertEquals("goal2", goals.get(1).getName());
        assertEquals(5, goals.get(1).getAmount());
    }

    @Test
    void testGetGoal() throws IOException {
        Map<String, Integer> headers = goalsReader.getHeaders();

        String line = "goal;12";

        Goal goal = goalsReader.getGoal(headers, line);

        assertEquals("goal", goal.getName());
        assertEquals(12, goal.getAmount());
    }

    private void writeToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
            writer.write("name;amount\ngoal1;1\ngoal2;5");
        }
    }
}
