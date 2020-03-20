package com.CloudBlaze.PageObjects;

public interface IOnBoarding {
	
	//Xpath of Home Page
	public String xpathHomePageLink="//*[@href='#/home']";
	public String xpathHomePageBreadCrumbs="//*[@id='root']//ol";
	public String urlHomePage="https://cloudblaze-ui-react.azurewebsites.net/#/home";
	public String xpathOracleToAzureSql="(/html/body/div//button[text()=' + Create Data Flow'])[5]";
	public String xpathSqltoSql="(/html/body/div//button[text()=' + Create Data Flow'])[4]";
	public String xpathHome="//*[@id='root']//a[@href='#/home']";
	public String xpathSystemParam="//*[@id='root']//a[@href='#/systemParam']";
	public String xpathServicePrincipal="//*[@id='root']//a[@href='#/servicePrincipal']";
	public String xpathSubscription="//*[@id='root']//a[@href='#/subscription']";
	public String xpathStorageandServices="//*[@id='root']//a[@href='#/dataSource']";
	public String xpathcstoptr="//*[@id='root']//a[@href='#/customOperation']";
	public String xpathDataFlow="//*[@id='root']//a[@href='#/dataFlow']";
	public String xpathScheduler="//*[@id='root']//a[@href='#/scheduler']";
	public String xpathMonitoring="//*[@id='root']//a[@href='#/dataflow-monitoring']";
	public String xpathorganizationinfo="//*[@id='root']//a[@href='#/organization-info']";
	
	
	//xpath of DataFlow Page Link
	public String xpathDataFlowPageLink="//*[@id='root']//a[@href='#/dataFlow']";
	public String xpathUrlOfDataFlow="https://cloudblaze-ui-react.azurewebsites.net/#/dataFlow";
	public String xpathAddButton="//*[@id='root']//button[text()='Add']";
	public String xpathPannel="//*[@id='inner-edit']//div[2]//div";
	public String xpathFirstPannel="(//*[@id='inner-edit']//div[@class='home-card-box'])[1]";
	public String xpathDataFlowScreen="/html/body/div[5]/div[2]";
	public String xpathOnpremiseSqltoDataLake="/html/body//div[text()='On Premise SQL to Azure Data Lake']";
	public String xpathDataSourceText="/html/body//h3[text()='Data Source']";
	public String xpathDataDestinationText="/html/body//h3[text()='Data Destination']";
	public String xpathConnectionToDataSource="/html/body//h6[text()='Connection to your data source store']";
	public String xpathConnectionToDataDestination="/html/body//h6[text()='Connection to your data destination store']";
	public String xpathSourceField="/html/body//div[text()='Select Source']";
	public String xpathDestinationField="/html/body//div[text()='Select Destination']";
	public String xpathCustomActivityField="//*[@id='select-customActivity']";
	public String xpathAddButton2="(/html/body//button[text()='Add'])[4]";	
	public String xpathBackButton="(/html/body//button[text()='Back'])[2]"; 
	public String xpathSaveButton="/html/body//div[3]/button[text()='Save']";
	public String xpathAlertOnNameDF="//*[@id='name-helper-text']";
	public String xpathAlertOnDS="/html/body//div[1]/form//div[1]//p";
	public String xpathAlertOnDD="/html/body//div[2]//div[2]//div[2]/form//p";
	public String xpathSelectTableLink="/html/body/div//button[text()='Select Table']";
	public String xpathSaveTableAlert="//*[@id='message-id']";
	public String xpathOrderNumber="/html/body//label[text()='Order No']";
	public String xpathAddButtonForCO="(/html/body//button[text()='Add'])[4]";
	public String xpathdeleteButton="//*[@id='root']//table/tbody//td[text()='DataFlow_1_7']/..//td//a[2]";
	public String xpathTableName="/html/body/div//table//thead/tr/th[text()='Table Name']";
	public String xpathCDC="(/html/body/div//table//thead/tr/th[text()='CDC'])[2]";
	public String xpathTDR="/html/body/div//table//thead/tr/th[text()='Track Deleted Records']";
	public String xpathDoCleansing="(/html/body/div//table//thead/tr/th[text()='DoCleansing'])[2]";
	public String xpathSchemaPropogated="(/html/body/div//table//thead/tr/th[text()='Schema Propagated'])[2]";
	public String xpathWhereClause="/html/body/div//table//thead/tr/th[text()='Where clause']";
	public String xpathCDFBtn="(//*[@id='inner-edit']//div//button[text()=' + Create Data Flow'])[1]";
	public String xpathYesBtn="(/html/body//div//button[text()=' YES '])[2]";
	public String xpathBrowseForFileBtn="//*[@id='root']/div//label[text()='Browse For File!']";
	public String xpathalertonNotebookFileloc="//*[@id='filepath-helper-text']";
	public String xpathbrowseForFile="(//*[@id='root']/div//label[text()='Browse For File!'])[2]";
	public String xpathStringDataType="//*[@id='menu-Type']//ul/li[1]";
	public String xpathName="(//*[@id='name'])[2]";
	public String xpathSelectType2="(//*[@id='select-Type'])[2]";
	public String browseforfile="//*[@id='root']/div//label[text()='Browse For File!']";
	public String xpathFileToAdls="(/html/body/div//button[text()=' + Create Data Flow'])[3]";
	public String xpathselectFolder="/html/body/div//button[text()='Select Folder']";
	public String xpathmysqltoAdls="(/html/body/div//button[text()=' + Create Data Flow'])[7]";
	public String xpathmysqltoSql="(html/body/div//button[text()=' + Create Data Flow'])[6]";
	public String xpathmysqltoadlsDM="(/html/body/div//button[text()=' + Create Data Flow'])[8]";
	public String xpathOracletoadlsDM="(/html/body/div//button[text()=' + Create Data Flow'])[9]";
	public String xpathMysqltoadlsDM="(/html/body/div//button[text()=' + Create Data Flow'])[10]";
	
	
	
	
	//Xpath of Storage and Services Page Link
	public String xpathDataSourcePageLink = "//*[@id='root']//div//a[@href='#/dataSource']";
    public String xpathUrlOfDataSources="https://cloudblaze-ui-react.azurewebsites.net/#/dataSource";
	public String xpathSource="//*[@id='menu-source']//div//li[text()='Source']";
	public String xpathOnPremiseSql="//*[@id='menu-dataSourceTypeId']//li[text()='On Premise Sql']";
	public String xpathOnPremiseoracle="//*[@id='menu-dataSourceTypeId']//li[text()='On Premise Oracle']";
	public String xpathSecureKey="(//*[@id='root']/div//a[@title='Create New'])[1]";
	public String xpathSubmitKey="(//*[@id='root']//button[text()='Submit'])[1]";
	public String xpathSubmit="(//*[@id='root']//button[text()='Submit'])[3]";
	public String xpathDeleteRecord="//*[@id='root']/div//table/tbody//tr[1]//a[2]";
	public String xpathYesButton="(/html/body//div/button[text()=' YES '])[2]";
	public String xpathSubmitBtn="(//*[@id='root']//div//button[text()='Submit'])[3]";
	public String xpathCancelBtn="(//*[@id='root']//div//button[text()='Cancel'])[3]";
	public String xpathSourceDestinationLabel="//*[@id='root']//div//label[text()='Source / Destination']";
	public String xpathListSourceStorage="//*[@id='menu-source']/div[2]/ul//li";
	public String xpathsource="//*[@id='menu-source']/div[2]/ul/li[text()='Source']";
	public String xpathonPremiseSql="//*[@id='menu-dataSourceTypeId']//ul/li[text()='On Premise Sql']";
	public String xpathalertonSub="//*[@id='root']//div/p[text()='Subscription Name cannot be empty']";
	public String xpathAlertonName="//*[@id='root']//div/p[text()='Name cannot be empty']";
	public String xpathAlertOnUserName="//*[@id='root']//div/p[text()='UserName cannot be empty']";
	public String xpathAlertonPassword="//*[@id='root']//div/p[text()='Password cannot be empty']";
	public String xpathAlertOnDbServerName="//*[@id='root']//div/p[text()='DbserverName cannot be empty']";
	public String xpathAlertOnDB="//*[@id='root']//div/p[text()='Dbname cannot be empty']";
	public String xpathAlertOnIntegration="//*[@id='root']//div/p[text()='Integration RunTime cannot be empty']";
	public String xpathAlertOnRGN="//*[@id='root']//div/p[text()='ResourceGroupName cannot be empty']";
	public String xpathDestinnation="//*[@id='menu-source']/div[2]/ul/li[text()='Destination']";
	public String xpathAzureDataLake="//*[@id='menu-dataSourceTypeId']//ul/li[text()='Azure Data Lake']";
	public String xpathAlertOnDatalakeUri="//*[@id='root']//div/p[text()='DataLakeStoreUri cannot be empty']";
	public String xpathServices=" //*[@id='menu-source']/div[2]/ul/li[text()='Service']";
	public String xpathDataFactory="//*[@id='menu-dataSourceTypeId']//div//li[text()='Data Factory']";
	public String xpathBatch="//*[@id='menu-dataSourceTypeId']//div//li[text()='Azure Batch']";
	public String xpathKeyIcon="(//*[@id='root']//div//a[@title='Secure ID Key Vault'])[3]";
	public String xpathSendgrid="//*[@id='menu-dataSourceTypeId']//div//li[text()='SendGrid']";
	public String xpathAzureFunction="//*[@id='menu-dataSourceTypeId']//div//li[text()='Azure Function']";
	public String xpathPlusbuttonAzureFunction="//*[@id='root']//div//a[@title='Create New']";
	public String xpathSubmitButtonAFkey="(//*[@id='root']/div//span/button[text()='Submit'])[1]";
	public String xpathSubmitStorageService="(//*[@id='root']/div//button[text()='Submit'])[3]";
	public String xpathDatafactory="//*[@id='root']//div//table/tbody//td[text()='cb0oanfb2ihritaidemo1df']";
	public String xpathSendgrids="//*[@id='root']//div//table/tbody//td[text()='azure_c3ef8800dba77de5ab07913965260507@azure.com']";
	public String xpathAzureFunctions="//*[@id='root']//div//table/tbody//td[text()='Azure_Function']";
	public String xpathOraclePckey="//*[@id='menu-173']/div//li[@data-value='OraclePCKey']";
	public String xpathAzureSql="//*[@id='menu-dataSourceTypeId']/div//ul/li[text()='Azure Sql']";
	public String xpathAzureSqlPass="//*[@id='menu-9']/div/ul/li[text()='azuresqlpass']";
	public String xpathOracletoadlsCreate="(/html/body/div//button[text()=' + Create Data Flow'])[2]";
	public String xpathAdlsDest="/html/body/div//form//div[text()='Select Destination']";
	public String xpathYesBtnn="/html/body/div[5]/div//button[text()=' YES ']";
	public String xpathFile="//*[@id='menu-dataSourceTypeId']//li[text()='File System']";
	public String xpathIRFroFile="//*[@id='menu-75']/div//li[@data-value='PriynakaSystemKey']";
	public String xpathMysqlSource="//*[@id='menu-dataSourceTypeId']//li[text()='On Premise MySQL']";
	public String xpathIntegrationMysql="//*[@id='menu-165']/div//li[@data-value='MySqlKeyPC']";
	
	//xpath of System Params Page Link
	public String xpathSystemParamsLink="//*[@id='root']//a[@href='#/systemParam']";
	public String xpathUrlOfSystemParams="https://cloudblaze-ui-react.azurewebsites.net/#/systemParam";
	public String xpathTitleOfPage="//*[@id='root']//div//h2[text()='System Parameter']";
	//public String xpathSubscriptionName="//*[@id='select-Subscription']";
	//public String xpathSubscriptionNameText="//*[@id='root']//label[text()='Subscription Name']";
	//public String xpathServicePrincipal="//*[@id='select-Serviceprincipal']";
	
	//public String xpathResourceGroupname="//*[@id='ResourceGroupName']";
	//public String xpathResourceGroupnameText="//*[@id='root']//label[text()='ResourceGroupName']";
	public String xpathTenantId="//*[@id='TenantID']";
	
	//public String xpathKeyVault="//*[@id='KeyVault']";
	//public String xpathKeyVaultText="//*[@id='root']//label[text()='KeyVault']";
    public String xpathColumnsInGrid="//*[@id='root']//table//thead//th";
	public String xpathRecordInGrid="//*[@id='root']//table//td";
	//public String xpathClickEdit="(//*[@id='root']//td//a[@class='editlink'])[1]";
	public String xpathPrimaryEmail="//*[@id='PrimaryEmail']";
	public String xpathSecondaryEmail="//*[@id='SecondaryEmail']";
	public String xpathSubmitButton="//*[@id='SaveSystemParam']";
	public String xpathCancel_Button="(//*[@id='root']//button[text()='Cancel'])[3]";
	public String xpathAlertOnTenantID="//*[@id='root']//div//p[text()='tenantID cannot empty']";
	public String xpathInvalidTenantId="//*[@id='root']//div//p[text()='tenantID is not valid']";
	
	//xpath of Custom Operation Page link
	public String xpathCustomoperationLink="//*[@id='root']//a[@href='#/customOperation']";
	public String xpathSelecttypeWM="//*[@id='root']//label[text()='Select Type']";
	public String xpathUrlOfCustomOperation="https://cloudblaze-ui-react.azurewebsites.net/#/customOperation";
	public String xpathTitle="//*[@id='root']//div//h2[text()='Custom Operation']";
	public String xpathSelectType="//*[@id='select-customOpTypeId']";
	public String xpathSubmitButtonCO="//*[@id='root']//button[text()='Submit']";
	public String xpathCancelButtonCO="//*[@id='root']//button[text()='Cancel']";
	public String xpathOfGridOfCO="//*[@id='root']//div//table";
	public String alertOnSubmit="//*[@id='root']//p[text()='Select type cannot be empty']";
	public String xpathClickonType="//*[@id='select-customOpTypeId']";
	public String xpathSelectJar="//*[@id='menu-customOpTypeId']//li[text()='Scala Jar']";
	public String xpathjar="//*[@id='select-customOpTypeId']";
	public String xpathNameJ="//*[@id='Name']";
	public String xpathDescriptionJ="//*[@id='Description']";
	public String xpathClassNameJ="//*[@id='ClassName']";
	public String xpathAppendLibrary="//*[@id='root']//div/button[text()='Append Libraries +']";
	public String jarLibrary="//*[@id='menu-libraryType']//div/ul/li[text()='jar']";
	public String xpathScriptFile="//*[@id='FolderPath']";
	public String xpathSelectNotebook="//*[@id='menu-customOpTypeId']//li[text()='Scala Notebook']";
	public String xpathSelectExe="//*[@id='menu-customOpTypeId']//li[text()='Exe']";
	public String xpathCommand="//*[@id='Command']";
	public String xpathNameP="//*[@id='name']";
	public String xpathNameP2= "(//*[@id='name'])[2]";
	public String xpathDatatype="//*[@id='root']//label[text()='Data Type']";
	public String xpathStringtype="//*[@id='menu-Type']//li[text()='string']";
	public String xpathInttype="//*[@id='menu-Type']//li[text()='int']";
	public String xpathSelectLibrary="//*[@id='avc']//label[text()='Select Library Type']";
	public String xpathLibraryJ="//*[@id='menu-libraryType']//li[text()='jar']";
	public String xpathEggJ="//*[@id='menu-libraryType']//li[text()='egg']";
	public String xpathDecimaltypeN="//*[@id='menu-Type']//li[text()='decimal']";
	public String xpathPypiTypeN="//*[@id='menu-libraryType']//li[text()='pypi']";
	public String xpathMaven="//*[@id='menu-libraryType']//li[text()='maven']";
	public String xpathCran="//*[@id='menu-libraryType']//li[text()='cran']";
	public String xpathDeleteL="//*[@id='avc']//a";
	public String xpathnameAlert="//*[@id='Name-helper-text']";
	public String xpathClassnameAlert="//*[@id='ClassName-helper-text']";
	public String xpathScriptFileLocation="//*[@id='FolderPath-helper-text']";
	public String xpathCommandAlert="//*[@id='Command-helper-text']";
	public String xpathAlertOnDbfs="//*[@id='root']//p[text()='DBFS URI cannot be empty']";
	public String xpathAlertonPackage="//*[@id='avc']//p[text()='Package cannot be empty']";
	public String xptahAlertonCoordinates="//*[@id='avc']//p[text()='Coordinates cannot be empty']";
	public String xpathaddupdate="//*[@id='alert-dialog-slide-title']/h2[text()='Add/Update']";
	public String xpathConfirmationtext="//*[@id='alert-dialog-slide-description']//p[text()='Are you sure you want to Submit this entry?']";
	public String xpathYesbtn="(/html/body/div//button[text()=' YES '])[3]";
	public String xpathcstmadd="(/html/body/div//button[text()='Add'])[4]";
	//xpath of Subscription Page 
	public String xpathSubscriptionLink="//*[@id='root']//a[@href='#/subscription']";
	public String xpathUrlOfSubscription="https://cloudblaze-ui-react.azurewebsites.net/#/subscription";
	public String xpathSelectServicePrincipal="//*[@id='select-SelectServiceprincipal']";
	public String xpathSelectServicePrincipalWM="//*[@id='root']//label[text()='Select Service Principal']";
	public String idName="name";
	public String xpathNameWaterMark="//*[@id='root']//label[@for='name']";
	public String idSubScription="subscriptionId";
	public String xpathSubscriptionIdWaterMark="//*[@id='root']//label[@for='subscriptionId']";
	public String idDescription="description";
	public String xpathDescriptionWaterMark="//*[@id='root']//label[@for='description']";
	public String idSubmitBtn="addSubs";
    public String xpathCancelButton="//*[@id='root']//button[text()='Cancel']";
    public String xpathOfGridOfSubscription="//*[@id='root']//div//table";
    public String xpathColumnOfgrid="//*[@id='root']//table//thead";
    public String xpathRowInGrid="//*[@id='root']//table//tbody//tr";
    public String classEdit="editlink";
    public String xpathEdit="(//*[@id='root']//table/tbody//a[1])[1]";
    public String classDeleteButton="deletelink";
    public String xpathDelete="(//*[@id='root']//table/tbody//a[2])[1]";
    public String yesButton="/html//button[text()=' YES ']";
    public String xpathcolumns="//*[@id='root']//table//tbody//tr[1]/*";
    public String xpathAlertOnSSP="//*[@id='root']//p[text()='Service Principal ID  cannot be empty']";
    public String xpathAlertOnName="//*[@id='name-helper-text']";
    public String xpathAlertOnSubscription="//*[@id='subscriptionId-helper-text']";
    public String xpathFirstElementOfDropDown="//*[@id='menu-SelectServiceprincipal']//li[1]";
    public String xpathDeleteDialogBox="/html/body/div[4]/div[2]/div/div[2]";
    public String xpathDeleteText="//*[@id='alert-dialog-slide-title']/h2[text()='Delete']";
    public String xpathDeleteStatement="//*[@id='alert-dialog-slide-description']//p[text()='Are you sure you want to delete this entry?']";
    public String xpathDeleteYesButton="(/html/body//button[text()=' YES '])";
    public String xpathDeleteNoButton="/html/body//button[text()=' NO ']";
    public String xpathLoginbutton="//*[@id='root']//button[text()='Login']";
    public String xpathQaspServiceprincipal="//*[@id='menu-SelectServiceprincipal']/div//li[text()='QA_sp']";
    
	//xpath of Service Principal Page link 
    
	public String xpathServicePrincipalLink="//*[@id='root']//div//a[@href='#/servicePrincipal']";
	public String xpathUrlOfServicePrincipal="https://cloudblaze-ui-react.azurewebsites.net/#/servicePrincipal";
	public String xpathTitleOfSPD="//*[@id='root']//main//h2[text()='Add Service Principal Details']";
	public String idOfName="name";
	public String xpathOfNameWM="//*[@id='root']//label[text()='Name']";
	public String idOfApplicationID="servicePrincipalId";
	public String xpathOfApplicationWM="//*[@id='root']//label[text()='ApplicationID']";
	public String idOfDescription="description";
	public String xpathOfDescription="//*[@id='root']//label[text()='Description']";
	public String idOfKey="servicePrincipalKey";
	public String xpathOfKeyWM="//*[@id='root']//label[@for='servicePrincipalKey']";
	public String xpathOfGridOfSp="//*[@id='root']//table";
	public String xpathFirstSubscriptionFromDropDown="//*[@id='menu-SelectSubscription']//ul//li[1]";
	public String xpathSubmitButtonSP="//*[@id='addService']";
	public String xpathCancelbutton="//*[@id='root']//button[text()='Cancel']";
	public String toasterRecordSaved="//*[@id='message-id']";
	public String xpathAlertOnSelectSubscription="//*[@id='root']//p[text()='Subscription cannot be empty']";
	public String xpathAlertOnApplicationID="//*[@id='servicePrincipalId-helper-text']";
	public String xpathAlertOnDirectoryId="//*[@id='directoryId-helper-text']";
	public String xpathAlertOnKey="//*[@id='servicePrincipalKey-helper-text']";
	public String xpathPlusButton ="//*[@id='root']//div//a[@title='Create New']";
	public String xpathKeyField="//*[@id='secretKey_error_text']";
	public String xpathKeyValue="//*[@id='secretValue_error_text']";
	public String xpathSubmitBtnForKeyGeneration="//*[@id='root']//div//span/button[text()='Submit']";

	//FullLoad
	public String xpathPriyankaSystemKey="//*[@id='menu-33']/div//li[@data-value='PriynakaSystemKey']";
	public String xpathCreateDataFlow="(/html/body/div//button[text()=' + Create Data Flow'])[1]";
	public String xpathMonitoringPagelink="//*[@id='root']//div//a[@href='#/dataflow-monitoring']";
	public String xpathSubmitclick="(//*[@id='root']//div//button[text()='Submit'])[3]";
	public String xpathYesButn="(/html/body//div//button[text()=' YES '])";

}
