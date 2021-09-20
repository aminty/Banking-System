package domain;

import base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity<Long> {

    private String firstName;

    private String lastName;

    private String gender;

    private String birthDate;

    private String nationalCode;


}
