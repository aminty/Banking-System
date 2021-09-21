package domain;

import base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="bank")

public class Bank extends BaseEntity<Long> {

    private String bName;

    @OneToOne
    private User chief;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<User> bankUsers =new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL)
    private Set<Account> accountIds=new HashSet<>();

}
