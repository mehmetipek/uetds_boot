package com.arma.uetds_boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="cargo_notification")
public class CargoNotification {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long Id;
		
		@ManyToOne
		@JoinColumn(name = "cargo_not")
		private UetdsCompanies firma_id;
		
		private Long uetdsBildirimReferansNo;
		
	    private String aliciUnvan;
	    private String yuklemeUlkeKodu;
	    private String yuklemeIlMernisKodu;
	    private String yuklemeIlceMernisKodu;
	    private String bosaltmaUlkeKodu;
	    private String bosaltmaIlMernisKodu;
	    private String bosaltmaIlceMernisKodu;
	    private String gonderenUnvan;
	    private String gonderenVergiNo;
	    private String tasimaBedeli;
	    private String yukCinsId;
	    private String tasimaTuruKodu;
	    private String plaka1;
	    private String sofor1TCNo;
	    private String plaka2;
	    private String sofor2TcNo; 
	    private String yukDurum;
	    private String yuklemeTarihi;

	    
		public CargoNotification(UetdsCompanies firma_id, Long uetdsBildirimReferansNo, String aliciUnvan,
				String yuklemeUlkeKodu, String yuklemeIlMernisKodu, String yuklemeIlceMernisKodu,
				String bosaltmaUlkeKodu, String bosaltmaIlMernisKodu, String bosaltmaIlceMernisKodu,
				String gonderenUnvan, String gonderenVergiNo, String tasimaBedeli, String yukCinsId,
				String tasimaTuruKodu, String plaka1, String sofor1tcNo, String plaka2, String sofor2TcNo,
				String yukDurum, String yuklemeTarihi) {
			super();
			this.firma_id = firma_id;
			this.uetdsBildirimReferansNo = uetdsBildirimReferansNo;
			this.aliciUnvan = aliciUnvan;
			this.yuklemeUlkeKodu = yuklemeUlkeKodu;
			this.yuklemeIlMernisKodu = yuklemeIlMernisKodu;
			this.yuklemeIlceMernisKodu = yuklemeIlceMernisKodu;
			this.bosaltmaUlkeKodu = bosaltmaUlkeKodu;
			this.bosaltmaIlMernisKodu = bosaltmaIlMernisKodu;
			this.bosaltmaIlceMernisKodu = bosaltmaIlceMernisKodu;
			this.gonderenUnvan = gonderenUnvan;
			this.gonderenVergiNo = gonderenVergiNo;
			this.tasimaBedeli = tasimaBedeli;
			this.yukCinsId = yukCinsId;
			this.tasimaTuruKodu = tasimaTuruKodu;
			this.plaka1 = plaka1;
			this.sofor1TCNo = sofor1tcNo;
			this.plaka2 = plaka2;
			this.sofor2TcNo = sofor2TcNo;
			this.yukDurum = yukDurum;
			this.yuklemeTarihi = yuklemeTarihi;
		}
		
		public CargoNotification(Long Id,UetdsCompanies firma_id, Long uetdsBildirimReferansNo, String aliciUnvan,
				String yuklemeUlkeKodu, String yuklemeIlMernisKodu, String yuklemeIlceMernisKodu,
				String bosaltmaUlkeKodu, String bosaltmaIlMernisKodu, String bosaltmaIlceMernisKodu,
				String gonderenUnvan, String gonderenVergiNo, String tasimaBedeli, String yukCinsId,
				String tasimaTuruKodu, String plaka1, String sofor1tcNo, String plaka2, String sofor2TcNo,
				String yukDurum, String yuklemeTarihi) {
			super();
			this.Id=Id;
			this.firma_id = firma_id;
			this.uetdsBildirimReferansNo = uetdsBildirimReferansNo;
			this.aliciUnvan = aliciUnvan;
			this.yuklemeUlkeKodu = yuklemeUlkeKodu;
			this.yuklemeIlMernisKodu = yuklemeIlMernisKodu;
			this.yuklemeIlceMernisKodu = yuklemeIlceMernisKodu;
			this.bosaltmaUlkeKodu = bosaltmaUlkeKodu;
			this.bosaltmaIlMernisKodu = bosaltmaIlMernisKodu;
			this.bosaltmaIlceMernisKodu = bosaltmaIlceMernisKodu;
			this.gonderenUnvan = gonderenUnvan;
			this.gonderenVergiNo = gonderenVergiNo;
			this.tasimaBedeli = tasimaBedeli;
			this.yukCinsId = yukCinsId;
			this.tasimaTuruKodu = tasimaTuruKodu;
			this.plaka1 = plaka1;
			this.sofor1TCNo = sofor1tcNo;
			this.plaka2 = plaka2;
			this.sofor2TcNo = sofor2TcNo;
			this.yukDurum = yukDurum;
			this.yuklemeTarihi = yuklemeTarihi;
		}



		public CargoNotification() {
			super();
		}

		public Long getId() {
			return Id;
		}
		public void setId(Long id) {
			Id = id;
		}
		public UetdsCompanies getFirma_id() {
			return firma_id;
		}
		public void setFirma_id(UetdsCompanies firma_id) {
			this.firma_id = firma_id;
		}
		public Long getUetdsBildirimReferansNo() {
			return uetdsBildirimReferansNo;
		}
		public void setUetdsBildirimReferansNo(Long uetdsBildirimReferansNo) {
			this.uetdsBildirimReferansNo = uetdsBildirimReferansNo;
		}
		public String getAliciUnvan() {
			return aliciUnvan;
		}
		public void setAliciUnvan(String aliciUnvan) {
			this.aliciUnvan = aliciUnvan;
		}

		public String getGonderenUnvan() {
			return gonderenUnvan;
		}
		public void setGonderenUnvan(String gonderenUnvan) {
			this.gonderenUnvan = gonderenUnvan;
		}
		public String getGonderenVergiNo() {
			return gonderenVergiNo;
		}
		public void setGonderenVergiNo(String gonderenVergiNo) {
			this.gonderenVergiNo = gonderenVergiNo;
		}
		public String getPlaka1() {
			return plaka1;
		}
		public void setPlaka1(String plaka1) {
			this.plaka1 = plaka1;
		}
		public String getSofor1TCNo() {
			return sofor1TCNo;
		}
		public void setSofor1TCNo(String sofor1tcNo) {
			sofor1TCNo = sofor1tcNo;
		}
		public String getTasimaBedeli() {
			return tasimaBedeli;
		}
		public void setTasimaBedeli(String tasimaBedeli) {
			this.tasimaBedeli = tasimaBedeli;
		}
		public String getTasimaTuruKodu() {
			return tasimaTuruKodu;
		}
		public void setTasimaTuruKodu(String tasimaTuruKodu) {
			this.tasimaTuruKodu = tasimaTuruKodu;
		}

		public String getYukCinsId() {
			return yukCinsId;
		}
		public void setYukCinsId(String yukCinsId) {
			this.yukCinsId = yukCinsId;
		}

		public String getYuklemeTarihi() {
			return yuklemeTarihi;
		}
		public void setYuklemeTarihi(String yuklemeTarihi) {
			this.yuklemeTarihi = yuklemeTarihi;
		}


		public String getYuklemeUlkeKodu() {
			return yuklemeUlkeKodu;
		}


		public void setYuklemeUlkeKodu(String yuklemeUlkeKodu) {
			this.yuklemeUlkeKodu = yuklemeUlkeKodu;
		}


		public String getYuklemeIlMernisKodu() {
			return yuklemeIlMernisKodu;
		}


		public void setYuklemeIlMernisKodu(String yuklemeIlMernisKodu) {
			this.yuklemeIlMernisKodu = yuklemeIlMernisKodu;
		}


		public String getYuklemeIlceMernisKodu() {
			return yuklemeIlceMernisKodu;
		}


		public void setYuklemeIlceMernisKodu(String yuklemeIlceMernisKodu) {
			this.yuklemeIlceMernisKodu = yuklemeIlceMernisKodu;
		}


		public String getBosaltmaUlkeKodu() {
			return bosaltmaUlkeKodu;
		}


		public void setBosaltmaUlkeKodu(String bosaltmaUlkeKodu) {
			this.bosaltmaUlkeKodu = bosaltmaUlkeKodu;
		}


		public String getBosaltmaIlMernisKodu() {
			return bosaltmaIlMernisKodu;
		}


		public void setBosaltmaIlMernisKodu(String bosaltmaIlMernisKodu) {
			this.bosaltmaIlMernisKodu = bosaltmaIlMernisKodu;
		}


		public String getBosaltmaIlceMernisKodu() {
			return bosaltmaIlceMernisKodu;
		}


		public void setBosaltmaIlceMernisKodu(String bosaltmaIlceMernisKodu) {
			this.bosaltmaIlceMernisKodu = bosaltmaIlceMernisKodu;
		}


		public String getPlaka2() {
			return plaka2;
		}


		public void setPlaka2(String plaka2) {
			this.plaka2 = plaka2;
		}
		
		public String getSofor2TcNo() {
			return sofor2TcNo;
		}


		public void setSofor2TcNo(String sofor2TcNo) {
			this.sofor2TcNo = sofor2TcNo;
		}


		public String getYukDurum() {
			return yukDurum;
		}


		public void setYukDurum(String yukDurum) {
			this.yukDurum = yukDurum;
		}
		 
	    
	    
	    
	
	
}
