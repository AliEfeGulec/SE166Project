package cells;

public interface ServiceConsumer {
    public void receiveService(String service);


    public boolean isServed(String service);
}
