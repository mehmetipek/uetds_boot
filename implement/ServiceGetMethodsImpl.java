package com.arma.uetds_boot.implement;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.arma.uetds_boot.soap.interfaces.ServiceGetMethodsInterface;
import com.arma.uetds_boot.wsdl.ObjectFactory;
import com.arma.uetds_boot.wsdl.UetdsGenelPdfSonuc;
import com.arma.uetds_boot.wsdl.YukBildirimRaporu;
import com.arma.uetds_boot.wsdl.YukBildirimiDetayi;
import com.arma.uetds_boot.wsdl.YukBildirimiDetayiResponse;
import com.arma.uetds_boot.wsdl.YukBildirimiIptalEt;
import com.arma.uetds_boot.wsdl.YukBildirimiIptalEtResponse;
import com.arma.uetds_boot.wsdl.YukBildirimiListesi;
import com.arma.uetds_boot.wsdl.YukBildirimiListesiResponse;

@Component
public class ServiceGetMethodsImpl extends WebServiceGatewaySupport implements ServiceGetMethodsInterface {

	
	private ObjectFactory factory=new ObjectFactory();	
	
	@SuppressWarnings("unchecked")
	@Override
	public YukBildirimiDetayiResponse bildirimiDetayiResponse(YukBildirimiDetayi bildirimiDetayi) {
		
		 JAXBElement<?> request;
		 JAXBElement<?> response;
		 
		YukBildirimiDetayi yukBildirimiDetayi=factory.createYukBildirimiDetayi();
		yukBildirimiDetayi=bildirimiDetayi;
		request=factory.createYukBildirimiDetayi(yukBildirimiDetayi);
		response=(JAXBElement<YukBildirimiDetayiResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (YukBildirimiDetayiResponse) response.getValue();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public YukBildirimiIptalEtResponse bildirimiIptalEtResponse(YukBildirimiIptalEt yukBildirimiIptalEt) {
		 JAXBElement<?> request;
		 JAXBElement<?> response;
		YukBildirimiIptalEt bildirimiIptalEt=factory.createYukBildirimiIptalEt();
		bildirimiIptalEt=yukBildirimiIptalEt;
		
		request=factory.createYukBildirimiIptalEt(bildirimiIptalEt);
		response=(JAXBElement<YukBildirimiIptalEtResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		
		return (YukBildirimiIptalEtResponse) response.getValue();
		
	}
	@Override
	public YukBildirimiListesiResponse yukBildirimiListesiResponse(YukBildirimiListesi yukBildirimiListesi) {
		 JAXBElement<?> request;
		 JAXBElement<?> response;
		YukBildirimiListesi bildirimiListesi=factory.createYukBildirimiListesi();
		bildirimiListesi=yukBildirimiListesi;
		
		request=factory.createYukBildirimiListesi(bildirimiListesi);
		response=(JAXBElement<?>) getWebServiceTemplate().marshalSendAndReceive(request);
	
		return (YukBildirimiListesiResponse) response.getValue();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<YukBildirimiDetayiResponse> YukBildirimDetayiResponseList(List<YukBildirimiDetayi> bildirimiDetayiList) {
		 JAXBElement<?> request;
		 JAXBElement<?> response;
		
		List<JAXBElement<YukBildirimiDetayiResponse>> responseList=new ArrayList<JAXBElement<YukBildirimiDetayiResponse>>();
		List<YukBildirimiDetayiResponse> responsePure=new ArrayList<YukBildirimiDetayiResponse>();

		int i=0;
		for(YukBildirimiDetayi bildirimiDetayi: bildirimiDetayiList)
		{
			YukBildirimiDetayi yukBildirimiDetayi=factory.createYukBildirimiDetayi();
			yukBildirimiDetayi=bildirimiDetayi;
			
			request=factory.createYukBildirimiDetayi(yukBildirimiDetayi);
			responseList.add((JAXBElement<YukBildirimiDetayiResponse>) getWebServiceTemplate().marshalSendAndReceive(request));
			responsePure.add(responseList.get(i).getValue());
			i++;
		}
		i=0;
		
		return responsePure;
		
	}

	
}
