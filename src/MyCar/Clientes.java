package MyCar;

import java.util.ArrayList;

public class Clientes {
	
	private String nombres;
	private String apellidos;
	private String rut;
	private String correo;
	private String fono;
	private ArrayList<Autos> autos = new ArrayList<>();
	
	public Clientes() {
		
	}
	
	public Clientes(String nombres, String apellidos, String rut, String correo, String fono) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.rut = rut;
		this.correo = correo;
		this.fono = fono;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public ArrayList<Autos> getAutos() {
		return autos;
	}

	public void setAutos(ArrayList<Autos> autos) {
		this.autos = autos;
	}
	
	public String autosCliente() {
		String autosCliente = "";
		for (Autos auto : this.autos) {
			autosCliente += "| PPU: "+auto.getPpu()+" |\n"
						  + "| Marca: "+auto.getMarca()+" |\n"
						  + "| Modelo: "+auto.getModelo()+" |\n"
						  + "| Año: "+auto.getFecha()+" |\n"
						  + "___________________________\n";
		}
		return autosCliente;
	}
	public void addAuto(Autos auto) {
		this.autos.add(auto);
	}
}