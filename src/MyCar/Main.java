package MyCar;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	private static ArrayList<Autos> autos = new ArrayList<>();
	private static ArrayList<Clientes> clientes= new ArrayList<>();
	private static ArrayList<Mantenciones> mantenciones = new ArrayList<>();
	
	//MENU
	private final static int OPCION_MENU_AGREGAR_CLIENTES = 1;
	private final static int OPCION_MENU_AGREGAR_MANTENCIONES = 2;
	private final static int OPCION_MENU_ELIMINAR_CLIENTES = 3;
	private final static int OPCION_MENU_LISTA_MANTENCIONES = 4;
	private final static int OPCION_MENU_RECAUDACIONES = 5;
	private final static int OPCION_MENU_VER_CLIENTES = 6;
	

	private final static int OPCION_MENU_SALIR = 0;
	
	
	public static void main(String[] args) {
		menu();

	}

	private static void menu() {
		
		int opcion = 99;
		do {
			System.out.printf("BIENVENIDO%n"
							+"======================%n"
							+"1. Agregar clientes/auto%n"
							+"2. Agregar mantenciones de autos%n"
							+"3. Eliminar clientes%n"
							+"4. Lista de mantenciones%n"
							+"5. Recaudaciones del dia%n"
							+"6. Ver clientes%n"
							+"0. Salir%n%n"
							+"ELIJA UNA OPCION%n");

			
			try {
				opcion = scanner.nextInt();
	
				switch(opcion) {
					case OPCION_MENU_AGREGAR_CLIENTES:
						agregarCliente();
						break;
					case OPCION_MENU_ELIMINAR_CLIENTES:
						eliminarCliente();
						break;
					case OPCION_MENU_LISTA_MANTENCIONES:
						listarMantenciones();
						break;
					case OPCION_MENU_RECAUDACIONES:
						verRecaudaciones();
						break;
					case OPCION_MENU_AGREGAR_MANTENCIONES:
						agregarMantencion();
						break;
					case OPCION_MENU_VER_CLIENTES:
						verClientes();
						break;
					case OPCION_MENU_SALIR:
						System.out.println("Cerrando programa...");
						break;
					default:
						System.out.println("Opción escogida inválida. Intente de nuevo\n\n");
						break;
				}
			}catch(Exception e){
				System.out.println("Ingreso invalido.\n");
				scanner.nextLine();
			}	
		}while(opcion != OPCION_MENU_SALIR);
		
	}

	private static void verClientes() {
		for (Clientes cliente : clientes) {		
			System.out.printf("NOMBRE CLIENTE: %s %s%n"
							+ "RUT CLIENTE: %s%n"
							+ "FONO CLIENTE: %s%n"
							+ "CORREO CLIENTE: %s%n"
							+ "AUTOS REGISTRADOS: %n%n",
							cliente.getNombres(), cliente.getApellidos(),
							cliente.getRut(),
							cliente.getFono(),
							cliente.getCorreo());
			
			System.out.println(cliente.autosCliente());
		}
		
	}

	private static void agregarMantencion() {
		try {
			String stringAuto = "";
			if (autos.size() > 0) {
			System.out.println("AUTOS REGISTRADOS SIN MANTENCION");
			
				for (Autos auto : autos){
					if (auto.isMantenido() == false) {
					
					stringAuto += "=======================================\n"
								 +"PPU AUTO: "+auto.getPpu()+"\n"
								 +"MARCA AUTO: "+auto.getMarca()+"\n"
								 +"MODELO AUTO: "+auto.getModelo()+"\n"
								 +"FABRICACION AUTO: "+auto.getFecha()+"\n"
								 +"DUEÑO AUTO: "+auto.getPoseedor().getNombres()+" "+auto.getPoseedor().getApellidos()+"\n"
								 +"=======================================\n";
				}
			}
		}else {
			System.out.println("NO HAY AUTOS REGISTRADOS.");
			throw new Exception("No hay autos registrados");
			
		}
		if(stringAuto.equalsIgnoreCase("")) {
			System.out.println("NO HAY AUTOS A LOS QUE HACER MANTENCION");
			throw new Exception("No hay autos que mantener");
		}
		System.out.println(stringAuto);
		
		scanner.nextLine(); 
		
		// Pide la PPU del auto al que se le hizo mantencion
		System.out.println("Escriba PPU del auto al que se ha hecho mantencion");
		String ppuMantencion = scanner.nextLine();
		
		// Declara un Auto como nulo
		Autos autoMantencion = null;
		
		// BUSCA EL AUTO SEGUN PPU
		for(Autos auto : autos) {
			if(ppuMantencion.equalsIgnoreCase(auto.getPpu())) {
				autoMantencion = auto;
			}
		}
		if (autoMantencion == null){
			System.out.println("Auto no encontrado");
			throw new Exception("AUTO NO ENCONTRADO");
		}
		System.out.println("Escriba el tipo de mantencion realizado");
		String tipoMantencion = scanner.nextLine();
		
		System.out.println("Escriba observaciones realizadas");
		String observacionesMantencion = scanner.nextLine();
		
		System.out.println("Escriba monto cobrado");
		int montoMantencion = scanner.nextInt(); 
		
		Mantenciones mantencion = new Mantenciones(tipoMantencion,observacionesMantencion,montoMantencion,autoMantencion,LocalDate.now());
		mantenciones.add(mantencion);
		autoMantencion.setMantenido(true);
		}catch (Exception e) {
		}
	}

	
	private static void verRecaudaciones() {
		int recaudaciones = 0;
		int autosMantenidos = 0;
		
		for(Mantenciones mantencion : mantenciones) {
			recaudaciones += mantencion.getMontoServicio();
			autosMantenidos++;
		}
		listarMantenciones();
		System.out.printf("Recaudaciones totales: $%d%n "
						+ "Autos mantenidos: %d %n%n",
						recaudaciones,
						autosMantenidos);
		
	}

	private static void listarMantenciones() {
		System.out.println("Listado de mantenciones realizadas: \n===================================================");
		
		for(Mantenciones mantencion : mantenciones) {
			System.out.println("PPU AUTO MANTENIDO: "+mantencion.getAuto().getPpu());
			System.out.println("FECHA DE MANTENCION: "+mantencion.getFechaMantencion());
			System.out.println("DUEÑO DE AUTO MANTENIDO: "+mantencion.getAuto().getPoseedor().getNombres()+" "+mantencion.getAuto().getPoseedor().getApellidos());
			System.out.println("TIPO MANTENCION: "+mantencion.getMantencionRealizada());
			System.out.println("OBSERVACIONES: "+mantencion.getObservaciones());
			System.out.println("MONTO: "+mantencion.getMontoServicio());
			System.out.println("===================================================\n");
		}		
	}


	private static void eliminarCliente() {
		scanner.nextLine();
		
		System.out.println("Escriba el rut del cliente a eliminar: ");
		String rut = scanner.nextLine();
		
		for (Clientes cli : clientes) {
			if(rut.equalsIgnoreCase(cli.getRut())) {
				
				for (Autos auto : autos) {
					if(auto.getPoseedor().getRut().equalsIgnoreCase(rut) && auto.isMantenido() == false) {
						System.out.println("Se ha eliminado el auto (PPU): "+auto.getPpu());
						autos.remove(auto);
					}
				}
				
				System.out.printf("Se ha eliminado el cliente: %s %n%n", cli.getNombres());
				clientes.remove(cli);
				break;
			}
		}		
	}
	

	private static void agregarCliente() {
		scanner.nextLine(); 
		
		//DATOS CLIENTE
		System.out.println("Ingrese RUT del cliente");
		String rutCliente = scanner.nextLine();
		
		for(Clientes cli : clientes) {
			if (cli.getRut().equalsIgnoreCase(rutCliente)) {
				agregarAutos(cli);	
				break;
			}
		}
		
		System.out.println("Cliente no registrado. Ingrese datos del nuevo cliente.");
		System.out.println("Ingrese nombres del cliente");
		String nombresCliente = scanner.nextLine();
		
		System.out.println("Ingrese apellidos del cliente");
		String apellidosCliente = scanner.nextLine();
		
		System.out.println("Ingrese correo del cliente");
		String correoCliente = scanner.nextLine();

		System.out.println("Ingrese telefono del cliente");
		String fonoCliente = scanner.nextLine();
		
		//CREACION CLIENTE
		Clientes cliente = new Clientes(nombresCliente,apellidosCliente,rutCliente,correoCliente,fonoCliente);
		clientes.add(cliente);
		
		agregarAutos(cliente);
	}
	
	public static void agregarAutos(Clientes cliente){
		
		//DATOS AUTO
		boolean agregarAutos = true;
		try {
		do {
			System.out.println("Ingrese PPU del auto");
			String ppuAuto = scanner.nextLine().toUpperCase();
			
			System.out.println("Ingrese marca del auto");
			String marcaAuto = scanner.nextLine();
			
			System.out.println("Ingrese modelo del auto");
			String modeloAuto = scanner.nextLine();
			
			System.out.println("Ingrese año de fabricacion del auto");
			int yearAuto = scanner.nextInt();
			if (yearAuto < 1960 || String.valueOf(yearAuto).length() > 4) {
				throw new Exception("PARAMETROS INVALIDOS. INTENTE DE NUEVO");
			}
						
			
			Autos auto = new Autos(ppuAuto,marcaAuto,modeloAuto,yearAuto,cliente,false);
			autos.add(auto); 
			cliente.addAuto(auto); // AÑADE EL AUTO REGISTRADO AL CLIENTE
			
			scanner.nextLine(); 
			
			System.out.println("¿Desea seguir añadiendo autos? (si/no)");
			String decision = scanner.nextLine();
			
			if(decision.equalsIgnoreCase("NO")) {
				agregarAutos = false;
				break;
			}	
		}while(agregarAutos);
		}catch(Exception e) {
			System.out.println("Parametros invalidos. Intente de nuevo");
		}
	}

}