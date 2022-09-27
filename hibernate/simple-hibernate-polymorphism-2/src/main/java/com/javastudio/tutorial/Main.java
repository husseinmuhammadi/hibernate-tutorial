package com.javastudio.tutorial;

import com.javastudio.tutorial.model.entity.Person;
import com.javastudio.tutorial.model.repository.DataMgr;
import com.javastudio.tutorial.service.CardPaymentService;
import com.javastudio.tutorial.service.CashPaymentService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {



    public static void main(String[] args) {

        HibernateSample hibernateSample = new HibernateSample();
        hibernateSample.anySave();
        hibernateSample.anyLoad();

    }

}
