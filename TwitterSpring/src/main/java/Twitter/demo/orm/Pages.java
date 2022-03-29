package Twitter.demo.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String linkAddress;
    //private Posts post;

    public Pages(String linkAddress) {
        this.linkAddress = linkAddress;
    }/*
    public Posts getPost() {
        return post;
    }
    public void setPost(Posts post) {
        this.post = post;
    }*/
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLinkAddress() {
        return linkAddress;
    }
    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

}
