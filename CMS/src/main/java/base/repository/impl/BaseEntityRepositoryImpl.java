package base.repository.impl;

import base.domain.BaseEntity;
import base.repository.BaseEntityRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public  abstract class BaseEntityRepositoryImpl<E extends BaseEntity<ID>, ID extends Serializable>
        implements BaseEntityRepository<E,ID> {
 protected final EntityManager entityManager;
    public BaseEntityRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
     public abstract Class<E> getEntityClass();

    @Override
    public E save(E e) {
       if (e.getId()==null)
           entityManager.persist(e);
       else
           entityManager.merge(e);
       return e;
    }


    @Override
    public List<E> findAll() {
        return entityManager.createQuery(
                "from " + getEntityClass().getSimpleName(),
                getEntityClass()
        ).getResultList();
    }

    @Override
    public boolean existsById(ID id) {
        return entityManager.createQuery(
                "select count(id) from " + getEntityClass().getSimpleName() +
                        " where id = :id",
                Long.class
        ).setParameter("id", id)
                .getSingleResult() == 1L;
    }

    @Override
    public void remove(E e) {
        if (e.getId()!=null)
            entityManager.remove(e);

    }

    @Override
    public E findById(ID id) {
        return entityManager.find(getEntityClass(),id);

    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
