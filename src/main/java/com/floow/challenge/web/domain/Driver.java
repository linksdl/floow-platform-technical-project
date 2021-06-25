package com.floow.challenge.web.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    @JsonIgnore
    @ApiModelProperty(required = false, hidden = true)
    private @Id String id;

    @JsonProperty(value = "first_name", required = true)
    @ApiModelProperty(name = "firstname",required = true)
    @JsonAlias("firstname")
    @NotBlank(message = "first name is mandatory")
    private String firstName;

    @JsonProperty(value = "last_name", required = true)
    @ApiModelProperty(name = "lastname", required = true)
    @JsonAlias("lastname")
    @NotBlank(message = "last name is mandatory")
    private String lastName;

    @JsonProperty(value = "date_of_birth",required = true)
    @ApiModelProperty(name = "date_of_birth",required = true)
    @JsonAlias("date_of_birth")
    @NotBlank(message = "date_of_birth is mandatory, the format is yyyy-MM-dd")
    private String dateOfBirth;

    @JsonIgnore
    @ApiModelProperty(required = false, hidden = true)
    private String creationDate;

}
