package Data_writing;

import Data_registraited_clients.Clients;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Write {

    public void writeNewClient(ArrayList<String> enterData) throws IOException {

        String clientNew = "C:\\Users\\User\\Desktop\\PreDataBase\\src\\Data_registraited_clients\\"
                + enterData.get(1) + ".txt";
        FileWriter fileWriter = new FileWriter(clientNew);
        BufferedWriter bw = new BufferedWriter(fileWriter);

        bw.flush();
        for (int i = 0; i < enterData.size(); i++) {
            String row = enterData.get(i);
            bw.write("" + row);
            bw.newLine();
        }
        bw.close();

        System.out.println("Вітаємо, реєстрація пройшла успішно. " +
                "Ваш логін: " + enterData.get(1) + " . Ваш пароль: " + enterData.get(2) + "\n");
    }

    public void rewriteClient(ArrayList<String> enterData) throws IOException {

        String clientNew = "C:\\Users\\User\\Desktop\\PreDataBase\\src\\Data_registraited_clients\\"
                + enterData.get(1) + ".txt";
        FileWriter fileWriter = new FileWriter(clientNew);
        BufferedWriter bw = new BufferedWriter(fileWriter);

        bw.flush();
        for (int i = 0; i < enterData.size(); i++) {
            String row = enterData.get(i);
            bw.write("" + row);
            bw.newLine();
        }
        bw.close();

        System.out.println("Вітаємо, ваші дані перезаписані. " +
                "Ваш логін: " + enterData.get(1) + " . Ваш пароль: " + enterData.get(2) + "\n");
    }

    public void password_renewal(ArrayList<String> enterData) throws IOException {
        enterData.set(2, enterData.get(9));
        enterData.remove(9);
        Clients client = new Clients();
        client.clients.put(enterData.get(1), enterData);
        String clientNew = "C:\\Users\\User\\Desktop\\PreDataBase\\src\\Data_registraited_clients\\"
                + enterData.get(1) + ".txt";
        FileWriter fileWriter = new FileWriter(clientNew);
        BufferedWriter bw = new BufferedWriter(fileWriter);

        bw.flush();
        for (int i = 0; i < enterData.size(); i++) {
            String row = enterData.get(i);
            bw.write("" + row);
            bw.newLine();
        }
        bw.close();

        System.out.println("Вітаємо, Ваш пароль оновлено" +
                "Ваш логін: " + enterData.get(1) + " . Ваш новий пароль: " + enterData.get(2) + "\n");
    }

    public void get_info(ArrayList<String> enterData) throws IOException {
        String clientNew = "C:\\Users\\User\\Desktop\\PreDataBase\\src\\GetInformation\\"
                + enterData.get(1) + ".get_info.txt";
        FileWriter fileWriter = new FileWriter(clientNew);
        BufferedWriter bw = new BufferedWriter(fileWriter);

        Clients client = new Clients();
        bw.flush();
        for (int i = 3; i < client.clients.get(enterData.get(1)).size(); i++) {
            String row = client.clients.get(enterData.get(1)).get(i);
            ;
            bw.write("" + row);
            bw.newLine();
        }
        bw.close();
    }
}
