import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class main {

    public static void main(String[] args) throws IOException {

        final String input = new String( Files.readAllBytes(Paths.get("Data.txt")), "UTF-8");
        int[] array = new int[255];//массив для чисел аски символов
        char[] divstr = input.toCharArray();
// разбиение входной строки на числовые аски значения
        byte[] bytes = input.getBytes("windows-1251");
        for (int v = 0; v < bytes.length; v++){
            array[v] = bytes[v];
            System.out.println("["+array[v]+"]");
        }
        for (int i = 0; i < divstr.length; i++) {
            System.out.print("[" + divstr[i] + "] ");
        }
//формула
        double result;//результат хэш-функции
        double result2;
        double a = array[0];
        double b = array[1];
        double c = array[2];
        double d = array[3];
        double f = array[4];
        double g = array[5];
        int h = array[6];
        for (int x = 7; x < array.length; x++){
            h = h - array[x];
        }
        if( Math.abs(a) >=10){
            a = Math.round(array[0]/2);
        }
        if( Math.abs(b) >=10){
            b = Math.round(array[1]/5);
        }
        if ( Math.abs(c) >=10){
            c = Math.round(array[2]/2);
        }
        if ( Math.abs(d) >=10){
            d = Math.round(array[3]/3);
        }
        if ( Math.abs(f) >=10){
            f = Math.round(array[4]/8);
        }
        if ( Math.abs(g) >=10){
            g = Math.round(array[5]/3);
        }
        if (a <=0 || b<=0 || c <=0 || d <= 0 || f <= 0 || g <= 0 || h <=0){
            a = Math.abs(a);
            b = Math.abs(b);
            c = Math.abs(c);
            d = Math.abs(d);
            f = Math.abs(f);
            g = Math.abs(g);
            h = Math.abs(h);

            result = (int)Math.round(((a/b*h) + (g/d)) * Math.pow((f+c),((b-a)/h)) + h);
            result2 = (int)Math.round(((a*b/h) + (g*d)) * Math.pow((f+c),((b+a)/h)) + h);
        }
        else {
            result = (int)Math.round(((a/b*h) + (g/d)) * Math.pow((f+c),((b-a)/h)) + h);
            result2 = (int)Math.round(((a*b/h) + (g*d)) * Math.pow((f+c),((b+a)/h)) + h);
        }
        System.out.print("\nHash function H(x) = y \n");
        System.out.println("y = "+result);
        System.out.print("\nHash function H(x) = y2 \n");
        System.out.println("y2 = "+result2);
    }
}
