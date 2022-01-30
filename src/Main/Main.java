package Main;

import Data_reading.Read;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String pathEnter = "C:\\Users\\User\\Desktop\\PreDataBase\\src\\Data_from_servis\\ShehliukBohdan.txt";
        Read read = new Read(pathEnter);

        // повторна регістрація (має не працювати):
        //Read read1 = new Read("C:\\Users\\User\\Desktop\\PreDataBase\\src\\Data_from_servis\\ShehliukBohdan.txt");

        // зміна даних (працює):
        //Read read2 = new Read("C:\\Users\\User\\Desktop\\PreDataBase\\src\\Data_from_servis\\ShchehliukBohdanRenewal");

        // зміна паролю. працює
        //Read read3 = new Read("C:\\Users\\User\\Desktop\\PreDataBase\\src\\Data_from_servis\\ShehliukBohdanPasword");

        // отримання даних. працює
        //Read rea4 = new Read("C:\\Users\\User\\Desktop\\PreDataBase\\src\\Data_from_servis\\ShchehliukBohdanGetingInfo.txt");
    }
}
