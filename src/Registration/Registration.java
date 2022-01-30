package Registration;

import Data_registraited_clients.Clients;
import Data_writing.Write;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public Registration(ArrayList<String> enterData) throws IOException {
        checkForRegistration(enterData);
    }

    public boolean checkForRegistration(ArrayList<String> enterData) throws IOException {
        Clients client = new Clients();


        if (!client.equals(null) && client.clients.containsKey(enterData.get(1))) {
            System.out.println("Користувач з таким логіном уже існує");
            return false;
        } else if (enterData.get(1).length() < 6 || passwordChecking(enterData)) {
            System.out.println("Пароль не відповідає цілям безпеки");
            return false;
        } else if (enterData.size() < 6 || enterData.get(1).equals("") || enterData.get(2).equals("") ||
                enterData.get(3).equals("") || enterData.get(4).equals("") || enterData.get(5).equals("")) {
            System.out.println("Ви ввели не всі дані");
            return false;
        } else {
            Write write = new Write();
            write.writeNewClient(enterData);
            client.clients.put(enterData.get(1), enterData);
        }
        return true;
    }

    boolean passwordChecking(ArrayList<String> enterData) {
        Pattern pattern = Pattern.compile("[0-9+!@#$%^&*+A-Z]");
        char[] arr = enterData.get(2).toCharArray();
        for (char tmp : arr) {
            Matcher matcher = pattern.matcher("" + tmp);
            if (!matcher.matches()) {
                return false;
            }
        }
        return true;
    }
}
