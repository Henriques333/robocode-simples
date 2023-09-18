# robocode-simples 
# https://github.com/Henriques333/robocode-simples.git
//Jorge Vinícius | meuRobo |

package meuPacote;

/**
 * Aluno - a class by (Aluno - Jorge Vinícius dos Santos Henriques)
 */
import robocode.*;

public class MeuRobo extends Robot {
    boolean escaneouRobo = false; // Adicionamos uma variável de controle

    public void run() {
        while(true) {
            ahead(90); // Move para a frente
            turnGunRight(150); // Gira o canhão em um movimento ai

            if (escaneouRobo) {
                // Se escaneou um robô, mova-se para os lados
                turnRight(90); // para direita
                ahead(30);//avançar
                turnLeft(180);//para esquerda
                ahead(10);
                turnRight(90);//´para direita

                escaneouRobo = false; // Reseta a variável de controle
            }
        }
    }

public void onScannedRobot(ScannedRobotEvent e) { //escanear
    String robotName = e.getName(); // guarda nome
    double distancia = e.getDistance(); // guarda distancia
    System.out.println(robotName + " está a uma distância de " + distancia + " unidades.");
	if (distancia < 135){
		fire(3);
	} else if (distancia >135 && distancia < 300){
		fire(1.5);
	} else
		fire(1);
}

    public void onHitWall(HitWallEvent evento) { 
        back(90); // Move para trás quando bate na parede
        turnRight(90); // Gira 90 graus após bater na parede
    }
}
