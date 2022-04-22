package MyCar;

public class Autos {
	private String ppu;
	private String marca;
	private String modelo;
	private boolean mantenido;
	private int fecha;
	private Clientes poseedor;
	
	public Autos(){
	}
	
	public Autos(String ppu, String marca, String modelo, int fecha, Clientes poseedor, boolean mantenido) {
		super();
		this.fecha = fecha;
		this.ppu = ppu;
		this.marca = marca;
		this.modelo = modelo;
		this.poseedor = poseedor;
		this.setMantenido(mantenido);
		
	}

	public String getPpu() {
		return ppu;
	}

	public void setPpu(String ppu) {
		this.ppu = ppu;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getFecha() {
		return fecha;
	}
	
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public Clientes getPoseedor() {
		return poseedor;
	}

	public void setPoseedor(Clientes poseedor) {
		this.poseedor = poseedor;
	}

	public boolean isMantenido() {
		return mantenido;
	}

	public void setMantenido(boolean mantenido) {
		this.mantenido = mantenido;
	}

	
	
}