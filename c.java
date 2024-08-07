import java.util.HashMap;
// import java.lang.Math;

class Resistor{
    HashMap<String,Integer> colormap;
    String tens,ones,expo;
    double resistance;

    Resistor(String a,String b,String c){
        tens=a.toLowerCase();
        ones=b.toLowerCase();
        expo=c.toLowerCase();

        colormap=new HashMap<>();
        colormap.put("black", 0);
        colormap.put("brown", 1);
        colormap.put("red", 2);
        colormap.put("orange", 3);
        colormap.put("yellow", 4);
        colormap.put("green", 5);
        colormap.put("blue", 6);
        colormap.put("violet", 7);
        colormap.put("grey", 8);
        colormap.put("white", 9);
    }

    public double getResistance(){
        resistance=(colormap.get(tens)*10+colormap.get(ones))*Math.pow(10,colormap.get(expo));
        return resistance;
    }
};

public class c{
    public static void main(String args[]){
        Resistor r=new Resistor("red", "black", "orange");
        System.out.println(r.getResistance()/1000+" Kilo ohms");
    }
}
