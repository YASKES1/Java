
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.*;
class Okrag {
    String operation;
    String menu_line01  = "\nOp1: Suma pol dwóch trójkątów" +
            "\nOp2: znajdz x macierzy " +
            "[a1 * x + b1, c1 * x - d1] [a2 * x - b2, c2 * x + d2] " +
            "\nExit";

    int[] m1a_arr = new int[3];
    int[] m2a_arr = new int[3];
    int[] resa_arr = new int[3];
    int[] m1b_arr = new int[3];
    int[] m2b_arr = new int[3];
    int[] resb_arr = new int[3];
    double[] xs_arr = new double[3];
    double[] ys_arr = new double[3];
    int[] m1a_arr2 = new int[3];
    int[] m2a_arr2 = new int[3];
    int[] resa_arr2 = new int[3];
    int[] m1b_arr2 = new int[3];
    int[] m2b_arr2 = new int[3];
    int[] resb_arr2 = new int[3];
    double[] xs_arr2 = new double[3];
    double[] ys_arr2 = new double[3];
    public int makeRes(int el1, int el2){
        el2 = -el2;
        int res = el1 + el2;
        return res;
    }
    public double makeX(int left,int right){
        right = -right;
        double res = right/left;
        return res;
    }
    public double makeY(int a, double x, int b){
        double res = a * x + b;
        return res;
    }
    public int checkInputs(Scanner scanner){
        while (!scanner.hasNextInt()){
            Main.printStr("Enter valid int:");
            scanner.next();
        }
        int sc_res = scanner.nextInt();
        return sc_res;
    }
    public double getDoubleValue(int i,double[] arr){
        return arr[i];
    }
    public double makeLen(double xel1, double xel2, double yel1, double yel2){
        double part1 = Math.pow((xel2-xel1),2);
        double part2 = Math.pow((yel2-yel1),2);
        double len_res = Math.sqrt(part1 + part2);
        return len_res;
    }
    public double makeHeron(double boka, double bokb,double bokc){
        double p = 0.5 * (boka + bokb + bokc);
        double part1 = p - boka;
        double part2 = p - bokb;
        double part3 = p - bokc;
        double res_part = p * part1 * part2 * part3;
        double heron_res = Math.sqrt(res_part);
        return heron_res;
    }
    public void makeTask(Scanner scanner){
        double x1,y1,x2,y2,x3,y3 = 0;
        for(int i=0;i<3;i++) {
            Main.printStr("Podaj wartość a z macierzy lewej: ");
            this.m1a_arr[i] = this.checkInputs(scanner);
            Main.printStr("Podaj wartość a z macierzy prawej: ");
            this.m2a_arr[i] = this.checkInputs(scanner);
            this.resa_arr[i] = this.makeRes(this.m1a_arr[i], this.m2a_arr[i]);
            Main.printStr("Podaj wartość b z macierzy lewej: ");
            this.m1b_arr[i] = this.checkInputs(scanner);
            Main.printStr("Podaj wartość b z macierzy prawej: ");
            this.m2b_arr[i] = this.checkInputs(scanner);
            this.resb_arr[i] = this.makeRes(this.m1b_arr[i], this.m2b_arr[i]);

            this.xs_arr[i] = this.makeX(this.resa_arr[i], this.resb_arr[i]);
            this.ys_arr[i] = this.makeY(this.resa_arr[i], this.xs_arr[i], this.resb_arr[i]);
        }
        x1 = this.getDoubleValue(0,this.xs_arr);
        x2 = this.getDoubleValue(1,this.xs_arr);
        x3 = this.getDoubleValue(2,this.xs_arr);
        y1 = this.getDoubleValue(0,this.ys_arr);
        y2 = this.getDoubleValue(1,this.ys_arr);
        y3 = this.getDoubleValue(2,this.ys_arr);
        double boka = this.makeLen(x1,x2,y1,y2);
        double bokb = this.makeLen(x1,x3,y1,y3);
        double bokc = this.makeLen(x2,x3,y2,y3);
        double tr_field = this.makeHeron(boka,bokb,bokc);

        Main.printStr("Pole pierwszego trójkąta: " + tr_field);

        double x12,x22,x32,y12,y22,y32 = 0;

        for(int i=0;i<3;i++) {
            Main.printStr("Podaj wartość a z macierzy lewej: ");
            this.m1a_arr2[i] = this.checkInputs(scanner);
            Main.printStr("Podaj wartość a z macierzy prawej: ");
            this.m2a_arr2[i] = this.checkInputs(scanner);
            this.resa_arr2[i] = this.makeRes(this.m1a_arr2[i], this.m2a_arr2[i]);
            Main.printStr("Podaj wartość b z macierzy lewej: ");
            this.m1b_arr2[i] = this.checkInputs(scanner);
            Main.printStr("Podaj wartość b z macierzy prawej: ");
            this.m2b_arr2[i] = this.checkInputs(scanner);
            this.resb_arr2[i] = this.makeRes(this.m1b_arr2[i], this.m2b_arr2[i]);

            this.xs_arr2[i] = this.makeX(this.resa_arr2[i], this.resb_arr2[i]);
            this.ys_arr2[i] = this.makeY(this.resa_arr2[i], this.xs_arr2[i], this.resb_arr2[i]);
        }


        x12 = this.getDoubleValue(0,this.xs_arr2);
        x22 = this.getDoubleValue(1,this.xs_arr2);
        x32 = this.getDoubleValue(2,this.xs_arr2);
        y12 = this.getDoubleValue(0,this.ys_arr2);
        y22 = this.getDoubleValue(1,this.ys_arr2);
        y32 = this.getDoubleValue(2,this.ys_arr2);
        double boka2 = this.makeLen(x12,x22,y12,y22);
        double bokb2 = this.makeLen(x12,x32,y12,y32);
        double bokc2 = this.makeLen(x22,x32,y22,y32);
        double tr_field2 = this.makeHeron(boka2,bokb2,bokc2);
        Main.printStr("Pole drugiego trójkąta: " + tr_field2);

        double suma = tr_field + tr_field2;
        Main.printStr("Suma pol dwuch trójkątów: " + suma);


    }
    public void find_X(Scanner scanner){

        Main.printStr("Podaj a1 lewej macierzy: ");
        int a1 = this.checkInputs(scanner);
        Main.printStr("Podaj b1 z macierzy lewej: ");
        int b1 = this.checkInputs(scanner);
        Main.printStr("Podaj c1 z macierzy lewej: ");
        int c1 = this.checkInputs(scanner);
        Main.printStr("Podaj d1 z macierzy lewej: ");
        int d1 = this.checkInputs(scanner);
        Main.printStr("Podaj a2 prawej macierzy: ");
        int a2 = this.checkInputs(scanner);
        Main.printStr("Podaj b2 z macierzy prawej: ");
        int b2 = this.checkInputs(scanner);
        Main.printStr("Podaj c2 z macierzy prawej: ");
        int c2 = this.checkInputs(scanner);
        Main.printStr("Podaj d2 z macierzy prawej: ");
        int d2 = this.checkInputs(scanner);


        double part1 = b1 * c2 - b2 * c1 + d1 * c2 - d2 * c1;
        double deter = a1 * c2 - a2 * c1;
        if (deter!=0){
            double res_x = part1/deter;
            Main.printStr("Macierze są równe przy X: " + res_x);

        }else{
            Main.printStr("brak rozwiązań");
        }

    }

}
public class Main {
    static  boolean run = true;
    public static void printStr(String str){
        System.out.println(str);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Okrag ok = new Okrag();
        do {
            printStr(ok.menu_line01);
            ok.operation = scanner.next();
            try {
                switch (ok.operation){
                    case "Op1":
                        ok.makeTask(scanner);
                        break;
                    case "Op2":
                        ok.find_X(scanner);
                        break;
                    case "Exit":
                        System.out.println("You have exited the calculator");
                        System.exit(0);
                        run = false;
                        break;
                    default:
                        printStr("Something wrong");
                        break;

                }
            }catch (InputMismatchException ex){
                printStr(ex.getMessage());
            }
        }while (run == true);
        scanner.close();
    }
}