package com.arma.uetds_boot.soap.interfaces;

import com.arma.uetds_boot.yolcu.wsdl.AracMuayeneSorgula;
import com.arma.uetds_boot.yolcu.wsdl.AracMuayeneSorgulaResponse;
import com.arma.uetds_boot.yolcu.wsdl.PersonelEkle;
import com.arma.uetds_boot.yolcu.wsdl.PersonelEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferAktif;
import com.arma.uetds_boot.yolcu.wsdl.SeferAktifResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferDetayCiktisiAl;
import com.arma.uetds_boot.yolcu.wsdl.SeferDetayCiktisiAlResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferEkle;
import com.arma.uetds_boot.yolcu.wsdl.SeferEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupEkle;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupGuncelle;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupGuncelleResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupIptal;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupIptalResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferGuncelle;
import com.arma.uetds_boot.yolcu.wsdl.SeferGuncelleResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferIptal;
import com.arma.uetds_boot.yolcu.wsdl.SeferIptalResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferPlakaDegistir;
import com.arma.uetds_boot.yolcu.wsdl.SeferPlakaDegistirResponse;
import com.arma.uetds_boot.yolcu.wsdl.UetdsYtsUser;
import com.arma.uetds_boot.yolcu.wsdl.YolcuBagajEkle;
import com.arma.uetds_boot.yolcu.wsdl.YolcuBagajEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.YolcuBagajIptal;
import com.arma.uetds_boot.yolcu.wsdl.YolcuBagajIptalResponse;
import com.arma.uetds_boot.yolcu.wsdl.YolcuBildirimSorgula;
import com.arma.uetds_boot.yolcu.wsdl.YolcuBildirimSorgulaResponse;
import com.arma.uetds_boot.yolcu.wsdl.YolcuEkle;
import com.arma.uetds_boot.yolcu.wsdl.YolcuEkleCoklu;
import com.arma.uetds_boot.yolcu.wsdl.YolcuEkleCokluResponse;
import com.arma.uetds_boot.yolcu.wsdl.YolcuEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.YolcuGelmeyenBildir;
import com.arma.uetds_boot.yolcu.wsdl.YolcuGelmeyenBildirResponse;
import com.arma.uetds_boot.yolcu.wsdl.YolcuIptal;
import com.arma.uetds_boot.yolcu.wsdl.YolcuIptalResponse;

public interface YolcuGetMethods {
	
	AracMuayeneSorgulaResponse aracMuayeneSorgula(AracMuayeneSorgula sorgula);
	
	SeferEkleResponse seferEkle(SeferEkle ekle);
	
	YolcuEkleResponse yolcuEkle(YolcuEkle ekle);
	
	SeferGrupEkleResponse grupEkle(SeferGrupEkle ekle);
	
	PersonelEkleResponse personelEkle(PersonelEkle ekle);
	
	YolcuEkleCokluResponse cokluEkle(YolcuEkleCoklu ekle);
	
	SeferIptalResponse seferIptal(SeferIptal iptal);
	
	YolcuIptalResponse yolcuIptal(YolcuIptal iptal);
	
	YolcuBagajEkleResponse bagajEkle(YolcuBagajEkle ekle);
	
	YolcuBagajIptalResponse bagajIptal(YolcuBagajIptal iptal);
	
	YolcuGelmeyenBildirResponse gelmeyenBildir(YolcuGelmeyenBildir bildir);
	
	YolcuBildirimSorgulaResponse bildirimSorgula(YolcuBildirimSorgula sorgula);
	
	SeferGrupIptalResponse grupIptal(SeferGrupIptal iptal);
	
	SeferPlakaDegistirResponse plakaDegistir(SeferPlakaDegistir degistir);
	
	SeferGuncelleResponse seferGuncelle(SeferGuncelle guncelle);
	
	SeferGrupGuncelleResponse grupGuncelle(SeferGrupGuncelle guncelle);
	
	SeferDetayCiktisiAlResponse detay(SeferDetayCiktisiAl detay);
	
	SeferAktifResponse aktif(SeferAktif aktif);
	
	SeferDetayCiktisiAlResponse cikti(SeferDetayCiktisiAl al);
	
	
	
	
	
	
}
