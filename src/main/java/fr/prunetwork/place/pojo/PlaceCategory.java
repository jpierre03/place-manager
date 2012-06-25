package fr.prunetwork.place.pojo;

import javax.persistence.*;

/**
 * @author Jean-Pierre PRUNARET
 *         Date: 25/06/12 21:12
 */
@Entity
@Table (name = "PLACE_CATEGORY")
public class PlaceCategory {
    @Id
    @GeneratedValue
    @Column (name = "place_category_id", nullable = false)
    private Long id;

    @Column (name = "place_category_name", nullable = false)
    private String name;

    public PlaceCategory(String name) {
        assert (name != null);
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        assert (name != null);
        this.name = name;
    }
}
