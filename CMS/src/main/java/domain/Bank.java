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
    private Employee chief;

//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "workPlace")
//    private Set<Employee> employeeIds =new HashSet<>();
//
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bank")
//    @JoinTable("trans_per_acc")
//    private Set<Customer> customerIds =new HashSet<>();

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name ="trans_per_acc")
//    private Set<Account> accountIds=new HashSet<>();

}
