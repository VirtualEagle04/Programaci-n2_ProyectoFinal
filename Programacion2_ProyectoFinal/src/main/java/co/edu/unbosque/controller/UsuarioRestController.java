package co.edu.unbosque.controller;


import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.service.api.UsuarioServiceAPI;
import co.edu.unbosque.utils.EmailService;
import co.edu.unbosque.utils.ResourceNotFoundException;
import co.edu.unbosque.utils.SHA1Encrypter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

    @Autowired
    private UsuarioServiceAPI usuarioServiceAPI;
    
    private EmailService emailService;
    
    public UsuarioRestController(EmailService emailService) {
    	this.emailService = emailService;
	}

    @GetMapping(value="/getAll")
    //ResponseEntity List<Usuario> getAll(){
    public List<Usuario> getAll(){
        return usuarioServiceAPI.getAll();
    }


    @PostMapping(value="/saveUsuario")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) throws NoSuchAlgorithmException{
    	usuario.setClave(SHA1Encrypter.encryptSHA1(usuario.getClave()));
        Usuario obj = usuarioServiceAPI.save(usuario);
        emailService.sendEmail(usuario);
        return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
    }

    @GetMapping(value="/findRecord/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Short id)
            throws ResourceNotFoundException {
        Usuario usuario = usuarioServiceAPI.get(id);
        if (usuario == null){
            new ResourceNotFoundException("Record not found for <Usuario>"+id);
        }
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping(value="/deleteUsuario/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Short id){
        Usuario usuario = usuarioServiceAPI.get(id);
        if (usuario != null){
            usuarioServiceAPI.delete(id);
        }else{
            return new ResponseEntity<Usuario>(usuario, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }
    
    @PostMapping(value="/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) throws NoSuchAlgorithmException{
    	if(usuario.getLogin().equals("admin") && usuario.getClave().equals("admin")) {
    		return new ResponseEntity<Usuario>(usuarioServiceAPI.get((short) 1), HttpStatus.OK);
    	}else {
    		List<Usuario> listaUsuarios = usuarioServiceAPI.getAll();
    		for(int i = 0; i < listaUsuarios.size(); i++) {
    			Usuario tempU = listaUsuarios.get(i);
    			if(usuario.getLogin().equals(tempU.getLogin()) && SHA1Encrypter.encryptSHA1(usuario.getClave()).equals(tempU.getClave())) {
    				return new ResponseEntity<Usuario>(usuarioServiceAPI.get((short) tempU.getId()), HttpStatus.OK);
    			}
    		}
    	}
    	return new ResponseEntity<Usuario>(usuario, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @PostMapping(value="/signup")
    public ResponseEntity<Usuario> signup(@RequestBody Usuario usuario) throws NoSuchAlgorithmException{
    	usuario.setClave(SHA1Encrypter.encryptSHA1(usuario.getClave()));
        Usuario obj = usuarioServiceAPI.save(usuario);
        return new ResponseEntity<Usuario>(obj, HttpStatus.OK); // 200
    }
}