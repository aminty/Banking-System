package service;

import base.service.BaseEntityService;
import domain.CreaditCard;

public interface CreaditCardService extends BaseEntityService<CreaditCard,Long> {
    CreaditCard generateCard();
}
