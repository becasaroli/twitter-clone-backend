package Twitter.demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import Twitter.demo.orm.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer>{

    List<Users> findByUsername(String username);

        
    }
