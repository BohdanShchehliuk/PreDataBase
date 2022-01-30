package Check;

import GetInformation.Get_information;
import PasswordRen.Password_renewal;
import Registration.Registration;
import Renewal.Renewal;


import java.io.IOException;
import java.util.ArrayList;

public class Check {

    private String[] keyWords = {"registration", "data_renewal", "password_renewal", "get_information"};
    private String keywords;
    ArrayList<String> enterData;

    public Check(ArrayList<String> enterData) throws IOException {
        this.enterData = enterData;
        this.keywords = checking_key_request(enterData);
        command(keywords);
    }

    public String checking_key_request(ArrayList<String> enterData) {
        for (String k : keyWords) {
            if (k.equals(enterData.get(0))) {
                System.out.println("Ваша команда: " + enterData.get(0));
            }
        }
        return enterData.get(0);
    }

    public void command(String keywords) throws IOException {
        if (keywords.equals(null)) {
            System.out.println("Відсутнє правильне слово-команда");
        } else if (keywords.equals("registration")) {
            Registration registration = new Registration(enterData);
        } else if (keywords.equals("data_renewal")) {
            Renewal renewal = new Renewal(enterData);
        } else if (keywords.equals("password_renewal")) {
            Password_renewal password_renewal = new Password_renewal(enterData);
        } else if (keywords.equals("get_information")) {
            Get_information get_information = new Get_information(enterData);
        } else {
            System.out.println("Не правильне слово-команда");
        }
    }
}
