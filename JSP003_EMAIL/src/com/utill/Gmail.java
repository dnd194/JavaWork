package com.utill;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator {

    @Override

    protected PasswordAuthentication getPasswordAuthentication() {

        return new PasswordAuthentication("preandero@gmail.com","cgtofmbbqqsdhvus");

    }

}



