package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentosConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component
public class ValidaHoraDeFuncionamento implements ValidadorAgendamentoDeConsulta {

    public  void validar(DadosAgendamentosConsulta dadosAgendamentosConsulta) {
        // Valida se a hora de agendamento está dentro do horário de funcionamento
        // do médico
        var data = dadosAgendamentosConsulta.data();
        var domingo  = data.getDayOfWeek().equals(DayOfWeek.SUNDAY);

        var  antesDaAberturaDaCliniaca = data.getHour() < 7;
        var  depoisDoFechamentoDaClinica = data.getHour() > 18;

        if(domingo || antesDaAberturaDaCliniaca || depoisDoFechamentoDaClinica){
            throw new ValidacaoException("Horário de funcionamento da clínica é de segunda a sábado das 7h às 18h");
        }
    }
}
