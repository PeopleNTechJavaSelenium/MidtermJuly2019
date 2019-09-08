package json.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class JsonReaderUtil {

    /*
      ToDo:API is given, This Rest API will give you a Json Array. It is parsed partially. Your task is to give the following output.

      output:

     "mrahman@gmail.com" "Matiur Rahman" "400k" "Finance"
     "mrahman@gmail.com" "Rohan Rahman" "100k" "Engineering"
     "kafil@gmail.com" "Kafil" "200k" "Backend End Team"
     "Dave@gmail.com" "David Lenard" "140k" "Engineering"
     "rivera@gmail.com" "Rivera Dupp" "150k" "Finance"
     "Anand@gmail.com" "Anand Thakkar" "120k" "SDET"
     "sumay@gmail.com" "Sumaya Akbar" "200k" "Finance"
     "mrahman@gmail.com" "Mizanur Rahman" "400k" "Finance"
     "mrahman2@gmail.com" "Mizanur Rahman" "405k" "Finance"
     "mdtaque@gmail.com" "rifat taque" "400k" "QA"
     "mdtaque@gmail.com" "rifat taque" "400k" "QA"

     */

    public static void main(String[] args)throws MalformedURLException, IOException {
        String sURL = "http://info.venturepulse.org:8080/service-webapp/api/AllEmployeeResources";
        Employee emp = null;
        List<Employee> empList = new ArrayList<>();
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.connect();
        JsonArray  jsonArray = null;
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        if (root instanceof JsonObject) {
            JsonObject rootObj = root.getAsJsonObject();
        } else if (root instanceof JsonArray) {
            jsonArray =  root.getAsJsonArray();
        }
        for (int i = 0; i < jsonArray.size()-1; i++) {
            try {
                JsonObject jsonobject = jsonArray.get(i).getAsJsonObject();
                //you code start here
                String empEmail = jsonobject.get("empEmail").toString();
                System.out.println(empEmail);

            }catch(Exception ex){

            }
        }
        //Print to the console.
        for(Employee entry:empList){
            System.out.println(entry.getEmpEmail()+" "+entry.getEmpName()+" "+entry.getSalary()+" "+entry.getDepartment());
        }
    }

}
