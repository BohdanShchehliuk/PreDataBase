package Check;

import Data_writing.LogWriter;
import Exeption.Exept;
import GetInformation.Get_information;
import PasswordRen.Password_renewal;
import Registration.Registration;
import Renewal.Renewal;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Check {


    ArrayList<String> enterData;

    public Check(ArrayList<String> enterData) throws IOException {
        this.enterData = enterData;
        command(enterData.get(0));
    }


    public void command(String keywords) throws IOException {

        Checking checking = Checking.valueOf(keywords.toUpperCase(Locale.ROOT));
        try {
            switch (checking) {
                case REGISTRATION:
                    Registration registration = new Registration(enterData);
                    break;
                case DATA_RENEWAL:
                    Renewal renewal = new Renewal(enterData);
                    break;
                case PASSWORD_RENEWAL:
                    Password_renewal password_renewal = new Password_renewal(enterData);
                    break;
                case GET_INFORMATION:
                    Get_information get_information = new Get_information(enterData);
                    break;
                default:
                    LogWriter.writeLog("For user " + enterData.get(1) + " key word is NOT correct");
            }

        } catch (IOException e) {
            e.printStackTrace();
           }
    }
}
