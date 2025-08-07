package tp1.ejercicio7;
import java.util.LinkedList;
import java.util.Scanner; 

public class TestListaEstudiante<T> {
	private LinkedList<T> listEstu;

	public TestListaEstudiante(){
		this.listEstu = new LinkedList<>();
	}

	
	public int listLenght () {
		return this.listEstu.size();
	}
	
    public void agregar (T elem) {
    	this.listEstu.add(elem);
    }
	
    public void eliminar (int i) {
        if (this.listEstu.isEmpty()) {
            System.out.println(" La lista está vacía. ");
            return;
        }
        if (i >= 0 && i < this.listLenght()) {
            this.listEstu.remove(i);
        } else {
            System.out.println(" Índice fuera de rango. ");
        }
    }

    public void agregarSiNoEsta(T elem) {
    	if (! this.listEstu.contains(elem)) {
    		this.agregar(elem);
    	}else {
    		System.out.println(" El Alumno ya estaba en la lista. ");
    	}
    }
    
    public void mostrarLista() {
    	for(T elem:listEstu) {
    		System.out.println(elem);
    	}
    }
    /*
    public TestListaEstudiante<T> copiarConConstructor() {
        return new TestListaEstudiante<>(new LinkedList<>(this.listEstu));
    }*/

    public TestListaEstudiante<T> copiarConAddAll() {
        TestListaEstudiante<T> nuevaLista = new TestListaEstudiante<>();
        nuevaLista.listEstu.addAll(this.listEstu);
        return nuevaLista;
    }

    /*public TestListaEstudiante<T> copiarConClone() {
        TestListaEstudiante<T> nuevaLista = new TestListaEstudiante<>();
        nuevaLista.listEstu = (LinkedList<T>) this.listEstu.clone();
        return nuevaLista;
    }*/
    
    
    public static void main (String[] args) {
    	Scanner s = new Scanner(System.in);
    	TestListaEstudiante<Estudiante> le = new TestListaEstudiante<Estudiante>();
    	int n = s.nextInt();
    	s.nextLine();
    	for (int i=0; i < n; i++) {
    		System.out.println("Ingrese Nombre del Alumno: ");
    		String nom = s.nextLine(); 
    		System.out.println("Ingrese Apellido del Alumno: ");
    		String ape = s.nextLine();
    		System.out.println("Ingrese Email del Alumno: ");
    		String mail = s.nextLine();
    		System.out.println("Ingrese Comision del Alumno: ");
    		String comi = s.nextLine();
    		System.out.println("Ingrese Direccion del Alumno: ");
    		String direc = s.nextLine();
    		le.agregar(new Estudiante(nom,ape,mail,comi,direc));
    	}
    	
    	TestListaEstudiante<Estudiante> ln = le.copiarConAddAll();// verdadera copia.
    	/* se observa que haciendolo de esta manera
    	   TestListaEstudiante<Estudiante> ln = le;
    	   no crea una verdadera copia sino que ahora apuntan al mismo
    	   lugar, o sea que si se modifica le modificara tambien ln
    	   y viceversa. 
    	   
    	   de la otra manera de la cual lo hice no se modifican.
    	   
    	 */
        System.out.println(" Lista Original: ");
        le.mostrarLista();
    	
        System.out.println(" Lista Copia: ");
        ln.mostrarLista();
        
        le.eliminar(0);
        ln.eliminar(1);
        
        le.agregar(new Estudiante("sinDatos", "sinDatos","sinDatos","sinDatos","sinDatos"));
        ln.agregar(new Estudiante("sinDatos1", "sinDatos1","sinDatos1","sinDatos","sinDatos"));
        
        System.out.println(" Lista Original: ");
        le.mostrarLista();
    	
        System.out.println(" Lista Copia: ");
        ln.mostrarLista();
        
        Estudiante estuE = new Estudiante("Genio", "Crack","genicrack@gmail.com","LaDeLosGenios","FarFarAway");
        
        le.agregarSiNoEsta(estuE);
        le.mostrarLista();
    	s.close();
    	
    }
}
