package com.arma.uetds_boot.implement;

import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.arma.uetds_boot.soap.interfaces.PageInputMethodsInterface;
import com.arma.uetds_boot.wsdl.IptalTurleri;
import com.arma.uetds_boot.wsdl.IptalTurleriResponse;
import com.arma.uetds_boot.wsdl.ObjectFactory;
import com.arma.uetds_boot.wsdl.ParamTehlikeliMaddeTasimaSekli;
import com.arma.uetds_boot.wsdl.ParamTehlikeliMaddeTasimaSekliResponse;
import com.arma.uetds_boot.wsdl.ParamYukBirimi;
import com.arma.uetds_boot.wsdl.ParamYukBirimiResponse;
import com.arma.uetds_boot.wsdl.ParamYukTuru;
import com.arma.uetds_boot.wsdl.ParamYukTuruResponse;


@Component
public class PageInputMethodsImpl extends WebServiceGatewaySupport implements PageInputMethodsInterface {

	private ObjectFactory factory = new ObjectFactory();
	
	@SuppressWarnings("unchecked")
	@Override
	public ParamYukBirimiResponse paramYukBir(ParamYukBirimi yukBirimi) {

		JAXBElement<?> request=null;
		JAXBElement<?> response=null;

		ParamYukBirimi birimPure = factory.createParamYukBirimi();
		birimPure = yukBirimi;

		request = factory.createParamYukBirimi(birimPure);
		response = (JAXBElement<ParamYukBirimiResponse>) getWebServiceTemplate().marshalSendAndReceive(request);

		return  (ParamYukBirimiResponse) response.getValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ParamTehlikeliMaddeTasimaSekliResponse maddeTasimaSekliResponse(ParamTehlikeliMaddeTasimaSekli maddeTasimaSekli) {
		JAXBElement<?> request=null;
		JAXBElement<?> response=null;
		ParamTehlikeliMaddeTasimaSekli tasimaSekli=factory.createParamTehlikeliMaddeTasimaSekli();
		tasimaSekli=maddeTasimaSekli;
		
		request=factory.createParamTehlikeliMaddeTasimaSekli(tasimaSekli);
		response=(JAXBElement<ParamTehlikeliMaddeTasimaSekliResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		
		return (ParamTehlikeliMaddeTasimaSekliResponse) response.getValue();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ParamYukTuruResponse paramYukTuru(ParamYukTuru tur) {
		JAXBElement<?> request=null;
		JAXBElement<?> response=null;
		request=null;
		response=null;
		ParamYukTuru yukTuru = factory.createParamYukTuru();
		yukTuru = tur;
		
		request = factory.createParamYukTuru(yukTuru);
		response = (JAXBElement<ParamYukTuruResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		
		return (ParamYukTuruResponse) response.getValue();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public IptalTurleriResponse iptalTurleriResponse(IptalTurleri iptalTurleri) {
		JAXBElement<?> request=null;
		JAXBElement<?> response=null;
		IptalTurleri iptalTur=factory.createIptalTurleri();
		iptalTur=iptalTurleri;
		
		request=factory.createIptalTurleri(iptalTur);
		response=(JAXBElement<IptalTurleriResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		
		return (IptalTurleriResponse) response.getValue();
	}

}
