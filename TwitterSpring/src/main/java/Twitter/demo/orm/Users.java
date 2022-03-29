package Twitter.demo.orm;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

   
    private Integer id;
    private String username;
    private String email;
    private String name;
    private Date birthDate;
    
    
    public Users(String username, String email, String name, Date birthDate) {
        
        this.username = username;
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
        
    }
    public Users() {
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    @Override
    public String toString() {
        return "Users [birthDate=" + birthDate + ", email=" + email + ", id=" + id + ", name=" + name + ", username="
                + username + "]";
    }
  
}
