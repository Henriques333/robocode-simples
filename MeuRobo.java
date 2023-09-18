package meuPacote;
/**
 *  Aluno - Jorge Vinícius dos Santos Henriques
 */
import robocode.*;

public class MeuRobo extends Robot {
    boolean escaneouRobo = false; // Adicionamos uma variável de controle

    public void run() {
        while(true) {
            ahead(90); // Move para a frente
            turnGunRight(190); // Gira o canhão em um movimento ai

            if (escaneouRobo) {
                // Se escaneou um robô, mova-se para os lados
                turnRight(90);
                ahead(50);
                turnLeft(180);
                ahead(10);
                turnRight(91);

                escaneouRobo = false; // Reseta a variável de controle
            }
        }
    }

public void onScannedRobot(ScannedRobotEvent e) {
    String robotName = e.getName(); // guarda nome
    double distancia = e.getDistance(); // guarda distancia
    System.out.println(robotName + " está a uma distância de " + distancia + " unidades.");
	if (distancia < 135){
		fire(3);
	} else{
		fire(1.3);
	}
}

    public void onHitWall(HitWallEvent evento) {
        back(90); // Move para trás quando bate na parede
        turnRight(90); // Gira 90 graus após bater na parede
    }
}