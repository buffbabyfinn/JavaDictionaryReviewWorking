import java.util.ArrayList;

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
  public void getName_instantiatesWithName_Crab() {
    Word myWord = new Word("Crab");
    assertEquals("Crab", myWord.getName());
  }

  @Test
  public void getId_instantiatesWithId() {
    Word myWord = new Word("Crab");
    assertTrue(Word.all().size() == myWord.getId());
  }

  @Test
  public void getDefinition_initiallyReturnsEmptyArrayList() {
    Word myWord = new Word("Crab");
    assertTrue(myWord.getDefinition() instanceof ArrayList);
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("Crab");
    Word secondWord = new Word("Fart");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void clear_clearsInstancesOfWords() {
    Word myWord = new Word("Crab");
    myWord.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
  public void find_returnsWordsWithSameId() {
    Word myWord = new Word("Home");
    Word testWord = new Word("Crab");
    assertEquals(Word.find(testWord.getId()), testWord);
  }

  @Test
  public void find_returndNullWhenIndexTooHigh_null() {
    Word myWord = new Word("Crab");
    assertEquals(null, myWord.find(999));
  }

  @Test
  public void addDefinition_addsDefinitionToWord() {
    Word myWord = new Word("Crab");
    Definition myDefinition = new Definition("A tasty crustacean");
    myWord.addDefinition(myDefinition);
    assertTrue(myWord.getDefinition().contains(myDefinition));
  }
}
