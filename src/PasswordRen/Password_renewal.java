package PasswordRen;

import Data_registraited_clients.Clients;
import Data_writing.LogWriter;
import Data_writing.Write;
import Exeption.Exept;

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
        try {
            if (!client.clients.containsKey(enterData.get(1))) {
                throw new Exept("Помилка оновлення пароля. Такого користувача не існує");

            } else if (enterData.size() < 5) {
                throw new Exept("Помилка оновлення пароля. Мало даних");
            }

        } catch (Exept exept) {
            exept.printStackTrace();
            LogWriter.writeLog("For user " + enterData.get(1) + "obtain is forbiden");
            return false;
        }


        int ren_index = 0; // якщо клієнт пройде перевірку і отримає 100 та більше балів, можна відновити/переписати пароль
        int size_min = enterData.size();
        if (size_min > client.clients.get(enterData.get(1)).size()) {
            size_min = client.clients.get(enterData.get(1)).size();
        }

        for (int i = 3; i < size_min - 1; i++) {

            if (client.clients.get(enterData.get(1)).get(i).equals(enterData.get(i))) {
                ren_index += 20;
            }
        }

        try {
            if (ren_index < 100 && enterData.get(9).length() < 6 && passwordChecking(enterData)) {
                throw new Exept("Помилка оновлення пароля");

            }
            Write write = new Write();
            write.password_renewal(enterData);
            LogWriter.writeLog("For user " + enterData.get(1) + " password_renewal was successful");
            return true;
        } catch (Exept exept) {
            exept.printStackTrace();
            LogWriter.writeLog("For user " + enterData.get(1) + " password_renewal is forbidden");
            return false;
        }


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
