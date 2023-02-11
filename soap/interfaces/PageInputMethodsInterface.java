package com.arma.uetds_boot.soap.interfaces;


import com.arma.uetds_boot.wsdl.IptalTurleri;
import com.arma.uetds_boot.wsdl.IptalTurleriResponse;
import com.arma.uetds_boot.wsdl.ParamTehlikeliMaddeTasimaSekli;
import com.arma.uetds_boot.wsdl.ParamTehlikeliMaddeTasimaSekliResponse;
import com.arma.uetds_boot.wsdl.ParamYukBirimi;
import com.arma.uetds_boot.wsdl.ParamYukBirimiResponse;
import com.arma.uetds_boot.wsdl.ParamYukTuru;
import com.arma.uetds_boot.wsdl.ParamYukTuruResponse;
import com.arma.uetds_boot.wsdl.UetdsEsyaParamEsyaTurSonuc;
import com.arma.uetds_boot.wsdl.UetdsYtsUser;

public interface PageInputMethodsInterface {
	
	 ParamYukBirimiResponse paramYukBir(ParamYukBirimi yukBirimi) ;
	
	 ParamTehlikeliMaddeTasimaSekliResponse maddeTasimaSekliResponse(ParamTehlikeliMaddeTasimaSekli maddeTasimaSekli);
	 
	 ParamYukTuruResponse paramYukTuru(ParamYukTuru tur);
	 
	 IptalTurleriResponse iptalTurleriResponse(IptalTurleri iptalTurleri);

}
