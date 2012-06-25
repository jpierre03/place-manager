package fr.prunetwork.place.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany
    @JoinColumn (name = "comment_id", nullable = false)
    private Set<Comment> comments;


    public Place() {
    }

    public Place(String name, Author author, PlaceCategory placeCategory) {
        assert (name != null);
        assert (author != null);
        assert (placeCategory != null);

        this.name = name;
        this.author = author;
        this.placeCategory = placeCategory;
        this.comments = new HashSet<Comment>();
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

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        assert (comments != null);
        assert (!comments.isEmpty());
        assert (comments.size() > 0);

        this.comments = comments;
    }

    public void addComment(Comment comment) {
        assert (comment != null);
        assert (comments != null);

        comments.add(comment);
    }
}
