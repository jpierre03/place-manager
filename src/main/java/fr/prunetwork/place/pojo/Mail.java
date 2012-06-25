package fr.prunetwork.place.pojo;

import javax.persistence.*;

/**
 * @author Jean-Pierre PRUNARET
 *         Date: 25/06/12 21:58
 */
@Entity
@Table (name = "MAIL")
public class Mail {
    @Id
    @GeneratedValue
    @Column (name = "mail_id", nullable = false)
    private Long id;

    @Column (name = "mail_address", nullable = false)
    private String address;

    public Mail(String address) {
        assert (address != null);
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        assert (address != null);
        this.address = address;
    }
}
