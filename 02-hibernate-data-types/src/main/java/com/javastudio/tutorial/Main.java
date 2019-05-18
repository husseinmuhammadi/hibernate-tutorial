package com.javastudio.tutorial;

import com.javastudio.tutorial.model.AppletInfo;
import com.javastudio.tutorial.service.GeneralService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    static Logger logger = LoggerFactory.getLogger(Main.class);

    static GeneralService service = new GeneralService();

    public static void main(final String[] args) throws Exception {

        AppletInfo appletInfo = new AppletInfo();
        appletInfo.setApplicationLabel("Middle East Bank");
        appletInfo.setApplicationPriorityIndicator(unsignedToBytes((byte) 1));


        service.save(appletInfo);
        logger.info("Applet info saved successfully.");
    }

    public static int unsignedToBytes(byte b) {
        return b & 0xFF;
    }
}
