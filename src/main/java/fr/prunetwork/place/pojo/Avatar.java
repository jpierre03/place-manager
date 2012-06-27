package fr.prunetwork.place.pojo;

import jgravatar.Gravatar;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author Jean-Pierre PRUNARET
 *         Date: 27/06/12 20:06
 */
@Entity
@Table (name = "AVATAR")
public class Avatar {
    @Id
    @GeneratedValue
    @Column (name = "avatar_id", nullable = false)
    private Long id;

    @Column (name = "avatar_name", nullable = false)
    private String name;

    @Column (name = "avatar_image", nullable = false)
    private byte[] image;

    @Transient
    private BufferedImage bufferedImage;

    public Avatar() {
    }

    public Avatar(BufferedImage bufferedImage) {
        assert (bufferedImage != null);
        assert (bufferedImage.getHeight() > 0);
        assert (bufferedImage.getWidth() > 0);

        setBufferedImage(bufferedImage);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        assert (id != null);

        this.id = id;
    }

    public Image getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        assert (bufferedImage != null);
        assert (bufferedImage.getHeight() > 0);
        assert (bufferedImage.getWidth() > 0);

        try {
            this.bufferedImage = bufferedImage;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            //byte[] buffer = baos.toByteArray();

            image = baos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Avatar createGravatar(String mail) {
        Avatar avatar = null;
        try {
            URL url = new URL(new Gravatar().getUrl(mail));
            BufferedImage image = ImageIO.read(url);

            avatar = new Avatar(image);
        } catch (IOException e) {
        }
        return avatar;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        assert (image != null);
        assert (image.length > 0);

        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(image);
            BufferedImage img = ImageIO.read(bais);

            setBufferedImage(img);

            this.image = image;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
