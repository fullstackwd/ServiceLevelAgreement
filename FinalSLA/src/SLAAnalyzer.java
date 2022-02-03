import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class SLAAnalyzer {
	
	 
     //Verificando e Corrigindo o Horário
	
    private LocalDateTime verificaHorario(LocalDateTime DataMaxima){
        int Horas = DataMaxima.getHour();
        int HoraLimite = 17;
        int HoraInicail = 8;
            
        if(HoraLimite < Horas)
        {
            DataMaxima = DataMaxima.plusDays(1);
            DataMaxima = DataMaxima.plusHours(15);  
        }
        else if (HoraInicail > Horas)
        {
            DataMaxima = DataMaxima.plusHours(9); 
        }
        return DataMaxima;
    }
    
     //Verificar e corrigir o dia
    
    private LocalDateTime verifiDiaDaSemana(LocalDateTime DataMaxima){
        DayOfWeek Dia = DataMaxima.getDayOfWeek();

        if( Dia.equals(DayOfWeek.SATURDAY))
        {
            DataMaxima = DataMaxima.plusDays(2);
        }
        else if(Dia.equals(DayOfWeek.SUNDAY))
        {
            DataMaxima = DataMaxima.plusDays(1);
        }
        return DataMaxima;
    }
    
    public LocalDateTime calculateSLA(LocalDateTime iOpeningDateTime, Integer iSLA)
    {
    	LocalDateTime DataMaxima = iOpeningDateTime.plusHours(iSLA);
        DataMaxima = verificaHorario(DataMaxima);
        DataMaxima = verifiDiaDaSemana(DataMaxima);      
        return DataMaxima;
    }

}
