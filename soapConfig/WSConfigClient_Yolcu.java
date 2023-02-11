package com.arma.uetds_boot.soapConfig;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import com.arma.uetds_boot.implement.PageInputMethodsImpl;
import com.arma.uetds_boot.implement.YolcuGetMethodsImpl;


@Configuration
public class WSConfigClient_Yolcu {
	

	@Value("${client.yolcu}")
	private String defaultUri;

	@Value("${client.user.name}")
	private String userName;

	@Value("${client.user.password}")
	private String userPassword;

	@Bean
	public Jaxb2Marshaller jaxb2Marshaller_yolcu() {
		Jaxb2Marshaller jaxb2Marshaller_yolcu = new Jaxb2Marshaller();
		jaxb2Marshaller_yolcu.setContextPath("com.arma.uetds_boot.yolcu.wsdl");

		return jaxb2Marshaller_yolcu;

	}

	@Bean
	public WebServiceTemplate webServiceTemplate_yolcu() {

		WebServiceTemplate webServiceTemplate_yolcu = new WebServiceTemplate();
		webServiceTemplate_yolcu.setMarshaller(jaxb2Marshaller_yolcu());
		webServiceTemplate_yolcu.setUnmarshaller(jaxb2Marshaller_yolcu());
		webServiceTemplate_yolcu.setDefaultUri(defaultUri);
		webServiceTemplate_yolcu.setMessageSender(httpComponentsMessageSender_yolcu());

		return webServiceTemplate_yolcu;
	}

	@Bean
	public HttpComponentsMessageSender httpComponentsMessageSender_yolcu() {
		HttpComponentsMessageSender httpComponentsMessageSender_yolcu = new HttpComponentsMessageSender();
		httpComponentsMessageSender_yolcu.setCredentials(usernamePasswordCredentials_yolcu());

		return httpComponentsMessageSender_yolcu;
	}

	@Bean
	public UsernamePasswordCredentials usernamePasswordCredentials_yolcu() {
		
		System.out.println(userName);
		System.out.println(userPassword);
		return new UsernamePasswordCredentials(userName, userPassword);
	}

	
	@Bean
	public YolcuGetMethodsImpl getYolcuClient() {
		YolcuGetMethodsImpl client=new YolcuGetMethodsImpl();
		client.setDefaultUri("https://servis.turkiye.gov.tr/services/g2g/kdgm/uetdsarizi?wsdl");
		client.setMarshaller(jaxb2Marshaller_yolcu());
		client.setUnmarshaller(jaxb2Marshaller_yolcu());
		client.setWebServiceTemplate(webServiceTemplate_yolcu());
		return client;
	}



}
