SOAP Request:
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:base="http://base.ws.mcd/">
   <soapenv:Header/>
   <soapenv:Body>
      <base:logicalMethod>
         <!--Optional:-->
         <arg0>Dunnes</arg0>
      </base:logicalMethod>
   </soapenv:Body>
</soapenv:Envelope>

Successful Response :
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <ns2:logicalMethodResponse xmlns:ns2="http://base.ws.mcd/">
         <Record>{"Country":"Ireland","Name":"Dunnes","Location":"Dublin"}</Record>
         <Record>{"Country":"UK","Name":"Dunnes","Location":"London"}</Record>
      </ns2:logicalMethodResponse>
   </soap:Body>
</soap:Envelope>

Fault Response:
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <soap:Fault>
         <faultcode>soap:Server</faultcode>
         <faultstring>Requested data not found in database (javax.xml.ws.soap.SOAPFaultException). Message payload is of type: ArrayList</faultstring>
      </soap:Fault>
   </soap:Body>
</soap:Envelope>

Database Table schema