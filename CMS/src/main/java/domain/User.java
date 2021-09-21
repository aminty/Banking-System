package domain;

import base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ui.enumeration.Gender;
import ui.enumeration.Job;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseEntity<Long> {

    private String firstName;

    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private String nationalCode;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Job jobTitle;

    private boolean isChief;


}
