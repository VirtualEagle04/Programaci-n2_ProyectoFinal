package co.edu.unbosque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.entity.EntidadFinanciera;
import co.edu.unbosque.service.api.EntidadFinancieraServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/entidadFinanciera")
public class EntidadFinancieraRestController {

	@Autowired
	private EntidadFinancieraServiceAPI entidadFinancieraServiceAPI;

	@GetMapping(value = "/getAll")
	// ResponseEntity List<EntidadFinanciera> getAll(){
	public List<EntidadFinanciera> getAll() {
		return entidadFinancieraServiceAPI.getAll();
	}

	@PostMapping(value = "/saveEntidadFinanciera")
	public ResponseEntity<EntidadFinanciera> save(@RequestBody EntidadFinanciera entidadFinanciera) {
		EntidadFinanciera obj = entidadFinancieraServiceAPI.save(entidadFinanciera);
		return new ResponseEntity<EntidadFinanciera>(obj, HttpStatus.OK); // 200
	}

	@GetMapping(value = "/findRecord/{id}")
	public ResponseEntity<EntidadFinanciera> getEntidadFinancieraById(@PathVariable Short id)
			throws ResourceNotFoundException {
		EntidadFinanciera entidadFinanciera = entidadFinancieraServiceAPI.get(id);
		if (entidadFinanciera == null) {
			new ResourceNotFoundException("Record not found for <EntidadFinanciera>" + id);
		}
		return ResponseEntity.ok().body(entidadFinanciera);
	}

	@DeleteMapping(value = "/deleteEntidadFinanciera/{id}")
	public ResponseEntity<EntidadFinanciera> delete(@PathVariable Short id) {
		EntidadFinanciera entidadFinanciera = entidadFinancieraServiceAPI.get(id);
		if (entidadFinanciera != null) {
			entidadFinancieraServiceAPI.delete(id);
		} else {
			return new ResponseEntity<EntidadFinanciera>(entidadFinanciera, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<EntidadFinanciera>(entidadFinanciera, HttpStatus.OK);
	}

}
