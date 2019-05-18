package com.javastudio.tutorial;

import com.javastudio.tutorial.model.AppletInfo;
import com.javastudio.tutorial.service.GeneralService;

public class Main {

    static GeneralService service = new GeneralService();

    public static void main(final String[] args) throws Exception {

        AppletInfo appletInfo = new AppletInfo();
        appletInfo.setApplicationLabel("Middle East Bank");

        service.save(appletInfo);

    }
}
