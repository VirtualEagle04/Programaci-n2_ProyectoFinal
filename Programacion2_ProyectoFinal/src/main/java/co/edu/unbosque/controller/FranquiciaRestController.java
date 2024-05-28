package co.edu.unbosque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.entity.Franquicia;
import co.edu.unbosque.service.api.FranquiciaServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/franquicia")
public class FranquiciaRestController {

	@Autowired
    private FranquiciaServiceAPI franquiciaServiceAPI;

    @GetMapping(value="/getAll")
    //ResponseEntity List<Franquicia> getAll(){
    public List<Franquicia> getAll(){
        return franquiciaServiceAPI.getAll();
    }


    @PostMapping(value="/saveFranquicia")
    public ResponseEntity<Franquicia> save(@RequestBody Franquicia franquicia){
        Franquicia obj = franquiciaServiceAPI.save(franquicia);
        return new ResponseEntity<Franquicia>(obj, HttpStatus.OK); // 200
    }

    @GetMapping(value="/findRecord/{id}")
    public ResponseEntity<Franquicia> getFranquiciaById(@PathVariable Short id)
            throws ResourceNotFoundException {
        Franquicia franquicia = franquiciaServiceAPI.get(id);
        if (franquicia == null){
            new ResourceNotFoundException("Record not found for <Franquicia>"+id);
        }
        return ResponseEntity.ok().body(franquicia);
    }

    @DeleteMapping(value="/deleteFranquicia/{id}")
    public ResponseEntity<Franquicia> delete(@PathVariable Short id){
        Franquicia franquicia = franquiciaServiceAPI.get(id);
        if (franquicia != null){
            franquiciaServiceAPI.delete(id);
        }else{
            return new ResponseEntity<Franquicia>(franquicia, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Franquicia>(franquicia, HttpStatus.OK);
    }
	
}
