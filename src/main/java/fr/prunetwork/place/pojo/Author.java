package fr.prunetwork.place.pojo;

import javax.persistence.*;

/**
 * @author Jean-Pierre PRUNARET
 *         Date: 25/06/12 21:01
 */
@Entity
@Table (name = "AUTHOR")
public class Author {
    @Id
    @GeneratedValue
    @Column (name = "author_id", nullable = false)
    private Long id;

    @Column (name = "author_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn (name = "mail_id")
    private Mail mail;

    public Author(String name, Mail mail) {
        assert (name != null);
        assert (mail != null);
        this.name = name;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        assert (name != null);
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        assert (id != null);
        this.id = id;
    }
}
