package repo;

import org.springframework.data.jpa.repository.JpaRepository;


import entity.post;

public interface Postrepo extends JpaRepository<post, Long> {

}
