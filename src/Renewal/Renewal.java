package Renewal;

import Data_registraited_clients.Clients;
import Data_writing.Write;

import java.io.IOException;
import java.util.ArrayList;

public class Renewal {
    public Renewal(ArrayList<String> enterData) throws IOException {
        renewal(enterData);
    }

    public boolean renewal(ArrayList<String> enterData) throws IOException {
        Clients client = new Clients();
        if (client.equals(null) || !client.clients.containsKey(enterData.get(1))) {
            System.out.println("Клієнта з таким логіном не існує");
            return false;
        } else if (!client.clients.get(enterData.get(1)).get(2).equals(enterData.get(2))) {
            System.out.println("Ви ввели не вірний пароль");
            return false;
        } else if (enterData.size() < 6 || enterData.get(1).equals("") || enterData.get(2).equals("") ||
                enterData.get(3).equals("") || enterData.get(4).equals("") || enterData.get(5).equals("")) {
            System.out.println("Ви ввели не всі дані");
        } else {
            System.out.println("Вітаємо, ви оновили інформацію");
            client.clients.put(enterData.get(1), enterData);
            Write write = new Write();
            write.rewriteClient(enterData);
        }
        return false;
    }
}
