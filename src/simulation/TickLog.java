package simulation;

public class TickLog {

    private StringBuilder sb = new StringBuilder();

    void line(String text) {
        sb.append(text).append('\n');
    }

    void flush(){
        System.out.println(sb);
        sb.setLength(0);
    }
}
