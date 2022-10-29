package main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
public class Urinals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.println(" Enter the input string");
        str = sc.nextLine();

        System.out.println("Enter option");
        int opt = sc.nextInt();
        if (opt == 1) {
            int result = countUrinals(str);
            System.out.println(result);
        }
        else {
            try {
                FileReader file = new FileReader(new File("urinal.dat"));
                BufferedReader br = null;
                br = new BufferedReader(file);
         
                File fout = new File("rule.txt");
                if (!fout.exists()) {
                    fout.createNewFile();

                }

                FileWriter fw = new FileWriter(fout.getAbsolutePath());
                BufferedWriter bw = new BufferedWriter(fw);
                while (true) {
                    String temp = br.readLine();
                    if (temp == null) break;
                    int val = countUrinals(temp);
                    bw.write(Integer.toString(val));
                    bw.newLine();
                }
                br.close();
                bw.close();
            } catch (Exception e) {
                System.out.println(e);
      
            }
        }

    }
    public boolean goodString( String str )
    {  // checks to see if valid string
        boolean isGoodString=false;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='0'||str.charAt(i)=='1')
            {
                isGoodString=true;
            }
            else {
                isGoodString=false;
                break;
            }
        }
        return isGoodString;
    }


    public static int countUrinals(String str) {

        int countZero = 0, countOne=0,count = 0;
        char[] sArray= new char[str.length()];
        for(int i=1;i<sArray.length;i++) {
            if(str.contains("11")) {
                System.out.println("wrong string here");
                return -1;
            }
        }
        if(!str.contains(("1"))){
            return (str.length()+1)/2;
        }
        for(int i=0;i< str.length();i++) {
            sArray[i]=str.charAt(i);
        }
        int i=0;
        while(i<sArray.length){
            if(sArray[i]=='0')
                countZero++;
            else {
                count = count + (countZero-countOne)/2;
                countZero=0;
                countOne=1;
            }
            i++;

        }
        count = count + countZero/2;
        return count;
    }
}

