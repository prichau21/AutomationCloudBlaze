package com.CloudBlaze.PageObjects;

public interface IMonitoring {

	//xpath of Data Flow Scheduled Page
	public String xpathDataFlowScheduled="//*[@id='root']//div//a[@href='#/scheduler']";
	public String xpathUrlOfDataFlowScheduled="https://cloudblaze-ui-react.azurewebsites.net/#/scheduler";
	public String xpathTitle="//*[@id='root']//div//h2[text()='Data Flow Scheduler']";
	public String xpathDataFlowName="//*[@id='select-dataflowname']";
	public String xpathDataFlowNamePlaceHolder="//*[@id='root']//div//h2[text()='Data Flow Scheduler ']";
	public String xpathStartDateandtime="//*[@id='startdatetime']";
	public String xpathEndDateandTime="//*[@id='enddatetime']";
    //public String xpathFrequency="//*[@id='select-frequencyname']";
	public String xpathDescriptionPlaceHolder="//*[@id='root']//label[text()='Description']";
	public String xpathFrequencyPlaceholder="//*[@id='root']//div[text()='Select frequency']";
	public String xpathStartTime="//*[@id='scheduleTime']";
	public String xpathSubmit="//*[@id='addScheduler']";
	public String xpathCancel="//*[@id='root']//button[text()='Cancel']";
	public String xpathColumnsInGrid="//*[@id='root']//table//th";
	public String xpathtoaster="//*[@id='message-id']";
	public String xpathEndDate="//*[@id='enddatetime']";
	public String xpathSelectdataFlowAlert="//*[@id='root']//div//p[text()='Select Data flow Name']";
	public String xpathAlertonFrequency="//*[@id='root']//div//p[text()='Frequency cannot be empty']";
	public String xpathFirstElementOfDropDown="//*[@id='menu-dataflowname']//div//ul/li[text()='PriTest']";
	public String xpathSelectFrequency="//*[@id='root']//div[text()='Select frequency']";
	public String xpathDeleteDialogBox="/html/body/div[3]/div[2]/div";
	public String xpathDeleteText="//*[@id='alert-dialog-slide-title']/h2[text()='Delete']";
	public String xpathDeleteStatement="//*[@id='alert-dialog-slide-description']";
	public String xpathDeleteYesButton="/html/body//button[text()=' YES ']";
	public String xpathDeleteNoButton="/html/body//button[text()=' NO ']";
	public String classDeleteButton="deletelink";
	public String xpathEdit="(//*[@id='root']//table/tbody//a[1])[1]";
	public String xpathSecondElementOfDropDown="//*[@id='menu-dataflowname']//div//ul/li[text()='Priyanka']";
	public String xpathRowInGrid="//*[@id='root']//table//tbody//tr";
	public String xpathDelete="(//*[@id='root']//table/tbody//a[2])[1]";
	public String yesButton="/html//button[text()=' YES ']";
	public String nobutton="/html//button[text()=' NO ']";
	public String alert="//*[@id='root']//p[text()='Schedule already created for this Data flow']";
	public String startdate="//*[@id='startdatetime']";
	public String triggerTime="//*[@id='scheduleTime']";
	public String description="//*[@id='root']//*[@name='description']";
	
    }
