package eus.uni.dam;
															//Aplikazioa exekutatzen duen main klasea.
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppProduktuak {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);	
		
		((AnnotationConfigApplicationContext) appContext).close();
	}

}
