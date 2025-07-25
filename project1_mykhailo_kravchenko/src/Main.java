import java.util.Scanner;
import java.util.InputMismatchException;



class Derivative{
    public String zad;
    public int a, b, c, p, p1, p2, p3;
    public String der_menu = "\nOp1 simpleDer\nOp2 advanceDer\nOp3 Zad1: y=15√x " +
            "\nOp4 Zad2: y = 3√x+2x^8+12x^6\nOp5 Zad3: y = 3/x^5" +
            "\nOp6 Zad1 input values\nOp7 Zad 2 input values\nOp8 Zad3 input values\nExit";
    public int checkInput(Scanner scanner){
        while(!scanner.hasNextInt()){
            Main.printStr("Enter valid int");
            scanner.next();
        }
        int sc = scanner.nextInt();
        return sc;
    }
    public void simpleDer(int a, int p){
        int calc =  a * p;
        int exp = p - 1;
        String line = "df " + a + "x^" + p + " = " + calc + "x^" + exp;
        Main.printStr(line);
    }
    public void advanceDer(int a, int b, int c, int p1, int p2, int p3){
        int calc01 = p1 * a;
        int exp1_res= p1-1;
        int calc02 = p2 * b;
        int exp2_res = p2-1;
        int calc03 = p3 * c;
        int exp3_res = p3 - 1;

        String part01="df " + a + "x^" + p1 + " + " + b + "x^" + p2 + " + " + c + "x^" + p3;
        String part02 = calc01 + "x^" + exp1_res + " + " + calc02 + "x^" + exp2_res + " + " + calc03 + "x^" + exp3_res;
        Main.printStr(part01+ " = " + part02);
    }

    public void Zad1(int a){
        // zad1 y=15√x
        String zad1 = "df " + a + "√x = " + a + " / " + 2 + "√x" ;
        Main.printStr(zad1);
    }
    public void Zad2(int a, int b, int p1, int c, int p2 ){
        // zad2 y = 3√x+2x^8+12x^6
        String calca = "(" + a + " /" + 2 + "√x)";
        int calcb = p1 * b;
        int calcp1 = p1 - 1;
        int calcc = c * p2;
        int calcp2 = p2 - 1;
        String Zad2 = "df " + a +"√x" +" + " + b + "x^" + p1 + " + " + c + "x^" + p2 + " = " + calca + " + " + calcb
                + "x^" + calcp1 + " + " + calcc + "x^" + calcp2;
        Main.printStr(Zad2);
    }
    public void Zad3(int a, int p){
        // zad3 y = 3/x^5
        //String calct1 = 0 + "*" + "x^" + p;
        int p2 = p - 1;
        String calcp =  p + "x^" + p2;
        String calct2 = a + "*" + calcp;
        int p3 = p * 2;
        String calcb = "x^" + p3;

        String Zad3 = "df 3/x^5 = " + " -" + "(" + calct2 + ")" + " / " + calcb ;
        Main.printStr(Zad3);
    }
}

public class Main {
    static boolean run = true;
    public static void menu(String menu) {printStr(menu);}
    public static void printStr(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Derivative der = new Derivative();
        do {
            menu(der.der_menu);
            der.zad = scanner.next();
            try {
                switch (der.zad) {
                    case "op1":
                        printStr("Enter a: ");
                        der.a = der.checkInput(scanner);
                        printStr("Enter b: ");
                        der.p = der.checkInput(scanner);
                        der.simpleDer(der.a, der.p);
                        break;
                    case "op2":
                        printStr("Enter a:");
                        der.a = der.checkInput(scanner);
                        printStr(("Enter x pow:"));
                        der.p1 = der.checkInput(scanner);
                        printStr("Enter b:");
                        der.b = der.checkInput(scanner);
                        printStr("enter x2 pow:");
                        der.p2 = der.checkInput(scanner);
                        printStr("Enter c:");
                        der.c = der.checkInput(scanner);
                        printStr("Enter x3 pow:");
                        der.p3 = der.checkInput(scanner);

                        der.advanceDer(der.a, der.b, der.c, der.p1, der.p2, der.p3);
                    case "op3":
                        der.Zad1(15);
                        break;
                    case "op4":
                        der.Zad2(3, 2, 8, 12, 6);
                        break;
                    case "op5":
                        der.Zad3(3, 5);
                        break;
                    case "op6":
                        printStr("Enter a:");
                        der.a = der.checkInput(scanner);
                        der.Zad1(der.a);
                        break;
                    case "op7":
                        printStr("Enter a:");
                        der.a = der.checkInput(scanner);
                        printStr("Enter b:");
                        der.b = der.checkInput(scanner);
                        printStr("Enter x2 pow:");
                        der.p2 = der.checkInput(scanner);
                        printStr("Enter c:");
                        der.c = der.checkInput(scanner);
                        printStr("Enter x3 pow:");
                        der.p3 = der.checkInput(scanner);
                        der.Zad2(der.a, der.b, der.p2, der.c, der.p3);
                        break;
                    case "op8":
                        printStr("Enter a:");
                        der.a = der.checkInput(scanner);
                        printStr("Enter b:");
                        der.p = der.checkInput(scanner);
                        der.Zad3(der.a, der.p);
                        break;
                    case "exit":
                        System.out.println("You have exited the calculator");
                        System.exit(0);
                        run = false;
                        break;
                    default:
                        printStr("Something wrong");
                }
            } catch (InputMismatchException e) {
                printStr(e.getMessage());
            }
        } while (run);
        scanner.close();
    }
}
