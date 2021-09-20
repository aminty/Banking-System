package domain;

import base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreaditCard extends BaseEntity<Long> {


    private Long cardNumber;

    private int cvv2;

    private String expDate;

    private int pinCode;

    private boolean isBlockCard;

    private boolean isActiveCard;


}
