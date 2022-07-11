package n1e1;

public class Main {
    public static void main(String[] args) {
        Venda vendaExemple = new Venda();
        try {
            vendaExemple.calcularTotal();
        } catch (VendaBuidaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
