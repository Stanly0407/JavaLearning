package muConcurrentEx;

public class Passenger {
    private static String WAIT = " ждёт на станции ";
    private static String ENTER = " вошел в вагон";
    private static String EXIT = " вышел из вагона ";
    private static String SPACE = "    ";

    int id;
    int departure;
    int destination;

    public Passenger(int id, int departure, int destination) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        System.out.println(this + WAIT + departure);
    }

    @Override
    public void run() {
        try {
            System.out.println(SPACE + this + ENTER);
            //-----------------------------------------------
            // Заявляем об участии и ждем станции назначения
            while (PHASER.getPhase() < destination)
                PHASER.arriveAndAwaitAdvance();
            //----------------------------------------------
            Thread.sleep(500);
            System.out.println(SPACE + this + EXIT);
            // Отмена регистрации
            PHASER.arriveAndDeregister();
        } catch (InterruptedException e) {
        }
    }

    @Override
    public String toString() {
        return "Пассажир " + id +
                " {" + departure + " -> " + destination + '}';
    }
}
