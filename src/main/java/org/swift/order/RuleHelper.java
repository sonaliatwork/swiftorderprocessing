package org.swift.order;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RuleHelper implements OrderProcessingOperations {
	private static final RuleHelper ruleHelper = new RuleHelper();
	private final String RULE_DETAIL_FILENAME = "RULEDETAILS";
	private final int FIELD_COUNT_RULE_DETAILS = 7;
	private String singleRecordFromFile = "";
	private final Console console = System.console();

	public static RuleHelper getInstance() {
		return ruleHelper;
	}

	public Rule createRule() {

		String ruleDefinition = "";
		String paymentStatus = "";
		String action = "";
		String ruleOwner = "";
		String actionOwner = "";
		String ruleActive = "Y";
		Rule rule = new Rule();
		String fields[] = new String[FIELD_COUNT_RULE_DETAILS];
		BufferedReader br = null;

		try {
			File file = getFileContent(getFileLocation());
			br = new BufferedReader(new FileReader(file));
			String line = "";
			int lastRuleId = 0;
			int newRuleId = 0;
			String lastrecord = "";
			while ((line = br.readLine()) != null) {
				lastrecord = line;
			}

			fields = lastrecord.split(" ");
			if (!(fields == null || fields.length < FIELD_COUNT_RULE_DETAILS)) {
				System.out.println("fields[0]" + fields[0]);
				String lastrecordId = fields[0];
				lastRuleId = lastrecordId == null ? 0 : Integer.parseInt(lastrecordId);
				newRuleId = lastRuleId + 1;
			}
			rule.setRuleId(String.valueOf(newRuleId));
			console.printf("\n Please enter all Details to create new rule: \n");
			console.printf("\n (While adding new rule, you cannot use 'space') \n");
			console.printf("\n Please enter your Rule Definition: ");
			ruleDefinition = console.readLine();
			console.printf("\n Please enter your Payment Status: ");
			paymentStatus = console.readLine();
			console.printf("\n Please enter your Rule Action: ");
			action = console.readLine();
			console.printf("\n Please enter your Rule Owner: ");
			ruleOwner = console.readLine();
			console.printf("\n Please enter your Rule Action Owner: ");
			actionOwner = console.readLine();

			ruleDefinition = ((ruleDefinition != null) ? ruleDefinition.trim().replace(" ", "_") : "");
			rule.setRuleDefinition(ruleDefinition);
			paymentStatus = ((paymentStatus != null) ? paymentStatus.trim().replace(" ", "_") : "");
			rule.setPaymentStatus(paymentStatus);
			action = ((action != null) ? action.trim().replace(" ", "_") : "");
			rule.setAction(action);
			ruleOwner = ((ruleOwner != null) ? ruleOwner.trim().replace(" ", "_") : "");
			rule.setRuleOwner(ruleOwner);
			actionOwner = ((actionOwner != null) ? actionOwner.trim().replace(" ", "_") : "");
			rule.setActionOwner(actionOwner);
			rule.setRuleActive(ruleActive);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rule;
	}
	
	void createRuleActivities()
	{


		storeDetailsInFile(createRule());
		showAll();
	}

	@Override
	public List<Rule> readAll() {
		List<Rule> rules = new ArrayList<Rule>();
		String[] subFields = new String[FIELD_COUNT_RULE_DETAILS];

		BufferedReader br;
		try {
			File file = getFileContent(getFileLocation());
			br = new BufferedReader(new FileReader(file));

			while ((singleRecordFromFile = br.readLine()) != null) {
				subFields = singleRecordFromFile.split(" ");

				Rule rule = new Rule();
				rule.setRuleId(subFields[0]);
				rule.setRuleDefinition(subFields[1]);
				rule.setPaymentStatus(subFields[2]);
				rule.setAction(subFields[3]);
				rule.setRuleOwner(subFields[4]);
				rule.setActionOwner(subFields[5]);
				rule.setRuleActive(subFields[6]);
				rules.add(rule);

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rules;

	}

	@Override
	public void update() {
		showAll();
		Rule recordToBeUpdated = (Rule) search();
		// write code to update this record from file
	}

	@Override
	public void delete() {
		showAll();
		Rule recordToBeDeleted = (Rule) search();
		// write code to delete this record from file
	}

	public void WriteInTheFile(String rule) {

		File fileWrite = getFileContent(getFileLocation());

		try {
			FileOutputStream out = new FileOutputStream(fileWrite, true);

			if (rule != null) {
				out.write(rule.toUpperCase().getBytes("UTF-8"));
			} else
				System.out.println("New recorded to be written in file is not available!");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Object search() {

		int ruleIdToSearch = 0;
		int attemptCounter = 0;
		String ruleIdByUser = "";
		boolean recordFound = false;
		Rule rule = new Rule();
		showAll();
		try {
			while (!recordFound) {
				console.printf("\nPlease enter the valid rule Id which you want to update:");
				ruleIdByUser = console.readLine();

				if (ruleIdToSearch == 0 && attemptCounter++ == 3) {
					console.printf("\nYou have exhausted all the search attempts, Try again later!");
					break;
				}

				List<Rule> records = readAll();
				String ruleId = "";
				Iterator<Rule> itr = records.iterator();

				while (itr.hasNext()) {

					rule = itr.next();
					ruleId = rule.getRuleId();

					if (ruleId.equals(ruleIdByUser)) {
						console.printf("\n Record found : ");
						console.printf(rule.toString());
						return rule;
					}
				}

				if (!recordFound)
					console.printf("\nSorry, No record found!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rule;

	}

	@Override
	public void showAll() {
		List<Rule> rules = readAll();
		Iterator<Rule> itr = rules.iterator();
		while (itr.hasNext()) {
			Rule rule = itr.next();
			if (rule == null)
				break;
			else
				console.printf(rule.toString());
		}

	}

	public void storeDetailsInFile(Rule rule) {
		String ruleRepresentation = "\n" + rule.getRuleId() + " " + rule.getRuleDefinition() + " "
				+ rule.getPaymentStatus() + " " + rule.getAction() + " " + rule.getRuleOwner() + " "
				+ rule.getActionOwner() + " " + rule.getRuleActive();

		WriteInTheFile(ruleRepresentation);
	}

	@Override
	public String getFileLocation() {
		String fileLocation = "";
		try {
			fileLocation = PropertiesConfiguration.getInstance().getPropertiesConfiguration(RULE_DETAIL_FILENAME);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return fileLocation;
	}

	public File getFileContent(String fileLocation) {

		File file = new File(getClass().getClassLoader().getResource(fileLocation).getFile());
		return file;
	}

	public void showRuleOperationMenu() {
		while (true) {

			console.printf(
					"\nAvailable Operations : \n1. Show All Rules \n2. Create New Rule \n3.Search Existing Rule \n4. Update Rule \n5. Delete Rule \n6.exit");
			console.printf("\n\nPlease select the operation number you want to perform :");
			String operationNumber = console.readLine();
			switch (operationNumber) {
			case "1":
				showAll();
				break;
			case "2":
				create();
				break;
			case "3":
				search();
				break;
			case "4":
				console.printf("Work In progress, Please Try Later!");
				break;
			case "5":
				console.printf("Work In progress, Please Try Later!");
				break;
			case "6":
				console.printf("Exiting from the System, Thank you!");
				System.exit(0);
			default :
				console.printf("\n#Wrong Option, enter correct operation number!\n**********\n");
			}
		}
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}
}
