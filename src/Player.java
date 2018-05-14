import java.util.ArrayList;

public class Player {

  int def;
  int atk;
  int hp;
  int maxHp;
  int cha;
  int type;
  ArrayList<String> inventory = new ArrayList();

  public int getDef() {
    return def;
  }

  public void setDef(int def) {
    this.def = def;
  }

  public int getAtk() {
    return atk;
  }

  public void setAtk(int atk) {
    this.atk = atk;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public int getMaxHp() {
    return maxHp;
  }

  public void setMaxHp(int maxHp) {
    this.maxHp = maxHp;
  }

  public int getCha() {
    return cha;
  }

  public void setCha(int cha) {
    this.cha = cha;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public boolean argue (int fAtk, int fDef, int uHp, int uAtk, int uDef){ // returns true if enemy dead, returns false if not
    boolean current = true;
    if (uAtk > fDef) {
      hp -= uAtk - fDef;
      if (hp <= 0) {
        current = false;
      } else {
        current = true;
      }
    }
    if (fAtk > uDef){
      uHp -= fAtk - uDef;
      if (uHp <= 0){
        current = true;
      } else{
        current = false;
      }
    }
    return current;
  }
}
