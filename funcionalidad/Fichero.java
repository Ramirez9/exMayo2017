package exMayo2017FranciscoRamirezRuiz.funcionalidad;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Se encarga de la lectura/escritura en el sistema de ficheros
 * 
 * @author Francisco Ramirez Ruiz
 *
 */
public class Fichero implements Serializable{
	
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	
	private static String leerUTF;
	private static LocalDate leerObjeto;
	public static General general;
	
	/**
	 * Escribe en un fichero
	 * 
	 * @param localDate
	 * @param file
	 * @throws ErrorAlGuardarException
	 */
	public static void escribir(LocalDate localDate, File file) throws ErrorAlGuardarException {
		file = annadirExtension(file);
		
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file)))) {
			objectOutputStream.writeObject(localDate);
			objectOutputStream.writeUTF(Datos.FRANCISCO_RAMIREZ_RUIZ);
		} catch (IOException e) {
			throw new ErrorAlGuardarException("Error al guardar del fichero.");
		}
	}

	/**
	 * Lee de un fichero y lo devuleve
	 * @param file
	 * @return
	 * @throws ErrorAlLeerException
	 */
	public static Datos leer(File file) throws ErrorAlLeerException {
		
		try (ObjectInputStream objectInputStream = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(file)))) {
			leerObjeto = (LocalDate) objectInputStream.readObject();
			leerUTF = objectInputStream.readUTF();
			return new Datos(leerObjeto, leerUTF);
		} catch (IOException | ClassNotFoundException e) {
			throw new ErrorAlLeerException("Error al leer el fichero.");
		}
		
	}
	/**
	 * Añade la extensión fec sólo en caso de ser necesario
	 * 
	 * @param file
	 * @return Fichero con la extensión ".fec"
	 */
	private static File annadirExtension(File file) {

		String path = file.getPath();
		if (!path.endsWith(".fec"))
			return new File(path + ".fec");
		return file;
	}
}
