package GetInformation;

import Data_registraited_clients.Clients;
import Data_writing.LogWriter;
import Data_writing.Write;
import Exeption.Exept;

import java.io.IOException;
import java.util.ArrayList;

public class Get_information {

    public Get_information(ArrayList<String> enterData) throws IOException {
        get_info(enterData);

    }

    public void get_info(ArrayList<String> enterData) throws IOException {
        Clients client = new Clients();

        try {
            if (!client.clients.containsKey(enterData.get(1))) {
                throw new Exept("Помилка отримання даних. Такого користувача не існує");
            }

            if (!client.clients.get(enterData.get(1)).get(2).equals(enterData.get(2))) {
                throw new Exept("Помилка оновлення пароля. Такого користувача не існує");
            }

            Write write = new Write();
            write.get_info(enterData);
            LogWriter.writeLog("For user " + enterData.get(1) + " Geting information was successful");
            return;
        } catch (Exept exept) {
            exept.printStackTrace();
            LogWriter.writeLog("For user " + enterData.get(1) + " Geting information was NOT successful");
        }
    }
}
