package com.spring.aop.services;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.spring.aop.model.Account;
import com.spring.aop.model.Accounts;

public class AccountServicesImpl implements AccountServices {

	private final static File xmlFile = new File(
			"D:/Project_Drive/Andriod_Development/WORK_SPACE_ANDROID_APPS_RD/aop/src/main/resources/accounts-db.xml");
	private static Map<String, Account> accountsMap = null;
	private static Account loggedInAccount = null;

	public boolean loginService(String loginId, String loginByType, String password) {
		// Account account = getAccountDetailViaDOM(loginId, loginByType,
		// password);
		Account account = getAccountDetailViaJAXB(loginId, loginByType, password);
		if(account == null){
			throw new RuntimeException("Login Exception");
		}
		return account != null;
	}

	private Account getAccountDetailViaJAXB(String loginId, String loginByType, String password) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Accounts.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			Accounts accounts = (Accounts) jaxbUnmarshaller.unmarshal(xmlFile);
			System.out.println(accounts.getAccountList().size());
			for (Account account : accounts.getAccountList()) {

				System.out.println(account.getAccountNumber());
				// change to log with logback.xml
				accountsMap = new HashMap<String, Account>();
				accountsMap.put(account.getAccountNumber(), account);

				if (("account".equalsIgnoreCase(loginByType) && account.getAccountNumber().equalsIgnoreCase(loginId))
						|| ("account".equalsIgnoreCase(loginByType) && account.getCustomerName().equalsIgnoreCase(
								loginId))) {
					loggedInAccount = account;
				}

			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return loggedInAccount;
	}

	private Account getAccountDetailViaDOM(String loginId, String loginByType, String password) {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("account");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("account Number : " + eElement.getAttribute("accountNumber"));
					System.out.println("account Number : " + eElement.getAttribute("customerName"));
					System.out.println("account Number : " + eElement.getAttribute("balance"));
				}
			}
			System.out.println("----------------------------");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account checkBalance(String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account deposit(String accountNumber, String amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account withDrawal(String accountNumber, String amount) {
		// TODO Auto-generated method stub
		return null;
	}

}
