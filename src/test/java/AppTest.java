import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public ClearRule ClearRule = new ClearRule();


  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary");
  }

  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add your first word!"));
    fill("#word").with("Crab");
    submit(".btn");
    assertThat(pageSource()).contains("Your Dictionary:");
  }
  @Test
  public void WordIsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("Crab");
    submit(".btn");
    assertThat(pageSource()).contains("Crab");
  }

  @Test
  public void wordDefinitionFormIsDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("Crab");
    submit(".btn");
    click("a", withText("Crab"));
    click("a", withText("Add a/nother definition"));
    assertThat(pageSource()).contains("Add a definition to Crab");
  }

  @Test
  public void definitionIsAddedAndDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("Crab");
    submit(".btn");
    click("a", withText("Crab"));
    click("a", withText("Add a/nother definition"));
    fill("#description").with("A tasty crustacean");
    click("a", withText("Define Crab!"));
    assertThat(pageSource()).contains("A tasty crustacean");
  }
}
