package model;
/**
 * @author Павел Курило
 * @version 1.0
 */
public abstract class AEntity {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}