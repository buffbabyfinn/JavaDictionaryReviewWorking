import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> instances = new ArrayList<Word>();

  private ArrayList<Definition> mDefinitions;
  private String mName;
  private int mId;

  public Word(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public int getId() {
    return mId;
  }

  public String getName(){
    return mName;
  }

  public static ArrayList<Word> all(){
    return instances;
  }

  public static Word find(int id) {
    try {
    return instances.get(id-1);
    } catch (IndexOutOfBoundsException e) {
    return null;
    }
  }

  public static void clear() {
    instances.clear();
  }

  public void addDefinition(Definition definition) {
    mDefinitions.add(definition);
  }

  public ArrayList<Definition> getDefinition() {
    return mDefinitions;
  }
}
