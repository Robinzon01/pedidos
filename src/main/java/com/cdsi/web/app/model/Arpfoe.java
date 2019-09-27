package com.cdsi.web.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ARPFOE")
public class Arpfoe implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
    private IdArpfoe objIdArp;
	
	private String no_cliente;
	private String no_vendedor;
	private Date fecha_registro;
	
	@OneToMany(mappedBy = "arpfoe",fetch = FetchType.EAGER)
	private List<Arpfol> arpfols;
		

	public List<Arpfol> getArpfols() {
		return arpfols;
	}

	public void setArpfols(List<Arpfol> arpfols) {
		this.arpfols = arpfols;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}


	public IdArpfoe getObjIdArp() {
		return objIdArp;
	}

	public void setObjIdArp(IdArpfoe objIdArp) {
		this.objIdArp = objIdArp;
	}

	public String getNo_cliente() {
		return no_cliente;
	}

	public void setNo_cliente(String no_cliente) {
		this.no_cliente = no_cliente;
	}

	public String getNo_vendedor() {
		return no_vendedor;
	}

	public void setNo_vendedor(String no_vendedor) {
		this.no_vendedor = no_vendedor;
	}
    

}
