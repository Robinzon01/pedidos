package com.cdsi.web.app.service;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.cdsi.web.app.model.Arpfoe;

public interface IArpfoeService  {
	List<Arpfoe> getAllArpfoes();

	Arpfoe createArpfoe(Arpfoe arpfoe);
	
	//BUSCAR PEDIDO
	Arpfoe findByCiaAndOrden(String no_cia,String no_orden);
	
	//Pagination
    Page<Arpfoe> findAll(Pageable pageable);
	
}
