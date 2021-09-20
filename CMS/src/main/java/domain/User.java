package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class User {

    private String firstName;

    private String lastName;

    private String gender;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private String nationalCode;


}
