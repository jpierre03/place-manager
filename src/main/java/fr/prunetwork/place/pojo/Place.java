package fr.prunetwork.place.pojo;

import javax.persistence.*;

/**
 * @author Jean-Pierre PRUNARET
 *         Date: 25/06/12 21:06
 */
@Entity
@Table (name = "PLACE")
public class Place {
    @Id
    @GeneratedValue
    @Column (name = "place_id", nullable = false)
    private Long id;

    @Column (name = "place_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn (name = "author_id", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn (name = "place_category_id", nullable = false)
    private PlaceCategory placeCategory;

    public Place() {
    }

    public Place(String name, Author author, PlaceCategory placeCategory) {
        assert (name != null);
        assert (author != null);
        assert (placeCategory != null);

        this.name = name;
        this.author = author;
        this.placeCategory = placeCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        assert (id != null);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        assert (name != null);
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public PlaceCategory getPlaceCategory() {
        return placeCategory;
    }

    public void setPlaceCategory(PlaceCategory placeCategory) {
        this.placeCategory = placeCategory;
    }
}
