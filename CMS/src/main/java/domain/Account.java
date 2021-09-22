package domain;

import base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="account")
public class Account extends BaseEntity<Long> {

    @ManyToOne
    private User ownerAccount;

    @ManyToOne(cascade = CascadeType.ALL)
    private Bank branch;

    @OneToOne(cascade = CascadeType.ALL)
    private CreaditCard creaditCard;



    private double balance;

    private boolean isActive;
}
