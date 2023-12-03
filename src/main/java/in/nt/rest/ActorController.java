package in.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nt.model.Actor;
import in.nt.service.IActorServiceImpl;

@RestController
@RequestMapping("/Actor/api")
public class ActorController {

	@Autowired
	private IActorServiceImpl service;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Actor actor) {
		try {
			String msg = service.add(actor);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/info")
	public ResponseEntity<?> getDetails() {
		try {
			List<Actor> actorDetails = service.getActorDetails();
			return new ResponseEntity<List<Actor>>(actorDetails, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PatchMapping("modify/{id}/{no}")
	public ResponseEntity<?> modifyNo(@PathVariable int id, @PathVariable long no) {
		try {
			String updateNo = service.updateNo(id, no);
			return new ResponseEntity<String>(updateNo, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modify")
	public ResponseEntity<?> updateInfo(@RequestBody Actor actor) {
		try {
			String update = service.update(actor);
			return new ResponseEntity<String>(update, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
