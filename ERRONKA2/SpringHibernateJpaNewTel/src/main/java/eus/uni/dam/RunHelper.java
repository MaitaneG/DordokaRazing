package eus.uni.dam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class RunHelper {
//    @Value("\t -b \t\t |Bezeroak exportatzeko\n" +
//            "\t -s \t\t |Salmentak exportatzeko\n" +
//            "\t -p \t\t |Produktuak exportatzeko\n" +
//            "\t -a \t\t |Denak exportatzeko" +
//            "\t -h/-help")
    private String helper;

    @PostConstruct
    public void init() {
        // @formatter:off
        helper = "\t\t ERABILTZEKO AUKERAK:\n\n" +
                "\t -b \t\t |Bezeroak exportatzeko\n" +
                "\t -s \t\t |Salmentak exportatzeko\n" +
                "\t -p \t\t |Produktuak exportatzeko\n" +
                "\t -e \t\t |Erosketak exportatzeko\n" +
                "\t -a \t\t |Denak exportatzeko\n" +
                "\t -h \t\t |Help";
        // formatter:on
    }
//    public RunHelper(){
//        this.helper= "\t -b \t\t |Bezeroak exportatzeko\n" +
//                "\t -s \t\t |Salmentak exportatzeko\n" +
//                "\t -p \t\t |Produktuak exportatzeko\n" +
//                "\t -a \t\t |Denak exportatzeko" +
//                "\t -h \t\t-help";
//    }


    public String getHelper() {
        return helper;
    }
}
