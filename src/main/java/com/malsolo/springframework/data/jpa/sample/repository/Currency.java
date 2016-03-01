package com.malsolo.springframework.data.jpa.sample.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

    @Id
    @Column(name = "CODE", nullable = false)
    @Size(max = 3)
    @NotNull
    private String code;

    @Column(name = "NUM")
    @Max(999)
    @Min(0)
    private Integer num;

    @Column(name = "DIGITS")
    private Integer digits;

    @Column(name = "NAME")
    private String name;

}
