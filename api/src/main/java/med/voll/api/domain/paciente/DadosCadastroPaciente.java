package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroPaciente(
        @NotBlank(message = "{DadosCadastroPaciente.nome}") // Utiliza a chave no messages.properties
        String nome,

        @NotBlank(message = "{DadosCadastroPaciente.email}")
        @Email(message = "{DadosCadastroPaciente.email.invalid}")
        String email,

        @NotBlank(message = "{DadosCadastroPaciente.telefone}")
        String telefone,

        @NotBlank(message = "{DadosCadastroPaciente.cpf}")
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}", message = "{DadosCadastroPaciente.cpf.invalid}")
        String cpf,

        @NotNull(message = "{DadosCadastroPaciente.endereco}")
        @Valid
        DadosEndereco endereco
) {
}
