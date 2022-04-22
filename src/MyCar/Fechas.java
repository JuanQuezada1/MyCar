package MyCar;

import java.time.LocalDateTime;

public class Fechas {

	public LocalDateTime fecha;
	
    public Fechas() {
	}
	public Fechas(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}