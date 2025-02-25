package com.ltech.pagamentos.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    @NotEmpty(message = "{validation.notempty}")
    private String username;

    @NotEmpty(message = "{validation.notempty}")
    private String password;

    private boolean enabled;

    @NotEmpty(message = "{validation.notempty}")
    private String firstName;

    @NotEmpty(message = "{validation.notempty}")
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Roles> roles = new ArrayList<>();

    @ManyToOne
    private TipoUsuario tipoUsuario;

    private String cpf;

    private String numIdentidade;

    private String numCarteiraTrabalho;

    private LocalDate dataNascimento;

    private LocalDate dataAdmissao;

    public String getFullname() {
        return this.getFirstName() + " " + this.getLastName();
    }

}
