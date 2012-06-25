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

    @OneToOne
    @JoinColumn (name = "author_id", nullable = false)
    private Author author;

    @OneToOne
    @JoinColumn (name = "category_id", nullable = false)
    private Category category;

    @ManyToMany
    @JoinColumn (name = "comment_id", nullable = false)
    private Set<Comment> comments;


    public Place() {
    }

    public Place(String name, Author author, Category category) {
        assert (name != null);
        assert (author != null);
        assert (category != null);

        this.name = name;
        this.author = author;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
