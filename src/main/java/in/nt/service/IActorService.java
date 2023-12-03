package in.nt.service;

import java.util.List;

import in.nt.model.Actor;

public interface IActorService {
	public String add(Actor actor);

	public List<Actor> getActorDetails();

	public String updateNo(int id, Long no);

	public String update(Actor actor);
}
