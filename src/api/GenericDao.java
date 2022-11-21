package api;

import model.AEntity;
import model.Card;

import java.util.List;
/**
 * @author Павел Курило
 * @version 1.0
 */
public interface GenericDao<T extends AEntity> {

    void save(T entity);

    T getById(Long id);

    List<T> getAll();

    void delete(T entity);

    T update(T entity);

    List<Card> setRepository(List<T> list);
}

