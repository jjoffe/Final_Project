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

  public static void main(String args[]){
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
        for(ArrayList list : checkArray){
          for(int i = 0; i < 2; i++){
            if (Integer.parseInt((String)list.get(i)) == nextId){
              
            }
          }
        }
        for (int i = 0; i <= exitArray.size(); i++) {
          if (Integer.parseInt(exitArray.get(i)) == nextId) {
            play(nextId);
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
}
