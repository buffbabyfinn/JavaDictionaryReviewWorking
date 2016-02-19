import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> instances = new ArrayList<Word>();

  private String mName;
  private int mId;

  public Word(String name) {
    mName = name;
    mId = instances.size();
  }

  public int getId() {
    return mId;
  }

  public String getName(){
    return mName;
  }

}
