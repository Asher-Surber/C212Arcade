package application.utils;

import application.models.Item;
import application.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileUtils {
    private static File file = new File("application/users.txt");

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
        String l;
        ArrayList<User> userList = new ArrayList<>();
        ArrayList<Item> itemList = new ArrayList<>();
        Collections.addAll(itemList, Item.values());
        do{
            l = lr.readLine();
            String[] splitStr = l.split("\\|");
            ArrayList<Item> inventory = new ArrayList<>();
            String[] itemArr = splitStr[2].split(",");
            for (int i = 0; i < 3; i++){
                for(Item j : itemList){
                    if(itemArr[i].equals(j.name())){
                        inventory.add(j);
                        break;
                    }
                }
            }
            User newUser = new User(splitStr[0], Double.parseDouble(splitStr[1]), inventory);
            userList.add(newUser);
        }
        while (!l.equals(""));

        return userList;
    }
}
