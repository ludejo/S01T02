package n3e1;

import n2e1.Entrada;

import java.util.regex.Pattern;

public class Cinema {
    private int nombreFiles;
    private int nombreSeients;
    private GestorButaques gestor;
    private static final Pattern patternAlfabetic = Pattern.compile("^[a-zA-Z]+$");

    public Cinema() {
        this.gestor = new GestorButaques();
        demanarDadesInicials();
    }

    public void iniciar() {
        int input;
        do {
            input = menu();
            switch (input) {
                case 0:
                    System.out.println("Adéu!");
                    break;
                case 1:
                    mostrarButaques();
                    break;
                case 2:
                    mostrarButaquesPersona();
                    break;
                case 3:
                    reservarButaca();
                    break;
                case 4:
                    anularReserva();
                    break;
                case 5:
                    anularReservaPersona();
                    break;
                default:
                    System.out.println("Opció no reconeguda");
                    break;
            }
        } while (input != 0);
    }

    public int menu() {
        String msg = ("Selecciona una opció: " +
                "\n\t[1] Mostrar totes les butaques reservades" +
                "\n\t[2] Mostrar les butaques reservades per una persona" +
                "\n\t[3] Reservar una butaca" +
                "\n\t[4] Anul·lar la reserva d'una butaca" +
                "\n\t[5] Anul·lar totes les reserves d'una persona" +
                "\n\t[0] Sortir\n");
        return Entrada.llegirInt(msg);
    }

    public void mostrarButaques() {
        gestor.getLlistaButaques().forEach(System.out::println);
    }

    public void mostrarButaquesPersona() {
        try {
            String nom = introduirPersona();
            gestor.getLlistaButaques().stream()
                    .filter(b -> b.getPersona().equals(nom))
                    .forEach(System.out::println);
        } catch (ExcepcioNomPersonaIncorrecte e) {
            System.out.println(e.getMessage());
        }
    }

    public void reservarButaca() {
        try {
            int nFila = introduirFila();
            int nSeient = introduirSeient();
            String nom = introduirPersona();
            gestor.afegirButaca(new Butaca(nFila, nSeient, nom));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void anularReserva() {
        try {
            int nFila = introduirFila();
            int nSeient = introduirSeient();
            gestor.eliminarButaca(nFila, nSeient);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void anularReservaPersona() {
        try {
            String nom = introduirPersona();
/*
            gestor.getLlistaButaques().parallelStream()
                    .filter(b -> b.getPersona().equals(nom))
                    .forEach(b-> gestor.eliminarButaca(b.getFila(), b.getSeient()));
 */
            for (int i = 0; i < gestor.getLlistaButaques().size(); i++) {
                Butaca b = gestor.getLlistaButaques().get(i);
                if (b.getPersona().equals(nom)) {
                    gestor.eliminarButaca(b.getFila(), b.getSeient());
                    i--;
                } else {
                    i++;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String introduirPersona() throws ExcepcioNomPersonaIncorrecte {
        String nom = Entrada.llegirString("Introdueix el nom de la persona: ");
        if (!patternAlfabetic.matcher(nom).matches()) {
            throw new ExcepcioNomPersonaIncorrecte("El nom ha de tenir només lletres");
        } else {
            return nom;
        }
    }

    public void demanarDadesInicials() {
        System.out.println("Configuració del cinema");
        this.nombreFiles = Entrada.llegirInt("Número de files: ");
        this.nombreSeients = Entrada.llegirInt("Número de seients per fila: ");
    }

    public int introduirFila() throws ExcepcioFilaIncorrecta {
        int nFila = Entrada.llegirInt("Introdueix número de fila: ");
        if (nFila < 1 || nFila > nombreFiles) {
            throw new ExcepcioFilaIncorrecta("El número de fila ha d'estar entre 1 i " + nombreFiles);
        } else {
            return nFila;
        }
    }

    public int introduirSeient() throws ExcepcioSeientIncorrecte {
        int nSeient = Entrada.llegirInt("Introdueix número de seient: ");
        if (nSeient < 1 || nSeient > nombreSeients) {
            throw new ExcepcioSeientIncorrecte("El número de seient ha d'estar entre 1 i " + nombreSeients);
        } else {
            return nSeient;
        }
    }
}
