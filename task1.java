/**
 * Solution to semester assignment in the course TTM4130 Service Intelligence and Mobility
 *
 * The task was: 
 *   Based on the code skeleton provided, develop a fully operational SIP UA and implement 
 *   presence capability in the client. (PUBLISH, NOTIFY, etc. according to the SIP 
 *   standard) 
 * 
 * Files:
 * - Code skeleton: http://files.kimjoar.net/ttm4130_code_skeleton.tar.gz
 * - Assignment:    http://files.kimjoar.net/ttm4130_semester_assignment.pdf
 * - Libraries:     http://files.kimjoar.net/ttm4130_libraries.tar.gz
 *
 * These functions are to be added to the file MessengerEngine.java
 *
 * XML library used to parse the returned XML was JDOM 1.1
 */

public void sendSubscribe(String subscriberAddress)
{
	try {    	
		Address destinationAddress = myAddressFactory.createAddress("sip:" + subscriberAddress);
		javax.sip.address.URI myRequestURI = destinationAddress.getURI();
		Address myAddress = myAddressFactory.createAddress(myURI);
		Address contactAddress = myAddressFactory.createAddress("sip:" + myIP + ":" + myPort);

		CallIdHeader myCallIdHeader = mySipProvider.getNewCallId();

		CSeqHeader myCSeqHeader = myHeaderFactory.createCSeqHeader(1L, "SUBSCRIBE");

		FromHeader myFromHeader = myHeaderFactory.createFromHeader(myAddress, "57864");
		ToHeader myToHeader     = myHeaderFactory.createToHeader(destinationAddress, null);

		MaxForwardsHeader myMaxForwardsHeader = myHeaderFactory.createMaxForwardsHeader(70);

		ArrayList<ViaHeader> viaHeaders = new ArrayList<ViaHeader>();
		myViaHeader = myHeaderFactory.createViaHeader(myIP, myPort, "UDP", null);
		viaHeaders.add(myViaHeader);

		Request myRequest = myMessageFactory.createRequest(myRequestURI, "SUBSCRIBE", myCallIdHeader, myCSeqHeader, myFromHeader, myToHeader, viaHeaders, myMaxForwardsHeader);

		ContactHeader myContactHeader = myHeaderFactory.createContactHeader(contactAddress);
		EventHeader myEventHeader = myHeaderFactory.createEventHeader("Presence");
		ExpiresHeader myExpiresHeader = myHeaderFactory.createExpiresHeader(300);

		myRequest.addHeader(myContactHeader);
		myRequest.addHeader(myEventHeader);
		myRequest.addHeader(myExpiresHeader);

		myClientTransaction = mySipProvider.getNewClientTransaction(myRequest);
		myClientTransaction.sendRequest();

		myGUI.log("[SENT] " + myRequest.toString());
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void sendPublish(String statusid, String status) 
{
	try {    	
		Address myAddress = myAddressFactory.createAddress(myURI);

		CallIdHeader myCallIdHeader = mySipProvider.getNewCallId();

		CSeqHeader myCSeqHeader = myHeaderFactory.createCSeqHeader(1L, "PUBLISH");

		FromHeader myFromHeader = myHeaderFactory.createFromHeader(myAddress, "57864");
		ToHeader myToHeader     = myHeaderFactory.createToHeader(myAddress, null);

		MaxForwardsHeader myMaxForwardsHeader = myHeaderFactory.createMaxForwardsHeader(70);

		ArrayList<ViaHeader> viaHeaders = new ArrayList<ViaHeader>();
		myViaHeader = myHeaderFactory.createViaHeader(myIP, myPort, "UDP", null);
		viaHeaders.add(myViaHeader);

		Request myRequest = myMessageFactory.createRequest(myURI, "PUBLISH", myCallIdHeader, myCSeqHeader, myFromHeader, myToHeader, viaHeaders, myMaxForwardsHeader);

		Address contactAddress = myAddressFactory.createAddress("sip:" + myIP + ":" + myPort);
		ContactHeader myContactHeader = myHeaderFactory.createContactHeader(contactAddress);
		EventHeader myEventHeader = myHeaderFactory.createEventHeader("Presence");
		ExpiresHeader myExpiresHeader = myHeaderFactory.createExpiresHeader(300);
		AllowHeader myAllowHeader = myHeaderFactory.createAllowHeader("INVITE, ACK, CANCEL, OPTIONS, BYE, REFER, NOTIFY, MESSAGE, SUBSCRIBE, INFO");
		ContentTypeHeader myContentTypeHeader = myHeaderFactory.createContentTypeHeader("application", "pidf+xml");

		myRequest.addHeader(myContactHeader);
		myRequest.addHeader(myEventHeader);
		myRequest.addHeader(myExpiresHeader);
		myRequest.addHeader(myAllowHeader);

		String content = "<?xml version='1.0' encoding='UTF-8'?><presence xmlns='urn:ietf:params:xml:ns:pidf' xmlns:dm='urn:ietf:params:xml:ns:pidf:data-model' xmlns:rpid='urn:ietf:params:xml:ns:pidf:rpid' xmlns:c='urn:ietf:params:xml:ns:pidf:cipid' entity='sip:" + myURI.getUser() + "@" + myURI.getHost() + "'><tuple id='" + tupleID + "'><status><basic>open</basic></status></tuple><dm:person id='" + personID + "'><rpid:activities><rpid:" + (statusid.replace(" ", "")) + "/></rpid:activities><dm:note>" + status + "</dm:note></dm:person></presence>";
		myRequest.setContent(content, myContentTypeHeader);

		myClientTransaction = mySipProvider.getNewClientTransaction(myRequest);
		myClientTransaction.sendRequest();

		myGUI.log("[SENT] " + myRequest.toString());
	} catch (Exception e) {
		e.printStackTrace();
	}
}    

private void handleNotify(Request myRequest)
{
	try {
		Response myResponse = myMessageFactory.createResponse(200, myRequest);
		ToHeader responseToHeader = (ToHeader) myResponse.getHeader("To");
		responseToHeader.setTag("454326");
		myServerTransaction.sendResponse(myResponse);
		myDialog = myServerTransaction.getDialog();
		System.out.println("Dialog status: " + myDialog.getState().toString());

		try {
    		String content = new String(myRequest.getRawContent());

    		SAXBuilder builder = new SAXBuilder();
    		Document doc = builder.build(new InputSource(new StringReader(content)));

    		String entity = doc.getRootElement().getAttributeValue("entity");
    		String status = ((Element) ((Element) doc.getRootElement().getChildren().get(1)).getChildren().get(1)).getText();

    		myGUI.updateListWithStatus(entity, status);
		} catch (NullPointerException e) {
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}	
}