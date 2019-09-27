package com.cdsi.web.app.repository;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cdsi.web.app.model.Arpfoe;
import com.cdsi.web.app.model.IdArpfoe;

@Repository
public interface IArpfoeRepository extends PagingAndSortingRepository<Arpfoe,IdArpfoe> {
	
	Page<Arpfoe> findAll(Pageable pageable);
	
	//BUSCAMOS EL PEDIDO POR COMPAÑIA Y CODIGO DE PEDIDO
	@Query("SELECT a FROM Arpfoe a WHERE a.objIdArp.no_cia =:no_cia AND a.objIdArp.no_orden =:no_orden")
	Arpfoe findByCiaAndOrden(@Param("no_cia") String no_cia,@Param("no_orden") String no_orden );
	
}
