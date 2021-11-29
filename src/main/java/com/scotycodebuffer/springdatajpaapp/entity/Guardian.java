package com.scotycodebuffer.springdatajpaapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name ="guardian_name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "mobile", // jakie pole nadpisywane oraz osadzane
                column = @Column(name ="guardian_mobile") // tutaj nadpisanie musi być zgodne z columną w bazie danych
        )
})
public class Guardian {

    private String name;
    private String email;
    private String mobile;
}
