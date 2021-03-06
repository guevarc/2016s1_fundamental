/**
 * 
 */
package fr.tbr.iamcore.tests.services;

import java.io.IOException;

import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.exception.DAOInitializationException;
import fr.tbr.iamcore.exception.DAOSaveException;
import fr.tbr.iamcore.service.dao.IdentityFileDAO;

/**
 * @author tbrou
 *
 */
public class TestIdentityFileDAO {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args){
//		testDaoInitialization();
//		testDaoSave();
		
		Identity identityToBeSaved = new Identity("thomas", "tbr@tbr.com", "123");
		IdentityFileDAO dao = null;
		try {
			dao = new IdentityFileDAO("/Work/test/identities.txt");
		} catch (DAOInitializationException e) {
			e.printStackTrace();
			return;
		}
		if (dao != null){
			try {
				dao.save(identityToBeSaved);
			} catch (DAOSaveException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(dao.search(null));
		
		

	}

	private static void testDaoSave() {
		Identity identityToBeSaved = new Identity("thomas", "tbr@tbr.com", "123");
		IdentityFileDAO dao = null;
		try {
			dao = new IdentityFileDAO("/Work/test/identities.txt");
		} catch (DAOInitializationException e) {
			e.printStackTrace();
			return;
		}
		if (dao != null){
			try {
				dao.save(identityToBeSaved);
			} catch (DAOSaveException e) {
				e.printStackTrace();
			}
		}
	}

	private static void testDaoInitialization() {
		try {
			IdentityFileDAO dao = new IdentityFileDAO(null);
		} catch (DAOInitializationException e) {
			e.printStackTrace();
			System.out.println("the system was not able to initialize, exiting...");
			System.out.println("got this error : " + e.getInitializationFault());
			return;
		}
	}

}
