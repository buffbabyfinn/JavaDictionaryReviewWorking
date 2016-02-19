import java.util.ArrayList;
import java.time.LocalDateTime;

import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("A tasty crustacean");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void getName_instantiatesWithDescription_Crab() {
    Definition myDefinition = new Definition("A tasty crustacean");
    assertEquals("A tasty crustacean", myDefinition.getDescription());
  }

  @Test
  public void getDefinedAt_instantiatesWithTime() {
    Definition myDefinition = new Definition("A tasty crustacean");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myDefinition.getDefinedAt().getDayOfWeek());
  }

  @Test
  public void getId_instantiatesWithId() {
    Definition myDefinition = new Definition("A tasty crustacean");
    assertTrue(Definition.all().size() == myDefinition.getId());
  }

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition myDefinition = new Definition("A tasty crustacean");
    Definition testDefinition = new Definition("a grump");
    assertTrue(Definition.all().contains(myDefinition));
    assertTrue(Definition.all().contains(testDefinition));
  }

  @Test
  public void clear_clearsInstancesOfDefinitions() {
    Definition myDefinition = new Definition("A tasty crustacean");
    myDefinition.clear();
    assertEquals(Definition.all().size(), 0);
  }

  @Test
  public void find_returnsDefinitionsWithSameId() {
    Definition myDefinition = new Definition("A tasty crustacean");
    Definition testDefinition = new Definition("a grump");
    assertEquals(Definition.find(testDefinition.getId()), testDefinition);
  }

  @Test
  public void find_returnsNullWhenIndexTooHigh_null() {
    Definition myDefinition = new Definition("A tasty crustacean");
    assertEquals(null, myDefinition.find(999));
  }
}
