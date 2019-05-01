package com.CloudBlaze.PageObjects;

public interface IOnBoarding {
	
	//Xpath of Home Page
	public String xpathHomePageLink="//*[@href='#/home']";
	public String xpathHomePageBreadCrumbs="//*[@id='root']//ol";
	public String urlHomePage="https://cloudblaze-ui-react.azurewebsites.net/#/home";
	
	//xpath of DataFlow Page Link
	public String xpathDataFlowPageLink="//*[@href='#/dashboard1']";
	public String xpathUrlOfDataFlow="https://cloudblaze-ui-react.azurewebsites.net/#/dashboard";
	
	//Xpath of Data Source Page Link
	public String xpathDataSourcePageLink = "//*[@href='#/DataSource']";
	public String xpathUrlOfDataSources="https://cloudblaze-ui-react.azurewebsites.net/#/DataSource";
	
	//xpath of System Params Page Link
	public String xpathSystemParamsLink="//*[@href='#/SystemParam']";
	public String xpathUrlOfSystemParams="https://cloudblaze-ui-react.azurewebsites.net/#/SystemParam";
	public String xpathTitleOfPage="//*[@id='root']//div//h2[text()='System Parameter']";
	public String xpathSubscriptionName="//*[@id='select-Subscription']";
	public String xpathSubscriptionNameText="//*[@id='root']//label[text()='Subscription Name']";
	public String xpathServicePrincipal="//*[@id='select-Serviceprincipal']";
	public String xpathServicePrincipalText="//*[@id='root']//label[text()='Service Principal']";
	public String xpathResourceGroupname="//*[@id='ResourceGroupName']";
	public String xpathResourceGroupnameText="//*[@id='root']//label[text()='ResourceGroupName']";
	public String xpathTenantId="//*[@id='TenantID']";
	public String xpathTenantIdText="//*[@id='root']//label[text()='TenantID']";
	public String xpathDataFactoryName="//*[@id='DataFactoryName']";
	public String xpathDataFactoryNameText="//*[@id='root']//label[text()='DataFactoryName']";
	public String xpathKeyVault="//*[@id='KeyVault']";
	public String xpathKeyVaultText="//*[@id='root']//label[text()='KeyVault']";
	public String xpathPrimaryEmail="//*[@id='PrimaryEmail']";
	public String xpathPrimaryEmailText="//*[@id='root']//label[text()='PrimaryEmail']";
	public String xpathSecondaryEmail="//*[@id='SecondaryEmail']";
	public String xpathSecondaryEmailText="//*[@id='root']//label[text()='SecondaryEmail']";
	public String xpathSubmitButton="//*[@id='SaveSystemParam']";
	public String xpathCancel_Button="(//*[@id='root']//button[text()='Cancel'])[3]";
	public String xpathColumnsInGrid="//*[@id='root']//table//thead//th";
	public String xpathRecordInGrid="//*[@id='root']//table//td";
	public String xpathClickEdit="(//*[@id='root']//td//a[@class='editlink'])[1]";
	
	//xpath of Custom Operationn Page link
	public String xpathCustomoperationLink="//*[@href='#/CustomOperation']";
	public String xpathUrlOfCustomOperation="https://cloudblaze-ui-react.azurewebsites.net/#/CustomOperation";
	
	//xpath of Subscription Page 
	public String xpathSubscriptionLink="//*[@href='#/Subscription']";
	public String xpathUrlOfSubscription="https://cloudblaze-ui-react.azurewebsites.net/#/Subscription";
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
	
	//xpath of Service Principal Page link 
	public String xpathServicePrincipalLink="//*[@href='#/ServicePrincipal']";
	public String xpathUrlOfServicePrincipal="https://cloudblaze-ui-react.azurewebsites.net/#/ServicePrincipal";
	public String xpathTitleOfSPD="//*[@id='root']//h4[text()='Add ServicePrincipal Details']";
	public String idOfSSelectSubscription="select-SelectSubscription";
	public String xpathOfSelectSubscriptiomWM="//*[@id='root']//label[text()='SelectSubscription']";
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
	
}
