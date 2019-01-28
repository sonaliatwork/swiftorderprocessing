package org.swift.order;


public class Rule {
	private String ruleId = "";
	private String ruleDefinition = "";
	private String action = "";
	private String ruleOwner = "";
	private String actionOwner = "";
	private String ruleActive = "";
	private String paymentStatus = "";

	@Override
	public String toString() {
		return "\n\n\nRuleId=" + ruleId + ", \tRuleDefinition=" + ruleDefinition + ", "
				+ "\nAction=" + action + ", \tRule_Owner=" + ruleOwner + ","
				+ "\nAction_Owner=" + actionOwner + ",\t Payment Status=" + paymentStatus
				+ ",\t Rule Active=" + ruleActive;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleDefinition() {
		return ruleDefinition;
	}

	public void setRuleDefinition(String ruleDefinition) {
		this.ruleDefinition = ruleDefinition;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getRuleOwner() {
		return ruleOwner;
	}

	public void setRuleOwner(String ruleOwner) {
		this.ruleOwner = ruleOwner;
	}

	public String getActionOwner() {
		return actionOwner;
	}

	public void setActionOwner(String actionOwner) {
		this.actionOwner = actionOwner;
	}

	public String getRuleActive() {
		return ruleActive;
	}

	public void setRuleActive(String ruleActive) {
		this.ruleActive = ruleActive;
	}

}
