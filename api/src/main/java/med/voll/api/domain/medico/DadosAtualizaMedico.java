package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizaMedico(
        @NotNull
        Long id,
        String telefone,
        String nome,

        String email,

        DadosEndereco endereco,

        Especialidade especialidade
) {
}
