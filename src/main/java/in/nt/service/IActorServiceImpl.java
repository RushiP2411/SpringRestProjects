package in.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nt.exception.ActorNotFoundException;
import in.nt.model.Actor;
import in.nt.repo.IActorRepo;

@Service
public class IActorServiceImpl implements IActorService {

	@Autowired
	private IActorRepo repo;

	@Override
	public String add(Actor actor) {
		Actor ac = repo.save(actor);
		return "Actor details saved with " + ac.getActorId() + "id";

	}

	@Override
	public List<Actor> getActorDetails() {
		List<Actor> list = repo.findAll();
		list.sort((t1, t2) -> t1.getActorName().compareTo(t2.getActorName()));
		return list;
	}

	@Override
	public String updateNo(int id, Long no) {
		Optional<Actor> optional = repo.findById(id);
		if (optional.isPresent()) {
			Actor actor = optional.get();
			actor.setMobileNo(no);
			repo.save(actor);
			return "actors mobile no is updated..";
		} else {
			throw new ActorNotFoundException("Actor Not Found");
		}
	}

	@Override
	public String update(Actor actor) {
		Optional<Actor> optional = repo.findById(actor.getActorId());
		if (optional.isPresent()) {
			repo.save(actor); // update object
			return "information is updated..";
		} else {
			throw new ActorNotFoundException("Actor Not Found..");
		}
	}

}
