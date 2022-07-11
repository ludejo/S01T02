package n2e1;

public class Main {
    public static void main(String[] args) {


        byte exempleByte = Entrada.llegirByte("Introdueix un byte: ");
        System.out.println("El byte introduït: " + exempleByte);

        int exempleInt = Entrada.llegirInt("Introdueix un int: ");
        System.out.println("L'int introduït: " + exempleInt);

        float exempleFloat = Entrada.llegirFloat("Introdueix un float: ");
        System.out.println("El float introduït: " + exempleFloat);

        double exempleDouble = Entrada.llegirDouble("Introdueix un double: ");
        System.out.println("El double introduït: " + exempleDouble);

        char exempleChar = Entrada.llegirChar("Introdueix un caràcter: ");
        System.out.println("El char introduït: " + exempleChar);

        String exempleString = Entrada.llegirString("Introdueix un string: ");
        System.out.println("El string introduït: " + exempleString);

        boolean exempleBoolean = Entrada.llegirSiNo("Introdueix s/n: ");
        System.out.println("El booleà introduït: " + exempleBoolean);

    }
}
