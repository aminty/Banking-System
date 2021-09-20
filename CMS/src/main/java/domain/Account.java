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
public class Account extends BaseEntity<Long> {

    @ManyToOne
    private Customer customerId;


    @ManyToOne(cascade = CascadeType.ALL)
    private Bank branchName;

    @OneToOne(cascade = CascadeType.ALL)
    private CreaditCard creaditCardId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    private double balance;

    private boolean isActive;
}
