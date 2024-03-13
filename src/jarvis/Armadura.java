package jarvis;

class Armadura {
    private String colorPrimario;
    private String colorSecundario;
    private Bota botaIzquierda;
    private Bota botaDerecha;
    private Guante guanteIzquierdo;
    private Guante guanteDerecho;
    private Consola consola;
    private Sintetizador sintetizador;
    private int resistencia;
    private int salud; //0 a 100
    private Generador generador;

    // Constructor, getters y setters

    public Armadura(String colorPrimario, String colorSecundario, int resistencia, int salud) {
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.resistencia = resistencia;
        this.salud = salud;
        this.generador = new Generador(Integer.MAX_VALUE);
    }

    public String getColorPrimario() {
        return colorPrimario;
    }

    public void setColorPrimario(String colorPrimario) {
        this.colorPrimario = colorPrimario;
    }

    public String getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(String colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public Bota getBotaIzquierda() {
        return botaIzquierda;
    }

    public void setBotaIzquierda(Bota botaIzquierda) {
        this.botaIzquierda = botaIzquierda;
    }

    public Bota getBotaDerecha() {
        return botaDerecha;
    }

    public void setBotaDerecha(Bota botaDerecha) {
        this.botaDerecha = botaDerecha;
    }

    public Guante getGuanteIzquierdo() {
        return guanteIzquierdo;
    }

    public void setGuanteIzquierdo(Guante guanteIzquierdo) {
        this.guanteIzquierdo = guanteIzquierdo;
    }

    public Guante getGuanteDerecho() {
        return guanteDerecho;
    }

    public void setGuanteDerecho(Guante guanteDerecho) {
        this.guanteDerecho = guanteDerecho;
    }

    public Consola getConsola() {
        return consola;
    }

    public void setConsola(Consola consola) {
        this.consola = consola;
    }

    public Sintetizador getSintetizador() {
        return sintetizador;
    }

    public void setSintetizador(Sintetizador sintetizador) {
        this.sintetizador = sintetizador;
    }

    public float getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public float getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public Generador getGenerador() {
        return generador;
    }

    public void setGenerador(Generador generador) {
        this.generador = generador;
    }

    public void caminar(int tiempo) {
        consumirEnergia(botaIzquierda.usar(1, tiempo));
        consumirEnergia(botaDerecha.usar(1, tiempo));
    }

    public void correr(int tiempo) {
        consumirEnergia(botaIzquierda.usar(1, tiempo * 2));
        consumirEnergia(botaDerecha.usar(1, tiempo * 2));
    }

    public void propulsar(int tiempo) {
        consumirEnergia(botaIzquierda.usar(3, tiempo));
        consumirEnergia(botaDerecha.usar(3, tiempo));
    }

    public void volar(int tiempo) {
        consumirEnergia(botaIzquierda.usar(3, tiempo));
        consumirEnergia(botaDerecha.usar(3, tiempo));
        consumirEnergia(guanteIzquierdo.usar(2, tiempo));
        consumirEnergia(guanteDerecho.usar(2, tiempo));
    }

    public void usarGuantesComoArmas(int tiempo) {
        consumirEnergia(guanteIzquierdo.disparar(2, tiempo));
        consumirEnergia(guanteDerecho.disparar(2, tiempo));
    }

    public void escribirEnConsola(int tiempo) {
        consumirEnergia(consola.usar(1, tiempo));
    }

    public void hablarConSintetizador(int tiempo) {
        consumirEnergia(sintetizador.usar(1, tiempo));
    }

    private void consumirEnergia(float cantidad) {
        float energiaConsumida = generador.consumirEnergia(cantidad);
        // Actualizar estado de la armadura
    }
    
    public void mostrarEstado() {
        System.out.println("Estado de la Armadura:");
        System.out.println("Color primario: " + colorPrimario);
        System.out.println("Color secundario: " + colorSecundario);
        System.out.println("Nivel de resistencia: " + resistencia);
        System.out.println("Nivel de salud: " + salud);
        System.out.println("Estado de la batería: " + generador.obtenerCargaMaxima());
        System.out.println("Dispositivos:");

        System.out.println("Bota izquierda - Dañada: " + botaIzquierda.estaDanado());
        System.out.println("Bota derecha - Dañada: " + botaDerecha.estaDanado());
        System.out.println("Guante izquierdo - Dañado: " + guanteIzquierdo.estaDanado());
        System.out.println("Guante derecho - Dañado: " + guanteDerecho.estaDanado());
        System.out.println("Consola - Dañada: " + consola.estaDanado());
        System.out.println("Sintetizador - Dañado: " + sintetizador.estaDanado());
        System.out.println();
    }

    public void informarEstadoBateria() {
        float porcentajeCarga = (generador.obtenerCargaMaxima() / Float.MAX_VALUE) * 100;
        System.out.println("Estado de la batería: " + porcentajeCarga + "%");
    }

    public void informarEstadoReactor() {
        float cargaMaxima = generador.obtenerCargaMaxima();
        System.out.println("Estado del reactor en otras unidades de medida:");
        System.out.println("Carga máxima del reactor (float): " + cargaMaxima);
        System.out.println("Carga máxima del reactor (double): " + (double) cargaMaxima);
        System.out.println("Carga máxima del reactor (int): " + (int) cargaMaxima);
        System.out.println();
    }

    public void revisarDispositivos() {
        System.out.println("Revisando dispositivos:");
        Dispositivo[] dispositivos = { botaIzquierda, botaDerecha, guanteIzquierdo, guanteDerecho, consola, sintetizador };

        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.estaDanado()) {
                System.out.println("El dispositivo está dañado. Intentando reparar...");
                dispositivo.reparar();
                if (!dispositivo.estaDanado()) {
                    System.out.println("Reparación exitosa.");
                } else {
                    System.out.println("Reparación fallida. El dispositivo sigue dañado.");
                }
            } else {
                System.out.println("El dispositivo está en buen estado.");
            }
        }
        System.out.println();
    }
    
    public void destruirEnemigos(Radar radar) {
        System.out.println("Destruyendo enemigos:");
        Guante[] guantes = { guanteIzquierdo, guanteDerecho };
        for (ObjetoRadar objeto : radar.getObjetos()) {
            if (objeto.isHostil()) {
                for (Guante guante : guantes) {
                    if (!guante.estaDanado() && generador.obtenerCargaMaxima() > 0) {
                        double distancia = radar.calcularDistancia(objeto.getCoordenadaX(), objeto.getCoordenadaY(),
                                objeto.getCoordenadaZ());
                        if (distancia <= 5000) {
                            System.out.println("Disparando a enemigo a " + distancia + " metros.");
                            int potenciaDisparo = (int) (5000 / distancia); // Potencia inversamente proporcional a la distancia
                            objeto.recibirAtaque(potenciaDisparo);
                            float energiaConsumida = guante.disparar(2, 1); // Consumo de energía al disparar
                            generador.consumirEnergia(energiaConsumida);
                            if (objeto.estaDestruido()) {
                                System.out.println("Enemigo destruido.");
                            }
                        } else {
                            System.out.println("Enemigo fuera de alcance.");
                        }
                    } else {
                        System.out.println("Guante dañado o sin energía. No se puede disparar.");
                    }
                }
            }
        }
        System.out.println();
    }

    public void accionesEvasivas(float distanciaEvasion) {
        System.out.println("Realizando acciones evasivas:");
        if (generador.obtenerCargaMaxima() < generador.obtenerCargaMaxima() * 0.1) {
            System.out.println("Batería baja. Realizando acciones evasivas para alejarse de enemigos.");
            // Calcular tiempo necesario para alejarse 10 km a una velocidad promedio de 300 km/h
            int tiempoEvasion = (int) (distanciaEvasion / 300);
            System.out.println("Tiempo estimado de evasión: " + tiempoEvasion + " horas.");
            System.out.println("Realizando evasión...");
            // Simular acciones evasivas
            // ...
            // Actualizar estado de la armadura
            generador.consumirEnergia(10); // Consumo de energía por acciones evasivas
        } else {
            System.out.println("Batería suficiente. No se requieren acciones evasivas en este momento.");
        }
        System.out.println();
    }
}