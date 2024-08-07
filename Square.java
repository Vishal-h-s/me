import java.util.Scanner;

class Rectangle {
    public int ab1, or1, ab2, or2;

    public Rectangle(int abs1, int ord1, int abs2, int ord2) {
        ab1 = abs1;
        or1 = ord1;
        ab2 = abs2;
        or2 = ord2;
    }

    public int area() {
        return Math.abs((ab1 - ab2) * (or1 - or2));
    }

    public Rectangle overlap(Rectangle r) {
        int x1 = Math.max(ab1, r.ab1);
        int y1 = Math.max(or1, r.or1);
        int x2 = Math.min(ab2, r.ab2);
        int y2 = Math.min(or2, r.or2);

        if (x1 >= x2 || y1 >= y2)
            return new Rectangle(0, 0, 0, 0);
        return new Rectangle(x1, y1, x2, y2);
    }
    
    public static Rectangle overlap(Rectangle[] rectangles) {
        if (rectangles == null || rectangles.length == 0)
            return new Rectangle(0, 0, 0, 0);

        Rectangle r = rectangles[0];

        for (int i = 0; i < rectangles.length; i++) {
            r = r.overlap(rectangles[i]);
            if(Math.abs(r.ab1-r.ab2)==0||Math.abs(r.or1-r.or2)==0)
                return new Rectangle(0, 0, 0, 0);
        }
        return r;
    }

    public String toString(){
        return ("Class MyRectangle: [(" + (ab1) + "," + (or1) + "); (" + (ab2) + "," + (or2) + ")]");
    }
}

class Square extends Rectangle{
    public int ab,or,l;

    public Square(int x,int y,int l){
        super(x,y,x+l,y+l);//assuming square in direction of Q1
        ab=x;or=y;this.l=l;
    }

    @Override
    public String toString() {
        return "Square: [(" + (ab) + "," + (or) + "); (" + (ab2) + "," + (or2) + ")]";
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter abcissa,ordinate and side-length of square");
        int x=s.nextInt(),y=s.nextInt(),l=s.nextInt();
        s.close();
        
        Square sq=new Square(x, y, l);
        System.out.println(sq+"\narea = "+sq.area());
    }
}