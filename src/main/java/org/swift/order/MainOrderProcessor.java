package org.swift.order;

public class MainOrderProcessor {

	
	
	private static final MainOrderProcessor orderProcessor = new MainOrderProcessor();

	public static MainOrderProcessor getInstance() {
		return orderProcessor;
	}

	public static void main(String args[]) throws Exception {

		System.out.println("\n********************\nWelcome to Everest Order Processing Company!!");
		try {
			UserLoginHelper userLoginHandler = UserLoginHelper.getInstance();
			userLoginHandler.validateUser();
			RuleHelper ruleHandler = RuleHelper.getInstance();
			ruleHandler.showRuleOperationMenu();
		} catch (Exception e) {
			System.out.println("System has experienced some error, Please try later!");
		}
	}

}
