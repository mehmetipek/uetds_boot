package com.arma.uetds_boot.soapConfig;


import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.arma.uetds_boot.wsdl.ObjectFactory;
import com.arma.uetds_boot.wsdl.ParamYukBirimi;
import com.arma.uetds_boot.wsdl.ParamYukBirimiResponse;
import com.arma.uetds_boot.wsdl.ServisTest;
import com.arma.uetds_boot.wsdl.ServisTestResponse;
import com.arma.uetds_boot.wsdl.UetdsYtsUser;
import com.arma.uetds_boot.wsdl.WsUetdsEsyaAracBilgileriInput;
import com.arma.uetds_boot.wsdl.WsUetdsEsyaYukBilgileriInput;
import com.arma.uetds_boot.wsdl.YeniYukKaydiBildir;
import com.arma.uetds_boot.wsdl.YeniYukKaydiBildirResponse;


public class UetdsClient extends WebServiceGatewaySupport {
	
/*
 * 
 * OBJECT FACTORY KULLANILMADAN METOTLARA ERİŞİM 
 * 
	public ServisTestResponse test(String mesaj) {

		ObjectFactory fac = new ObjectFactory();

		ServisTestResponse responseA = new ServisTestResponse();

		ServisTest request = new ServisTest();
		request.setTestMsj(mesaj);

		@SuppressWarnings("unchecked")
		JAXBElement<ServisTestResponse> response = (JAXBElement<ServisTestResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("https://servis.turkiye.gov.tr/services/g2g/kdgm/uetdsesya?wsdl", request,
						new SoapActionCallback(
								"http://uetds.unetws.udhb.gov.tr/UdhbUetdsEsyaWsService/servisTestResponse"));

		responseA = response.getValue();
		return responseA;

	}
*/
	
	private ObjectFactory factory=new ObjectFactory();
	private JAXBElement<?> request;
	private JAXBElement<?> response;

	
	
	@SuppressWarnings("unchecked")
	public ServisTestResponse test2(String mesaj) throws JAXBException {
		
		ServisTest requestPure = factory.createServisTest();
		requestPure.setTestMsj(mesaj);

		request=factory.createServisTest(requestPure);
		response=(JAXBElement<ServisTestResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (ServisTestResponse) response.getValue();

	}

	@SuppressWarnings("unchecked")
	public ParamYukBirimiResponse paramYukBir(UetdsYtsUser user, String tasimaTurKodu) {


		ParamYukBirimiResponse responsePure = factory.createParamYukBirimiResponse();
		ParamYukBirimi birimPure =factory.createParamYukBirimi();

	
		birimPure.setWsuser(user);
		birimPure.setTasimaTuruKodu(tasimaTurKodu);
		
		request=factory.createParamYukBirimi(birimPure);
		
		response=(JAXBElement<ParamYukBirimiResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (ParamYukBirimiResponse) response.getValue();
		
	}
	@SuppressWarnings("unchecked")
	public YeniYukKaydiBildirResponse yukBildir(UetdsYtsUser user, WsUetdsEsyaAracBilgileriInput aracBilgileri, List<WsUetdsEsyaYukBilgileriInput> yukBilgileriList)
	{
		ObjectFactory factory=new ObjectFactory();
		YeniYukKaydiBildir requestPure=factory.createYeniYukKaydiBildir();
		YeniYukKaydiBildirResponse responsePure=factory.createYeniYukKaydiBildirResponse();
		
		requestPure.setWsuser(user);
		requestPure.setAracBilgileriInput(aracBilgileri);
		for (WsUetdsEsyaYukBilgileriInput wsUetdsEsyaYukBilgileriInput : yukBilgileriList) {
			requestPure.getYukBilgileriListInput().add(wsUetdsEsyaYukBilgileriInput);
		}
		
		JAXBElement<YeniYukKaydiBildir> request=factory.createYeniYukKaydiBildir(requestPure);
		
		JAXBElement<YeniYukKaydiBildirResponse> response=(JAXBElement<YeniYukKaydiBildirResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return response.getValue();
		
	}

}
