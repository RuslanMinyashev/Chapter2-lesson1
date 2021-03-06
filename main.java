package ru.lesson1;
import java.util.Random;

public class main {
    public static void main(String[] args) {


        Random rand = new Random();
        Actions[] actions = new Actions[3];

        int distance = rand.nextInt(10);
        int heigth = rand.nextInt(10);
        actions[0] = new Human("Andrei", distance, heigth);

        distance = rand.nextInt(10);
        heigth = rand.nextInt(10);
        actions[1] = new Robot("U2", distance, heigth);

        distance = rand.nextInt(10);
        heigth = rand.nextInt(10);
        actions[2] = new Cat("Pushok", distance, heigth);

        Barrier[] barriers = new Barrier[9];

        boolean isRoad;
        for (int i = 0; i < barriers.length; i++) {
            distance = rand.nextInt(10);
            isRoad = rand.nextBoolean();
            if (isRoad) {
                barriers[i] = new Road(" " + i, distance);
            } else {
                barriers[i] = new Wall(" " + i, distance);
            }
        }

        for (int i = 0; i < actions.length; i++) {
            boolean result = true;
            for (int j = 0; j < barriers.length; j++) {

                result = barriers[j].moving(actions[i]);

                if (!result) {
                    break;
                }
            }

            if (result) {
                System.out.println("Success!!");
            } else {
                System.out.println("unsuccessfully!!");
            }
        }
    }
}
