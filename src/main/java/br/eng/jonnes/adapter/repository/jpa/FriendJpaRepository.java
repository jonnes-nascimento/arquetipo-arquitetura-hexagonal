package br.eng.jonnes.adapter.repository.jpa;

import br.eng.jonnes.adapter.repository.model.FriendJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendJpaRepository extends JpaRepository<FriendJpa, Integer> {
}
