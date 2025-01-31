package com.ltech.pagamentos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{validation.notempty}")
    @Size(min = 4, max = 30, message = "O nome precisa ter entre 4 e 30 caracteres")
    @Column(length = 30)
    private String name;

    @NotEmpty(message = "{validation.notempty}")
    @Email(message = "{validation.email}")
    @Column(length = 255)
    private String email;

    @Column(length = 255)
    private String address;

}
