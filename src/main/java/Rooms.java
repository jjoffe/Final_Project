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

public class Rooms {

    Double id;
    ArrayList<Double> exits;
    ArrayList<String> objects;
    String text;

    public Rooms(){

    }

    public static void main(String args[]){
        Read();
    }

    public static void Write() {

        JSONObject obj = new JSONObject();
        obj.put("name", "Anna");
        obj.put("age", new Integer(100));

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

        try {
            FileWriter file = new FileWriter("Adventure.JSON");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        }

        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);
    }

    public static void Read(){

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("Adventure.JSON"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            String name = (String) jsonObject.get("name");
            System.out.println(name);

            long age = (Long) jsonObject.get("age");
            System.out.println(age);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

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
    }


}
