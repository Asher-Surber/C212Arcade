package application.utils;

import application.models.Item;
import application.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileUtils {
    private static final File file = new File("C:\\Users\\Asher\\C212FinalRepo\\C212FinalProjectArcade\\src\\application\\users.txt");

    // line format:
    // user_name|balance|item1,item2,item3
    // user name not allowed to contain pipe

    /**
     * Write user data to the file you provided above.
     *
     * @param users The total list of all users
     */
    public static void writeUserDataToFile(List<User> users) throws IOException {
        FileWriter w = new FileWriter(file);
        for (User user : users) {
            w.write(user.toString() + "\n");
        }
        w.close();
    }

    /**
     * Read user data from the file you provided above. Return a list of Users
     */
    public static List<User> getUserDataFromFile() throws IOException {
        FileReader fr = new FileReader(file);
        LineNumberReader lr = new LineNumberReader(fr);
        String l = "";
        ArrayList<User> userList = new ArrayList<>();
        ArrayList<Item> itemList = new ArrayList<>();
        Collections.addAll(itemList, Item.values());
        do{
            l = lr.readLine();
            String[] splitStr = l.split("\\|", -1);
            ArrayList<Item> inventory = new ArrayList<>();
            if(splitStr.length == 3){
                String[] itemArr = splitStr[2].split(",");
                List<String> il = Arrays.asList(itemArr);
                switch(il.size()) {
                    case 1:
                        for (Item j : itemList) {
                            if (il.get(0).equals(j.name())) {
                                inventory.add(j);
                                break;
                            }
                        }
                        break;
                    case 2:
                    case 3:
                        for (String str : il) {
                            for (Item j : itemList) {
                                if (il.get(il.indexOf(str)).equals(j.name())) {
                                    inventory.add(j);
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
//            for(String i : splitStr){
//                System.out.println(i);
//            }
            //System.out.println(splitStr.length);
            User newUser = new User(splitStr[0], Double.parseDouble(splitStr[1]), inventory);
            userList.add(newUser);
        }
        while (lr.ready());

        return userList;
    }
}
