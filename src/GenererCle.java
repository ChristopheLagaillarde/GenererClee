/*/////////////////En t�te////////////////////////////
 * Programme : Generer cl�
 *
 * Description : Programme qui cr�er des cl� pour plusieurs types
 *             d'algos cryptographiques
 *
 * Auteur : Christophe LAGAILLARDE
 *
 * Date : 11/10/2021
 * 
 * Version : 1.0
 *        
 *///////////////////////////////////////////////////

// D�claration des bibliotheques de fonctions...

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

//////////////////Le Programme principal/////////////

//////////////////D�but//////////////////////////////
public class GenererCle {

	static void genClef(String algo,SecretKey CleSecretDeLAlgo) {
		KeyGenerator keyGen;
		String hexadecimal;
		byte[] key2byte;

		try {
			keyGen = KeyGenerator.getInstance(algo);

			CleSecretDeLAlgo = keyGen.generateKey();
					
			// On convertie la cl� obtenue en tableau d'octet
			key2byte = CleSecretDeLAlgo.getEncoded();
			
			// On convertie en notation hexad�cimal 
			hexadecimal = new BigInteger(1,key2byte).toString(16);

			System.out.printf("Cl� " + algo + ": %s \n",hexadecimal);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.err.println("Erreur, cet Algo n'est pas disponible ou bien n'existe pas.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//D�claration
		SecretKey CleSecretDeLAlgo = null;
		String algo = "";
		
		System.out.print("Saisir l'algo � utiliser :");
		Scanner saisieUtilisateur= new Scanner(System.in); 
		algo = saisieUtilisateur.nextLine(); 
		saisieUtilisateur.close();
		
		genClef(algo,CleSecretDeLAlgo);

		


	}

}
