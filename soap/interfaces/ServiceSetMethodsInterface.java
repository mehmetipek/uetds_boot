package com.arma.uetds_boot.soap.interfaces;

import java.util.List;

import com.arma.uetds_boot.model.CargoNotification;
import com.arma.uetds_boot.model.UetdsCompanies;
import com.arma.uetds_boot.wsdl.UetdsEsyaYeniYukKaydiBildirSonuc;
import com.arma.uetds_boot.wsdl.UetdsYtsUser;
import com.arma.uetds_boot.wsdl.WsUetdsEsyaAracBilgileriInput;
import com.arma.uetds_boot.wsdl.WsUetdsEsyaYukBilgileriInput;
import com.arma.uetds_boot.wsdl.YeniYukKaydiBildir;
import com.arma.uetds_boot.wsdl.YeniYukKaydiBildirResponse;
import com.arma.uetds_boot.wsdl.YukBildirimiGuncelle;
import com.arma.uetds_boot.wsdl.YukBildirimiGuncelleResponse;

public interface ServiceSetMethodsInterface {
	
	YeniYukKaydiBildirResponse yeniYukKaydi(YeniYukKaydiBildir yeniYukKaydiBildir);
	
	YukBildirimiGuncelleResponse guncelleResponse(YukBildirimiGuncelle bildirimiGuncelle);

	List<CargoNotification> yeniKargoKaydi(YeniYukKaydiBildir yeniYukKaydiBildir, UetdsCompanies company);
	
}
