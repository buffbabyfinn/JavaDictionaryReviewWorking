import java.time.LocalDateTime;

import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word myWord = new Word("Crab");
    assertEquals(true, myWord instanceof Word);
  }

  @Test
  public void Word_instantiatesWithName_Crab() {
    Word myWord = new Word("Crab");
    assertEquals("Crab", myWord.getName());
  }
}
