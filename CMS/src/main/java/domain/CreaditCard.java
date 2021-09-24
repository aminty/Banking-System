package domain;

import base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "creadit")

public class CreaditCard extends BaseEntity<Long> {

    @Column(unique = true)
    private String cardNumber;

    private String cvv2;

    private String expDate;

    private String pinCode;

    private boolean isBlockCard;

    private boolean isActiveCard;


}
