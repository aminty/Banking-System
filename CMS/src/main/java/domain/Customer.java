package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer")

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {


    @Column(name = "customer_id", unique = true, nullable = false)
    private Long customerId;


    @OneToMany
    @Column(name = "account_id")
    private List<Account> accountIds = new ArrayList<>();



}
