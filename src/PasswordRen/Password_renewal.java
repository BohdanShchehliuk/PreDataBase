package PasswordRen;

import Data_registraited_clients.Clients;
import Data_writing.Write;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password_renewal {
    public Password_renewal(ArrayList<String> enterData) throws IOException {
        password_renewal(enterData);
    }

    public boolean password_renewal(ArrayList<String> enterData) throws IOException {
        Clients client = new Clients();
        int ren_index = 0; // якщо клієнт пройде перевірку і отримає 100 та більше балів, можна відновити/переписати пароль
        if (client.equals(null) || !client.clients.containsKey(enterData.get(1))) {
            System.out.println("Клієнта з таким логіном не існує");
            return false;
        } else if (client.clients.get(enterData.get(1)).get(2).equals(enterData.get(2))) {
            ren_index = 100;// якщо клієнт памятає свій пароль, то він одразу може його поміняти/оновити
        } else if (enterData.size() < 5) {
            System.out.println("Ви ввели замало даних");
            return false;
        }
        int size_min = enterData.size();
        if (size_min > client.clients.get(enterData.get(1)).size()) {
            size_min = client.clients.get(enterData.get(1)).size();
        }

        for (int i = 3; i < size_min - 1; i++) {

            if (client.clients.get(enterData.get(1)).get(i).equals(enterData.get(i))) {
                ren_index += 20;
            }
        }

        if (ren_index >= 100 && enterData.get(9).length() > 6 && !passwordChecking(enterData)) {
            Write write = new Write();
            write.password_renewal(enterData);
            return true;
        }

        return false;
    }

    boolean passwordChecking(ArrayList<String> enterData) {
        Pattern pattern = Pattern.compile("[0-9+!@#$%^&*+A-Z]");
        char[] arr = enterData.get(9).toCharArray();
        for (char tmp : arr) {
            Matcher matcher = pattern.matcher("" + tmp);
            if (!matcher.matches()) {
                return false;
            }
        }
        return true;
    }
}
