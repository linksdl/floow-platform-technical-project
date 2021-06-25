package com.floow.challenge.web.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    private @Id Long id;

    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private String createDate;

}
