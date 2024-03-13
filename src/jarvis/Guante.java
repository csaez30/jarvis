package jarvis;

class Guante extends Dispositivo {
    public Guante(float consumoEnergia) {
        super(consumoEnergia);
    }

    public float disparar(int nivelIntensidad, int tiempo) {
        float energiaConsumida = usar(nivelIntensidad, tiempo * 3); // Consumo triplicado al disparar
        // Realizar lógica de disparo
        return energiaConsumida;
    }
}