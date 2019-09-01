package com.javastudio.tutorial;

import com.javastudio.tutorial.model.SampleWithoutAnnotation;
import com.javastudio.tutorial.service.GeneralService;
import com.javastudio.tutorial.type.CharacterEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class Main {

    static Logger logger = LoggerFactory.getLogger(Main.class);

    static GeneralService service = new GeneralService();

    public static void main(final String[] args) throws Exception {

        SampleWithoutAnnotation sampleWithoutAnnotation = new SampleWithoutAnnotation();
        sampleWithoutAnnotation.setId(1L);
        sampleWithoutAnnotation.setCardNumber("5859471010067944");
        sampleWithoutAnnotation.setTransactionAmount(1.0);
        sampleWithoutAnnotation.setTransactionDate(new Date());

        service.save(sampleWithoutAnnotation);
        logger.info("Applet info saved successfully.");

        // findAllAppletInfo();
    }

//    private static void findAllAppletInfo() {
//        List list = service.findAll(AppletInfo.class);
//        for (Object o : list) {
//            AppletInfo appletInfo = (AppletInfo) o;
//            logger.info(String.format("| %8d | %-30s | %2d | %-40s | %2s |",
//                    appletInfo.getId(),
//                    appletInfo.getApplicationLabel(),
//                    appletInfo.getApplicationPriorityIndicator(),
//                    appletInfo.getIssuerCodeTableIndex(),
//                    appletInfo.getIssuerCodeTableIndex().getString()
//            ));
//        }
//    }

    public static int unsignedToBytes(byte b) {
        return b & 0xFF;
    }
}
