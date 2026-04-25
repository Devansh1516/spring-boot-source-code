package repo;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.bot;

public interface Botrepo extends JpaRepository<bot, Long> {

}
