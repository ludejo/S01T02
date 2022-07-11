package n1e1;

import java.util.ArrayList;

public class Venda {
    private ArrayList<Producte> vendes;
    private double preuTotal;

    public Venda() {
        this.vendes = new ArrayList<>();
        this.preuTotal = 0;
    }

    void calcularTotal() throws VendaBuidaException {
        if (vendes.size() == 0) {
            throw new VendaBuidaException("Per fer una venda primer has d’afegir productes");
        } else {
            double sumatori = 0;
            for (Producte i : vendes) {
                sumatori += i.getPreu();
            }
            System.out.println(sumatori);
        }
    }
}
