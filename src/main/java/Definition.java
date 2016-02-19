import java.util.ArrayList;
import java.time.LocalDateTime;

public class Definition {
  private static ArrayList<Definition> instances = new ArrayList<Definition>();

  private String mDescription;
  private LocalDateTime mDefinedAt;
  private int mId;

  public Definition(String description) {
    mDescription = description;
    mDefinedAt = LocalDateTime.now();
    instances.add(this);
    mId = instances.size();
  }

  public String getDescription() {
    return mDescription;
  }

  public LocalDateTime getDefinedAt() {
    return mDefinedAt.toLocalTime();
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Definition> all() {
    return instances;
  }

  public static Definition find(int id) {
    try {
    return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
    return null;
    }
  }

  public static void clear() {
    instances.clear();
  }
}
