package multithreaded.semaphore;

public class Client extends Thread {
    private ChannelPool<AudioChannel> pool;

    public Client(ChannelPool<AudioChannel> pool) {
        this.pool = pool;
    }

    public void run() {
        AudioChannel channel = null;
        try {
            channel = pool.getResource(this, 500); // change to 100
            channel.using();
        } catch (Exception e) {
            System.err.println("Client #" + this.getId() + " lost ->" + e.getMessage());
        } finally {
            if (channel != null) {
                pool.releaseResource(this, channel);
            }
        }
    }


}
