package MyCar;

import java.time.LocalDate;

public class Mantenciones {

	private String mantencionRealizada;
	private String observaciones;
	private int montoServicio;
	private LocalDate fechaMantencion;
	private Autos auto;
	
	public Mantenciones() {
		
	}
	
	public Mantenciones(String mantencionRealizada, String observaciones, int montoServicio, Autos auto, LocalDate fechaMantencion) {
		this.mantencionRealizada = mantencionRealizada;
		this.observaciones = observaciones;
		this.montoServicio = montoServicio;
		this.auto = auto;
		this.fechaMantencion = fechaMantencion;
	}

	public String getMantencionRealizada() {
		return mantencionRealizada;
	}

	public void setMantencionRealizada(String mantencionRealizada) {
		this.mantencionRealizada = mantencionRealizada;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getMontoServicio() {
		return montoServicio;
	}

	public void setMontoServicio(int montoServicio) {
		this.montoServicio = montoServicio;
	}

	public Autos getAuto() {
		return auto;
	}

	public void setAuto(Autos auto) {
		this.auto = auto;
	}

	public LocalDate getFechaMantencion() {
		return fechaMantencion;
	}

	public void setFechaMantencion(LocalDate fechaMantencion) {
		this.fechaMantencion = fechaMantencion;
	}
	
	
	
}