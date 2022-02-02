package Renewal;

import Data_registraited_clients.Clients;
import Data_writing.LogWriter;
import Data_writing.Write;
import Exeption.Exept;

import java.io.IOException;
import java.util.ArrayList;

public class Renewal {
    public Renewal(ArrayList<String> enterData) throws IOException {
        renewal(enterData);
    }

    public boolean renewal(ArrayList<String> enterData) throws IOException {
        Clients client = new Clients();

        try {

            if (client.equals(null) || !client.clients.containsKey(enterData.get(1))) {
                throw new Exept("Помилка оновлення даних");

            } else if (!client.clients.get(enterData.get(1)).get(2).equals(enterData.get(2))) {
                throw new Exept("Ви ввели не вірний пароль");

            } else if (enterData.size() < 6 || enterData.get(1).equals("") || enterData.get(2).equals("") ||
                    enterData.get(3).equals("") || enterData.get(4).equals("") || enterData.get(5).equals("")) {
                throw new Exept("Ви ввели не всі НЕОБХІДНІ дані");
            }
            client.clients.put(enterData.get(1), enterData);
            Write write = new Write();
            write.rewriteClient(enterData);
            LogWriter.writeLog("For user " + enterData.get(1) + " information was obtained");

            return true;
        } catch (Exept exept) {
            exept.printStackTrace();
            LogWriter.writeLog("For user " + enterData.get(1) + " information was NOT obtained");
            return false;
        }


    }
}
