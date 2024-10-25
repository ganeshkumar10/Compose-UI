package com.example.blogapplication.interview;

import java.util.Date;

public class Testing {

    private ValidateConst validateConst = null;
    private AppUtils appUtils = null;

    void userName() {
        validateConst = new ValidateConst();
        validateConst.textValWithoutConst();
        AppUtils.install();
        AppUtils.install();
    }

    Session one = new Session("Dine", new Date());
    Session two = new Session("ABI");

    SessionNew aNew = new SessionNew("Hlkmdc","asdasd");
//    SessionNew aNew1 = new SessionNew("Hlkmdc");
}


