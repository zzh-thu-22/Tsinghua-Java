package datachooser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class DataChooser {
    public static void choose(String inputFile, String outputFile){
        int num = 0;
        try{        
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8));
            int c;
            int a =1;
            String temp = "";
            String[] Temp = new String[55];
            Arrays.fill(Temp, "");
            Temp[0] = "Department";

            while ((c = reader.read()) != -1) {
                char ch = (char) c;
                if (ch == ','||ch == '\n'||ch == '\r') {
                    if (temp.equals("Department")) {
                        num++;
                        temp = "";
                        if(ch == ','||ch == '\r'){
                            while((c = reader.read()) != '\n'){
                            
                            }
                        }
                        break;
                    }
                    temp = "";
                    num++;
                }else{
                    temp += ch;
                }
            }

            int j=0;
            while ((c = reader.read()) != -1) {
                char ch = (char) c;
                if (ch == ','||ch == '\n'||ch == '\r') {
                    j++;
                    if (j==num) {
                        Temp[a++] = temp;
                        j=0;
                        if(ch == ','||ch == '\r'){
                            while((c = reader.read()) != '\n'){
                            
                            }
                        }
                    }
                    temp = "";
                }else{
                    temp += ch;
                }
            }
            reader.close();


            PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
            for (int i=0; Temp[i]!=""; i++) {
                writer.println(Temp[i]);
            }
            writer.close();
        }catch(Exception e){
           
        }
    }
}
