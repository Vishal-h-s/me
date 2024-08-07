import java.util.Scanner;
import java.util.HashMap;
import java.io.FileReader;
import java.io.BufferedReader;

public class h {

    public static void main(String[] args) throws Exception{
        
        FileReader fr=new FileReader("phonenumber.txt");
        
        BufferedReader br=new BufferedReader(fr);
        
        HashMap<String,String> hm=new HashMap<>();
        String record;
        
        while((record=br.readLine())!=null){
            String[] data=record.split(" ");
            hm.put(data[0],data[1]);
        }
        br.close();
        System.out.println(hm);

        Scanner sc=new Scanner(System.in);  
        System.out.print("Enter name or phone number: ");;
        String in =sc.next();
        sc.close();
        
        if(!in.matches(".*\\d.*")){
            in=in.toUpperCase();
            if(hm.containsKey(in)){
                System.out.println("Phone number: "+hm.get(in));
            }
        }else if(hm.containsValue(in)){
            for(HashMap.Entry<String,String> entry:hm.entrySet()){
                if(entry.getValue().equals(in)){
                    System.out.println("Name: "+entry.getKey());
                    break;
                }
            }
        }else{
            System.out.println("Invalid Input");
        }
        

    }
}