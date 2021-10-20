/*/////////////////En tête////////////////////////////
 * Programme : Generer clé
 *
 * Description : Programme qui créer des clé pour plusieurs types
 *             d'algos cryptographiques
 *
 * Auteur : Christophe LAGAILLARDE
 *
 * Date : 11/10/2021
 * 
 * Version : 1.0
 *        
 *///////////////////////////////////////////////////

// Déclaration des bibliotheques de fonctions...

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

//////////////////Le Programme principal/////////////

//////////////////Début//////////////////////////////
public class GenererCle {

	static void genClef(String algo,SecretKey CleSecretDeLAlgo) {
		KeyGenerator keyGen;
		String hexadecimal;
		byte[] key2byte;

		try {
			keyGen = KeyGenerator.getInstance(algo);

			CleSecretDeLAlgo = keyGen.generateKey();
					
			// On convertie la clé obtenue en tableau d'octet
			key2byte = CleSecretDeLAlgo.getEncoded();
			
			// On convertie en notation hexadécimal 
			hexadecimal = new BigInteger(1,key2byte).toString(16);

			System.out.printf("Clé " + algo + ": %s \n",hexadecimal);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.err.println("Erreur, cet Algo n'est pas disponible ou bien n'existe pas.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Déclaration
		SecretKey CleSecretDeLAlgo = null;
		String algo = "";
		
		System.out.print("Saisir l'algo à utiliser :");
		Scanner saisieUtilisateur= new Scanner(System.in); 
		algo = saisieUtilisateur.nextLine(); 
		saisieUtilisateur.close();
		
		genClef(algo,CleSecretDeLAlgo);

		


	}

}
