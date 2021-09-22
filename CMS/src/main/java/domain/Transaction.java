package domain;

import base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ui.enumeration.TransactionType;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="transaction")

public class Transaction extends BaseEntity<Long> {
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private ZonedDateTime date= ZonedDateTime.now();

    private double withdrawAmount;

    @OneToOne
    private Account source;

    @OneToOne
    private Account destination;


}
