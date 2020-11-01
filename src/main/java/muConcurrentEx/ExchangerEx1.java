package muConcurrentEx;


// В примере использования объекта синхронизации Exchanger два почтальона из пунктов А и Б
// отправляются в соседние поселки В и Г доставить письма. Каждый из почтальонов должен доставить по письму в каждый из поселков.
// Чтобы не делать лишний круг, они встречаются в промежуточном поселке Д и обмениваются одним письмом.
// В результате этого каждому из почтальонов придется доставить письма только в один поселок.
// В примере все «шаги» почтальонов фиксируются выводом соответствующих сообщений в консоль.

import java.util.concurrent.Exchanger;

public class ExchangerEx1 {
    // Обменник почтовыми письмами
    private static Exchanger<Letter> EXCHANGER;

    static String msg1 = "Почтальон %s получил письма : %s, %s\n";
    static String msg2 = "Почтальон %s выехал из %s в %s\n";
    static String msg3 = "Почтальон %s приехал в Минск\n"; // пункт обмена
    static String msg4 = "Почтальон %s получил письма для %s\n";
    static String msg5 = "Почтальон %s привез в %s : %s, %s\n";

    public static class Postman implements Runnable {
        private String namePostman;
        private String departure;
        private String destination;
        private Letter[] letters;

        public Postman(String namePostman, String departure, String destination, Letter[] letters) {
            this.namePostman = namePostman;
            this.departure = departure;
            this.destination = destination;
            this.letters = letters;
        }

        @Override
        public void run() {
            try {
                System.out.printf(msg1, namePostman, letters[0], letters[1]); //получение писем
                System.out.printf(msg2, namePostman, departure, destination); //отправление
                Thread.sleep((long) (Math.random() * 5000 + 5000)); //почтальон едет
                System.out.printf(msg3, namePostman);
                // Самоблокировка потока для обмена письмами
                letters[1] = EXCHANGER.exchange(letters[1]);  // Обмен письмами с индексом 1 из каждого массива
                System.out.printf(msg4, namePostman, destination); // письмо об обмене
                Thread.sleep(1000 + (long) (Math.random() * 5000));
                System.out.printf(msg5, namePostman, destination, letters[0], letters[1]); //доставка писем
            } catch (InterruptedException e) {}
        }
    }

    public static class Letter {
        private String address;

        public Letter(final String address) {
            this.address = address;
        }

        public String toString() {
            return address;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        EXCHANGER = new Exchanger<>();
        // Формирование отправлений
        Letter[] posts1 = new Letter[2];
        Letter[] posts2 = new Letter[2];

        posts1[0] = new Letter("письмо Петрову");
        posts1[1] = new Letter("письмо Воробьеву");
        posts2[0] = new Letter("письмо Остапову");
        posts2[1] = new Letter("письмо Иванову");
        // Отправление почтальонов
        new Thread(new Postman("1", "Бреста", "Витебск", posts1)).start();
        Thread.sleep(100);
        new Thread(new Postman("2", "Бобруйска", "Гродно", posts2)).start();
    }

}
