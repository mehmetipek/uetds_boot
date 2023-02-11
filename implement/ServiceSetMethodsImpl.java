package com.arma.uetds_boot.implement;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.arma.uetds_boot.model.CargoNotification;
import com.arma.uetds_boot.model.UetdsCompanies;
import com.arma.uetds_boot.service.DenemeConnective;
import com.arma.uetds_boot.soap.interfaces.ServiceSetMethodsInterface;
import com.arma.uetds_boot.wsdl.ObjectFactory;
import com.arma.uetds_boot.wsdl.UetdsEsyaYeniYukKaydiBildirSonuc;
import com.arma.uetds_boot.wsdl.UetdsYtsUser;
import com.arma.uetds_boot.wsdl.WsUetdsEsyaAracBilgileriInput;
import com.arma.uetds_boot.wsdl.WsUetdsEsyaYukBilgileriInput;
import com.arma.uetds_boot.wsdl.YeniYukKaydiBildir;
import com.arma.uetds_boot.wsdl.YeniYukKaydiBildirResponse;
import com.arma.uetds_boot.wsdl.YukBildirimiGuncelle;
import com.arma.uetds_boot.wsdl.YukBildirimiGuncelleResponse;

@Component
public class ServiceSetMethodsImpl extends WebServiceGatewaySupport implements ServiceSetMethodsInterface {

	private ObjectFactory factory=new ObjectFactory();
	private JAXBElement<?> request;
	private JAXBElement<?> response;
	

	
	@SuppressWarnings("unchecked")
	@Override
	public YeniYukKaydiBildirResponse yeniYukKaydi(YeniYukKaydiBildir yeniYukKaydiBildir) {
		
		YeniYukKaydiBildir kayitBildir=factory.createYeniYukKaydiBildir();
		kayitBildir=yeniYukKaydiBildir;
		YeniYukKaydiBildirResponse responseUsing=new YeniYukKaydiBildirResponse();
		
		request=factory.createYeniYukKaydiBildir(kayitBildir);
		
		response=(JAXBElement<YeniYukKaydiBildirResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		
		responseUsing=(YeniYukKaydiBildirResponse) response.getValue();
		
		return (YeniYukKaydiBildirResponse) response.getValue();
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public YukBildirimiGuncelleResponse guncelleResponse(YukBildirimiGuncelle bildirimiGuncelle) {
		YukBildirimiGuncelle guncelle=factory.createYukBildirimiGuncelle();
		guncelle=bildirimiGuncelle;
		
		request=factory.createYukBildirimiGuncelle(guncelle);
		response=(JAXBElement<YukBildirimiGuncelleResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		
		return (YukBildirimiGuncelleResponse) response.getValue();
	}


	@Override
	public List<CargoNotification> yeniKargoKaydi(YeniYukKaydiBildir yeniYukKaydiBildir, UetdsCompanies company) {
	
		List<WsUetdsEsyaYukBilgileriInput> esyaBilgileri=yeniYukKaydiBildir.getYukBilgileriListInput();
		WsUetdsEsyaAracBilgileriInput arac=yeniYukKaydiBildir.getAracBilgileriInput();
		List<CargoNotification> cargoList=new ArrayList<CargoNotification>();
		
		for(WsUetdsEsyaYukBilgileriInput esya:esyaBilgileri)
		{
			CargoNotification cargoNotification=new CargoNotification(company, 1L, esya.getAliciUnvan(), esya.getYuklemeUlkeKodu(), esya.getYuklemeIlMernisKodu(),
					esya.getYuklemeIlceMernisKodu(), esya.getBosaltmaUlkeKodu(), esya.getBosaltmaIlMernisKodu(), esya.getBosaltmaIlceMernisKodu(),
					esya.getGonderenUnvan(), esya.getGonderenVergiNo(), esya.getTasimaBedeli(), esya.getYukCinsId(), arac.getTasimaTuruKodu(), arac.getPlaka1(),
					arac.getSofor1TcNo(), arac.getPlaka2(), arac.getSofor2TcNo(), "bilinmiyor", esya.getYuklemeTarihi());
			
			cargoList.add(cargoNotification);
			
		}
		return cargoList;
		
		
		
	}
	
}
