package filesearcher;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileSearcher {
    public static int search(String inputFile, String keyword){
        int num = 0;

        try{        
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8));
            int c;
            String temp = "";
            while ((c = reader.read()) != -1) {
                char ch = (char) c;
                if (!Character.isLetter(ch)) {
                    if (temp.equalsIgnoreCase(keyword)) {
                        num++;
                    }
                    temp = "";
                }else{
                    temp += ch;
                }
            }
            reader.close();
        }catch(Exception e){
           
        }

        return num;
    }
}