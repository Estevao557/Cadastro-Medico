package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentosConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidaHorario  implements ValidadorAgendamentoDeConsulta {
    public void validar(DadosAgendamentosConsulta dadosAgendamentosConsulta) {
        // Valida se a hora de agendamento está dentro do horário de funcionamento
        // do médico
        var dataConsulta = dadosAgendamentosConsulta.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();


        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com no mínimo 30 minutos de antecedência");
        }
    }
}
