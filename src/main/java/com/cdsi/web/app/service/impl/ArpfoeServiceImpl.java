package com.cdsi.web.app.service.impl;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.cdsi.web.app.model.Arpfoe;
import com.cdsi.web.app.repository.IArpfoeRepository;
import com.cdsi.web.app.service.IArpfoeService;

@Service
public class ArpfoeServiceImpl implements IArpfoeService {
    
	@Autowired
	private IArpfoeRepository arpfoeRepository;
	
	@Override
	public List<Arpfoe> getAllArpfoes() {
		List<Arpfoe> arpfoes = new ArrayList<Arpfoe>();
		arpfoeRepository.findAll().iterator().forEachRemaining(arpfoes::add);
		return arpfoes;
	}

	@Override
	public Arpfoe createArpfoe(Arpfoe arpfoe) {
		Arpfoe objArpfoe = arpfoeRepository.save(arpfoe);
		return objArpfoe;
	}

	@Override
	public Page<Arpfoe> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return arpfoeRepository.findAll(pageable);
	}

	@Override
	public Arpfoe findByCiaAndOrden(String no_cia, String no_orden) {
		
		Arpfoe arpfoe = arpfoeRepository.findByCiaAndOrden(no_cia, no_orden);
		
		return arpfoe;
		
	}


	

}
