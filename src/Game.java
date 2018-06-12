import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import java.util.Scanner;

import java.util.Map;
import java.util.HashMap;

public class Game {
  public static boolean check(int stat, int target){
    if(stat >= target){
      return true;
    }
    else{
      return false;
    }
  }

  static Player player = new Player();

  public static void main(String args[]){
    System.out.println(makeStats());
    play(0);
  }

  public static void play(int id){
    //for (int i = 0; i < 14;){

      JSONParser parser = new JSONParser();
      Scanner scan = new Scanner(System.in);
      Map <Integer, JSONObject> map = new HashMap<Integer, JSONObject>();
      //map.put(int, object)
      //map.get(int) : object

      try {
        JSONObject obj = (JSONObject) parser.parse(new FileReader("Adventure.JSON"));
        JSONObject rooms = (JSONObject) obj.get("roomArray");
        //JSONObject room = (JSONObject) obj.get("room0");
        for (int i = 0; i < 15; i++) {
          String thing = "room" + String.valueOf(i);
          //System.out.println(thing);
          map.put(i, (JSONObject) rooms.get(thing));
        }
        //System.out.println(room.get("text"));
        JSONObject current = (JSONObject) map.get(id);
        String currentText = (String) current.get("text");
        System.out.println(currentText);
        String nextIdString = scan.nextLine();
        int nextId = Integer.parseInt(nextIdString);
        //int exit = Integer.parseInt(((String) current.get("exits")));
        ArrayList<String> exitArray = new ArrayList();
        exitArray = (ArrayList<String>) current.get("exits");
        ArrayList<ArrayList<String>> checkArray = new ArrayList();
        checkArray = (ArrayList<ArrayList<String>>) current.get("checks");
        if (exitArray.size() != 0) {
          for (int i = 0; i <= exitArray.size() -1; i++) {
            if (Integer.parseInt(exitArray.get(i)) == nextId) {
              play(nextId);
            }
          }
        }
        for(ArrayList list : checkArray){
          for(int i = 0; i < 2; i++){
            if(id != 20) {
              if (Integer.parseInt((String) list.get(i)) == nextId) {
                int statC = 0;
                if (list.get(2).equals("cha")) {
                  statC = player.getCha();
                } else if (list.get(2).equals("str")) {
                  statC = player.getAtk();
                } else if (list.get(2).equals("def")) {
                  statC = player.getDef();
                } else if (list.get(2).equals("win")) {
                  if (player.argue(player.getAtk(), player.getDef(), Integer.parseInt((String) list.get(3)), Integer.parseInt((String) list.get(4)), Integer.parseInt((String) list.get(5)))) {
                    play(Integer.parseInt((String) list.get(1)));
                  } else {
                    play(Integer.parseInt((String) list.get(0)));
                  }
                }
                int targetC = Integer.parseInt((String) list.get(3));
                if (check(statC, targetC) == true) {
                  int succ = Integer.parseInt((String) (list.get(1)));
                  play(succ);
                } else {
                  int fail = Integer.parseInt((String) (list.get(0)));
                  play(fail);
                }
              }
            }
            else{
              //end program
            }
          }
        }




        System.out.println("not a valid exit");
        play(id);

        //play(nextId);
      }

      catch (FileNotFoundException e) {
        e.printStackTrace();
      }

      catch (IOException e) {
        e.printStackTrace();
      }

      catch (ParseException e) {
        e.printStackTrace();
      }


    //}
  }
  public static String makeStats(){
    player.setAtk((int) Math.ceil(Math.random() * 10));
    player.setCha((int) Math.ceil(Math.random() * 10));
    player.setDef((int) Math.ceil(Math.random() * 10));
    player.setMaxHp((int) Math.ceil(Math.random() * 10));
    //player.set
    player.setHp(player.maxHp);
    String stats = "your Attack stat is: " + player.atk + ", your Charisma stat is: " + player.cha + ", your defense stat is: " + player.def + ", your hp stat is: " + player.maxHp;
    return stats;
  }
}
