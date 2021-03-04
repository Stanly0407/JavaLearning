package multithreaded.semaphore;

import java.util.ArrayList;
import java.util.List;

public class SemaphoreMain {

    // см. стр. 404 Блинов 2020г.

    public static void main(String[] args) {
        List<AudioChannel> audioChannels = new ArrayList<>() {
            {
                this.add(new AudioChannel(771));
                this.add(new AudioChannel(883));
                this.add(new AudioChannel(550));
                this.add(new AudioChannel(337));
                this.add(new AudioChannel(442));
            }
        };
        ChannelPool<AudioChannel> pool = new ChannelPool<>(audioChannels);
        for (int i = 0; i < 20; i++) {
            new Client(pool).start();
        }

    }
}
