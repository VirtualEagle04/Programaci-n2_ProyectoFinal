package co.edu.unbosque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.entity.MediosDePago;
import co.edu.unbosque.service.api.MediosDePagoServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/mediosDePago")
public class MediosDePagoRestController {

	@Autowired
	private MediosDePagoServiceAPI mediosDePagoServiceAPI;

	@GetMapping(value = "/getAll")
	// ResponseEntity List<MediosDePago> getAll(){
	public List<MediosDePago> getAll() {
		return mediosDePagoServiceAPI.getAll();
	}

	@PostMapping(value = "/saveMediosDePago")
	public ResponseEntity<MediosDePago> save(@RequestBody MediosDePago mediosDePago) {
		MediosDePago obj = mediosDePagoServiceAPI.save(mediosDePago);
		return new ResponseEntity<MediosDePago>(obj, HttpStatus.OK); // 200
	}

	@GetMapping(value = "/findRecord/{id}")
	public ResponseEntity<MediosDePago> getMediosDePagoById(@PathVariable Short id) throws ResourceNotFoundException {
		MediosDePago mediosDePago = mediosDePagoServiceAPI.get(id);
		if (mediosDePago == null) {
			new ResourceNotFoundException("Record not found for <MediosDePago>" + id);
		}
		return ResponseEntity.ok().body(mediosDePago);
	}

	@DeleteMapping(value = "/deleteMediosDePago/{id}")
	public ResponseEntity<MediosDePago> delete(@PathVariable Short id) {
		MediosDePago mediosDePago = mediosDePagoServiceAPI.get(id);
		if (mediosDePago != null) {
			mediosDePagoServiceAPI.delete(id);
		} else {
			return new ResponseEntity<MediosDePago>(mediosDePago, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<MediosDePago>(mediosDePago, HttpStatus.OK);
	}

}
