package base.service.impl;

import base.domain.BaseEntity;
import base.repository.BaseEntityRepository;
import base.service.BaseEntityService;

import java.io.Serializable;
import java.util.List;

public  abstract class BaseEntityServiceImpl<E extends BaseEntity<ID>,
        ID extends Serializable, R extends BaseEntityRepository<E,ID>>
        implements BaseEntityService<E,ID> {

    protected final R repository;

    protected BaseEntityServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
       repository.getEntityManager().getTransaction().begin();
       repository.save(e);
       repository.getEntityManager().getTransaction().commit();
       return e;
    }

    @Override
    public void remove(E e) {
        repository.getEntityManager().getTransaction().begin();
        repository.remove(e);
        repository.getEntityManager().getTransaction().commit();

    }

    @Override
    public List<E> findAll() {
        return findAll();
    }

    @Override
    public E findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }
}
