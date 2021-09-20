package domain;

import base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee extends BaseEntity<Long> {
    @Embedded
    private User user;

    private String username;

    private String password;

    private boolean isChief;

    @ManyToOne
    private Employee chief;

    private String jobTitle;
    @ManyToOne
    private Bank workPlace;


}
