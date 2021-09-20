package domain;

import base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ui.enumeration.Job;

import javax.persistence.*;

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

    @Enumerated(EnumType.STRING)
    private Job jobTitle;


    @ManyToOne
    private Bank workPlace;


    public boolean getIsChief() {
        return isChief;
    }

    public void setIsChief(boolean chief) {
        isChief = chief;
    }

}
