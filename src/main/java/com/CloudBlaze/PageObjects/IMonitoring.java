package com.CloudBlaze.PageObjects;

public interface IMonitoring {

	//xpath of Data Flow Scheduled Page
	public String xpathDataFlowScheduled="//*[@href='#/scheduler']";
	public String xpathUrlOfDataFlowScheduled="https://cloudblaze-ui-react.azurewebsites.net/#/scheduler";
	public String xpathTitle="//*[@id='root']//div//h2[text()='Data Flow Scheduler']";
	public String xpathDataFlowName="//*[@id='select-dataflowname']";
	public String xpathDataFlowNamePlaceHolder="//*[@id='root']//label[text()='Data Flow Name']";
	public String xpathStartDateandtime="//*[@id='startdatetime']";
	public String xpathEndDateandTime="//*[@id='enddatetime']";
	public String xpathFrequency="//*[@id='select-frequencyname']";
	public String xpathFrequencyPlaceholder="//*[@id='root']//label[text()='Frequency']";
	public String xpathStartTime="//*[@id='scheduleTime']";
	public String xpathSubmit="//*[@id='addScheduler']";
	public String xpathCancel="//*[@id='root']//button[text()='Cancel']";
	public String xpathColumnsInGrid="//*[@id='root']//table//th";
	
	
}
