package zup_teste.zup.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import net.bytebuddy.asm.Advice.Local;


@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"cpf", "email"} ) } )
public class User {

    @Id
    @NotNull(message = "CPF é obrigatório")
    @CPF(message = "CPF inválido")
    @Column(unique = true, nullable = false)
    private String cpf;

    @NotNull(message = "Nome é obrigatório")
    @Column(nullable = false, length = 50)
    private String nome;

    @Email(message = "Email inválido")
    @NotNull(message = "Email é obrigatório")
    @Column(nullable = false, length = 50)
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Data de Nascimento é obrigatório")
    @Column(unique = true, nullable = false, length = 10)
    private LocalDate dataNascimento;

    @JsonIgnore
    @ManyToMany(mappedBy="users")
    private List<Comic> comics;

    public User(String nome, String email, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public User() {

    }

    public List<Comic> getComics() {
        return this.comics;
    }

    public void setComics(List<Comic> comics) {
        this.comics = comics;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    
}
