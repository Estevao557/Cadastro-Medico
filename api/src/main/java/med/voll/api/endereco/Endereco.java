package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.function.Consumer;

@Embeddable
@Getter
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
    }

    public Endereco() {
        // Initialize default values, if needed
    }

    public void atualizaInformacoes(DadosEndereco dados) {
        atualizaValor(dados.logradouro(), logradouro -> this.logradouro = logradouro);
        atualizaValor(dados.bairro(), bairro -> this.bairro = bairro);
        atualizaValor(dados.cep(), cep -> this.cep = cep);
        atualizaValor(dados.cidade(), cidade -> this.cidade = cidade);
        atualizaValor(dados.numero(), numero -> this.numero = numero);
        atualizaValor(dados.complemento(), complemento -> this.complemento = complemento);
        atualizaValor(dados.uf(), uf -> this.uf = uf);
    }

    private <T> void atualizaValor(T valor, Consumer<T> setter) {
        if (valor != null) {
            setter.accept(valor);
        }
    }

}
