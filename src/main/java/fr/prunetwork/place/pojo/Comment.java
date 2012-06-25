package fr.prunetwork.place.pojo;

import javax.persistence.*;

/**
 * @author Jean-Pierre PRUNARET
 *         Date: 25/06/12 21:37
 */
@Entity
@Table (name = "COMMENT")
public class Comment {
    @Id
    @GeneratedValue
    @Column (name = "comment_id", nullable = false)
    private Long id;

    @Column (name = "comment_name", nullable = false, unique = false)
    private String name;

    public Comment() {
    }

    public Comment(String name) {
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
