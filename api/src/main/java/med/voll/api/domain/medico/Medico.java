package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.endereco.Endereco;

import java.util.function.Consumer;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    private String telefone;

    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private  Boolean ativo;


    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizaInformacoes(DadosAtualizaMedico dados) {
        atualizaValor(dados.nome(), nome -> this.nome = nome);
        atualizaValor(dados.telefone(), telefone -> this.telefone = telefone);
        if (dados.endereco() != null) {
            this.endereco.atualizaInformacoes(dados.endereco());
        }
        atualizaValor(dados.especialidade(), especialidade -> this.especialidade = especialidade);
        atualizaValor(dados.email(), email -> this.email = email);
    }

    private <T> void atualizaValor(T valor, Consumer<T> setter) {
        if (valor != null) {
            setter.accept(valor);
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}