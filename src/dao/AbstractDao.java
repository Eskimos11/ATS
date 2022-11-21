package dao;

import api.GenericDao;
import exceptions.NotFoundByIdException;
import model.AEntity;
import model.Card;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Павел Курило
 * @version 1.0
 */
public abstract class AbstractDao<T extends AEntity> implements GenericDao<T> {

    private List<T> repository = new ArrayList<>();
    @Override
    public void save(T entity) {
        repository.add(entity);
    }

    @Override
    public T getById(Long id) throws NotFoundByIdException {
        for(T entity: repository){
            if(id.equals(entity.getId())){
                return entity;
            }
        }
        throw new NotFoundByIdException();
    }

    @Override
    public List<Card> setRepository(List<T> repository) {
        this.repository = repository;
        return null;
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(repository);
    }


    @Override
    public void delete(T entity) {
        repository.remove(entity);
    }

    @Override
    public T update(T entity) {
        return null;
    }
}
