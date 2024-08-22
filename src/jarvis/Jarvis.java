package jarvis;

import java.util.Random;

public class Jarvis {
    public static void main(String[] args) {
        // Crear una armadura de Iron Man
        Armadura ironMan = new Armadura("Rojo", "Oro", 100, 100);

        WarMachine cody = new WarMachine("Galting de Protones Ultron");

        cody.SaludarYDisparar();
        // Realizar algunas acciones
        ironMan.caminar(10);
        ironMan.volar(5);
        ironMan.usarGuantesComoArmas(3);

        // Mostrar el estado de la armadura
        ironMan.mostrarEstado();

        // Informar el estado de la batería
        ironMan.informarEstadoBateria();

        // Informar el estado del reactor en otras unidades de medida
        ironMan.informarEstadoReactor();

        // Revisar y reparar dispositivos dañados
        ironMan.revisarDispositivos();

        // Mostrar nuevamente el estado de la armadura después de la revisión y reparación
        ironMan.mostrarEstado();

        // Simular el uso del radar
        Radar radar = new Radar();
        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            ObjetoRadar objeto = new ObjetoRadar(random.nextDouble() * 100, random.nextDouble() * 100,
                    random.nextDouble() * 100, random.nextBoolean(), random.nextInt() * 100);
            radar.agregarObjeto(objeto);
        }

        // Informar distancias de enemigos hostiles detectados por el radar
        radar.informarDistanciaEnemigos();

        // Destruir enemigos si son hostiles y están dentro del alcance
        ironMan.destruirEnemigos(radar);

        // Realizar acciones evasivas si la batería es menor al 10%
        ironMan.accionesEvasivas(10);

        // Mostrar el estado final de la armadura
        ironMan.mostrarEstado();
    }
}
