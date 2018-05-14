import java.util.ArrayList;

public class Doctor extends Player{
  int manna;
  int maxManna;
  ArrayList<String> spells = new ArrayList();

  public int getManna() {
    return manna;
  }

  public void setManna(int manna) {
    this.manna = manna;
  }

  public int getMaxManna() {
    return maxManna;
  }

  public void setMaxManna(int maxManna) {
    this.maxManna = maxManna;
  }
}
