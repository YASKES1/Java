// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.InputMismatchException;
import java.util.Scanner;
class Konwersja {
    int[][] m01 = new int[3][4];
    int rows;
    int cols;
    int[][] converted_arr = new int[4][3];
    int[][] converted_arr2;
    int[][] m02 = new int[3][3];
        public void asignValuesToTable(Scanner scanner){
        for(int i=0;i<m01.length;i++){
            for(int j=0;j<m01[i].length;j++){
                Main.printLn("Podaj wartość: ");
                int x = scanner.nextInt();
                this.m01[i][j] = x;
            }
        }
    }
    public int[][] asignToArr(int[][] arr,Scanner scanner){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                Main.printLn("Podaj wartość: ");
                int x = scanner.nextInt();
                arr[i][j] = x;
            }
        }
        return arr;
    }
    public void asignRowsCols(){
        this.rows = this.m01.length;
        this.cols = this.m01[0].length;
    }
    public void makeTask1(Scanner scanner){
        this.asignValuesToTable(scanner);
        this.asignRowsCols();
        for(int i=0;i<this.cols;i++){
            for(int j=0;j<this.rows;j++){
                this.converted_arr[i][j] = this.m01[j][i];
            }
        }
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                Main.print(this.converted_arr[i][j]+ " ");
            }
            Main.print("\n");
        }
    }
    public int getValue(int i, int j,int[][] arr){
        return arr[i][j];
    }
    public int multiply(int el1, int el2, int el3){
        int res = el1 * el2 * el3;
        return res;
    }

    public void makeTask2(Scanner scanner){
        this.m02 = this.asignToArr(this.m02,scanner);

        int a11 = this.getValue(0,0,this.m02);
        int a12 = this.getValue(0,1,this.m02);
        int a13 = this.getValue(0,2,this.m02);

        int a21 = this.getValue(1,0,this.m02);
        int a22 = this.getValue(1,1,this.m02);
        int a23 = this.getValue(1,2,this.m02);

        int a31 = this.getValue(2,0,this.m02);
        int a32 = this.getValue(2,1,this.m02);
        int a33 = this.getValue(2,2,this.m02);

        int part1 = this.multiply(a11,a22,a33);
        int part2 = this.multiply(a12,a23,a31);
        int part3 = this.multiply(a13,a21,a32);

        int part4 = this.multiply(a13,a22,a31);
        int part5 = this.multiply(a12,a21,a33);
        int part6 = this.multiply(a11,a23,a32);
        int p456 = part4 + part5 + part6;
        int p123 = part1 + part2 + part3;
        int w = p123 - p456;
        Main.printLn("Wyznacznik: "+w);

    }

}
public class Main {
    public static void printLn(String str){
        System.out.println(str);
    }
    public static void print(String str){
        System.out.print(str);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Konwersja k01 = new Konwersja();
        k01.makeTask2(scanner);
        //k01.makeTask1(scanner);
        scanner.close();
    }
}