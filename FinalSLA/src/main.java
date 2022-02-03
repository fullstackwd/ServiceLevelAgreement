
import java.time.LocalDateTime;

public class main {

    public static void main(String[] args) {

        SLAAnalyzer tempo = new SLAAnalyzer();

        LocalDateTime DataInicial = LocalDateTime.parse("2019-08-01T02:00:00.001");
        System.out.println("Open date: " + DataInicial.toString());
        
        LocalDateTime Data = tempo.calculateSLA(DataInicial, 5);
        System.out.println("Close date: " + Data.toString());
        
    }
    
}
