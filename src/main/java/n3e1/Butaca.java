package n3e1;

import java.util.Objects;

public class Butaca {
    private int fila;
    private int seient;
    private String persona;

    public Butaca(int fila, int seient, String persona) {
        this.fila = fila;
        this.seient = seient;
        this.persona = persona;
    }

    public int getFila() {
        return fila;
    }

    public int getSeient() {
        return seient;
    }

    public String getPersona() {
        return persona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Butaca butaca = (Butaca) o;
        return fila == butaca.fila && seient == butaca.seient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, seient);
    }

    @Override
    public String toString() {
        return String.format("Fila: %d, Seient: %d, Persona: %s\n", fila, seient, persona);
    }
}
