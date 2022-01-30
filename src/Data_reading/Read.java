package Data_reading;

import Check.Check;

import java.io.*;
import java.util.ArrayList;

public class Read {
    private int maxNumberOfrows = 20;

    private ArrayList<String> enterData;

    public ArrayList<String> getEnterData() {
        return enterData;
    }

    public Read(String pathEnter) throws IOException {

        File file = new File(pathEnter);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        enterData = new ArrayList<>();
        String finish = "";
        while (finish != null) {
            finish = br.readLine();
            enterData.add(finish);
        }
        Check check = new Check(enterData);
    }
}
