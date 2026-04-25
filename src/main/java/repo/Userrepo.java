package repo;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.user;

public interface Userrepo extends JpaRepository<user, Long> {

}
