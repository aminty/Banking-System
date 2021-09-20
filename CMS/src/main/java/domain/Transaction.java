package domain;

import base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="transaction")

public class Transaction extends BaseEntity<Long> {

    private String transactionType;

    private Date transactionDate;

    @OneToOne
    private Account source;

    @OneToOne
    private Account destination;


}
