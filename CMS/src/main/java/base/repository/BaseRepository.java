package base.repository;

import base.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<E extends BaseEntity<ID>, ID extends Serializable> {

    E save(E e);

    void remove(E e);

    List<E> findAll();

    E findById(ID id);

    boolean existsById(ID id);





}
