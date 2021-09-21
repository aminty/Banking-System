package repository;

import base.repository.BaseEntityRepository;
import domain.CreaditCard;

public interface CreaditCardRepository extends BaseEntityRepository<CreaditCard,Long> {
    boolean isExistsByCardNumber(String cardNumber);

}
