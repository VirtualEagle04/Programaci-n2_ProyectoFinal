package co.edu.unbosque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entity.Franquicia;
import co.edu.unbosque.repository.FranquiciaRepository;
import co.edu.unbosque.service.api.FranquiciaServiceAPI;
import co.edu.unbosque.utils.GenericServiceImpl;

@Service
public class FranquiciaServiceImpl extends GenericServiceImpl<Franquicia, Short> implements FranquiciaServiceAPI{

	@Autowired
	private FranquiciaRepository franquiciaRepository;
	
	@Override
	public CrudRepository<Franquicia, Short> getDao() {
		return franquiciaRepository;
	}

}
