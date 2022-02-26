package com.k2tech.springdatajpa.dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Guardian {

    @Column(name="guardian_name")
    private String name;
    @Column(name="guardian_email")
    private String email;
    @Column(name="guardian_mobile")
    private String mobile;
}
