package n3e1;

//import java.util.Collections;
//import java.util.List;
import java.util.ArrayList;


public class GestorButaques {

    private ArrayList<Butaca> llistaButaques;

    public GestorButaques() {
        this.llistaButaques = new ArrayList<>();
    }

    public ArrayList<Butaca> getLlistaButaques() {
        return llistaButaques;
    }

    public void afegirButaca(Butaca nButaca) {
        try {
            int afegirIdx = cercarButaca(nButaca.getFila(), nButaca.getSeient());
            if (afegirIdx == -1) {
                llistaButaques.add(nButaca);
            } else {
                throw new ExcepcioButacaOcupada("Aquesta butaca ja està reservada");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarButaca(int fila, int seient) {
        try {
            int eliminarIdx = cercarButaca(fila, seient);
            if (eliminarIdx == -1) {
                throw new ExcepcioButacaLliure("No hi ha cap butaca reservada amb aquestes dades");
            } else {
                llistaButaques.remove(eliminarIdx);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int cercarButaca(int filaCerca, int seientCerca) {
        int idx = -1;
        int ctr = 0;
        while (idx == -1 && ctr < llistaButaques.size()) {
            boolean filaTrobat = llistaButaques.get(ctr).getFila() == filaCerca;
            boolean seientTrobat = llistaButaques.get(ctr).getSeient() == seientCerca;
            if (filaTrobat && seientTrobat) {
                idx = ctr;
            } else {
                ctr++;
            }
        }
        return idx;
    }
}
