package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.User;
import repository.UserRepository;

import javax.persistence.EntityManager;

public class UserRepositoryImpl extends BaseEntityRepositoryImpl<User, Long> implements UserRepository {
    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;


    }

    @Override
    public User fingByUsername(String username) {
        return entityManager.createQuery(
                "from "+getEntityClass().getSimpleName()+ " where username=:username",getEntityClass())
                .setParameter("username",username).getSingleResult();
    }

    @Override
    public boolean isExistsByUsername(String username) {
        return entityManager.createQuery(
                "select count(username) from "+ getEntityClass().getSimpleName()+" where username =:username",
                Long.class).setParameter("username",username).getSingleResult()==1L;
    }

    @Override
    public boolean isExistsByNationalCode(String nationalCode) {
        return entityManager.createQuery(
                "select count(nationalCode) from "+ getEntityClass().getSimpleName()+" where nationalCode =:nationalCode",
                Long.class).setParameter("nationalCode",nationalCode).getSingleResult()==1L;
    }
}
