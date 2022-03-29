package Twitter.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Twitter.demo.orm.Posts;

@Repository
public interface PostsRepository extends CrudRepository<Posts, Long>{}
