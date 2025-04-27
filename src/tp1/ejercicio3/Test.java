package tp1.ejercicio3;
import java.util.Scanner;


public class Test {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in) ;
		Profesor[] profes = new Profesor[3];
		Estudiante[] estudiantes = new Estudiante[2];
		for (int i=0; i < 3; i++) {
			String nom; String ape; String mail; String cate; String facu;
			System.out.println(" Ingrese nombre del Profesor: ");
			nom = s.next();
					s.nextLine();
			System.out.println(" Ingrese apellido: ");
			ape = s.next();
			s.nextLine();
			System.out.println(" Ingrese Email: ");
			mail = s.next();
			s.nextLine();
			System.out.println(" Ingrese Catedra: ");
			cate = s.next();
			s.nextLine();
			System.out.println(" Ingrese Facultad: ");
			facu = s.next();
			s.nextLine();
			profes[i] = new Profesor(nom,ape,mail,cate,facu);
		}
        for (int i=0; i < 2; i++) {
        	String nom1, ape1,mail1,comi, direc;
			System.out.println(" Ingrese nombre de alumno: ");
			nom1 = s.next();
			s.nextLine();
			System.out.println(" Ingrese apellido: ");
			ape1 = s.next();
			s.nextLine();
			System.out.println(" Ingrese Email: ");
			mail1 = s.next();
			s.nextLine();
			System.out.println(" Ingrese Comision: ");
			comi = s.next();
			s.nextLine();
			System.out.println(" Ingrese Direccion: ");
			direc = s.next();
			s.nextLine();
			estudiantes[i] = new Estudiante(nom1,ape1,mail1,comi, direc);
			
		}
        s.close();
        
        for (int i=0; i < 3; i++) {
        	System.out.println((i+1) + ": " + profes[i].toString() + "\n");
        }
        
        for (int i=0; i < 2; i++) {
        	System.out.println((i+1) + ": " + estudiantes[i].toString() + "\n");
        }
	}

}
