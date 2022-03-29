package Twitter.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Twitter.demo.orm.Pages;

@Repository
public interface PagesRepository extends CrudRepository<Pages, Integer>{}

 
    

