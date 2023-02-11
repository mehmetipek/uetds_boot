package com.arma.uetds_boot.soap.interfaces;

import java.util.List;

import com.arma.uetds_boot.wsdl.UetdsGenelPdfSonuc;
import com.arma.uetds_boot.wsdl.YukBildirimRaporu;
import com.arma.uetds_boot.wsdl.YukBildirimiDetayi;
import com.arma.uetds_boot.wsdl.YukBildirimiDetayiResponse;
import com.arma.uetds_boot.wsdl.YukBildirimiIptalEt;
import com.arma.uetds_boot.wsdl.YukBildirimiIptalEtResponse;
import com.arma.uetds_boot.wsdl.YukBildirimiListesi;
import com.arma.uetds_boot.wsdl.YukBildirimiListesiResponse;

public interface ServiceGetMethodsInterface {
	
	YukBildirimiDetayiResponse bildirimiDetayiResponse(YukBildirimiDetayi bildirimiDetayi);
	
	YukBildirimiIptalEtResponse bildirimiIptalEtResponse(YukBildirimiIptalEt yukBildirimiIptalEt);
	
	YukBildirimiListesiResponse yukBildirimiListesiResponse(YukBildirimiListesi yukBildirimiListesi);
	
	List<YukBildirimiDetayiResponse> YukBildirimDetayiResponseList(List<YukBildirimiDetayi> bildirimiDetayiList);
	
	//UetdsGenelPdfSonuc genelPdfSonuc(YukBildirimRaporu bildirimRaporu);
	
}
