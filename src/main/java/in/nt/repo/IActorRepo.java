package in.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nt.model.Actor;

public interface IActorRepo extends JpaRepository<Actor, Integer> {

}
