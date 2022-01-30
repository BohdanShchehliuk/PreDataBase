package GetInformation;

import Data_registraited_clients.Clients;
import Data_writing.Write;

import java.io.IOException;
import java.util.ArrayList;

public class Get_information {

    public Get_information(ArrayList<String> enterData) throws IOException {
        get_info(enterData);

    }

    public void get_info(ArrayList<String> enterData) throws IOException {
        Clients client = new Clients();
        if (client.equals(null) || !client.clients.containsKey(enterData.get(1))) {
            System.out.println("Клієнта з таким логіном не існує");
            return;
        }
        if (client.clients.get(enterData.get(1)).get(2).equals(enterData.get(2))) {
            Write write = new Write();
            write.get_info(enterData);
            System.out.println("Ваші дані:" + client.clients.get(enterData.get(1)));
        } else {
            System.out.println("Ви ввели невірний логін");
        }
    }
}
