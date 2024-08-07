// import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.io.FileReader;
import java.io.BufferedReader;

class Data{
    String lang,ip,timestamp;
    public Data(String lang,String ip,String timestamp){
        this.lang = lang;
        this.ip = ip;
        this.timestamp = timestamp;
    }

    public String toString(){
        return lang + "," + ip + "," + timestamp;
    }
}

public class vote{
    public static void main(String args[])throws Exception{
        // Scanner sc=new Scanner(System.in);
        String filename="logfile.txt";
        FileReader fr=new FileReader(filename);
        BufferedReader br=new BufferedReader(fr);
        String line;
        String data[];
        ArrayList<Data> al=new ArrayList<Data>();
        while((line=br.readLine())!=null){
            data=line.split(" ");
            Data d=new Data(data[0],data[1],data[2]);
            al.add(d);
        }
        br.close();
        for(Data d:al){
            System.out.println(d);
        }

        int n=al.size();

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                Data a=al.get(i),b=al.get(j);
                if(a.lang.equals(b.lang)&&a.ip.equals(b.ip)){
                    int t1=Integer.parseInt(a.timestamp),t2=Integer.parseInt(b.timestamp);
                    if(t2-t1<=20){
                        al.remove(j);
                        n-=1;
                    }
                }
            }
        }

        HashMap<String,Integer> votes=new HashMap<>();
        for(Data d:al){
            int x=votes.getOrDefault(d.lang, 0)+1;
            votes.put(d.lang,x);
        }
        // System.out.println(votes);

        Set<Map.Entry<String,Integer>> s1=votes.entrySet();

        for(Map.Entry<String,Integer> entry:s1){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }



    }
}