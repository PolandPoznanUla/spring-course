package com.sda.springcourse.model;

import org.springframework.stereotype.Component;

@Component
public class CreationStatusFactory {


    public CreationStatus createSuccessStatus(String message) {
        return createStatus(true, message);
    }

    public CreationStatus createFailureStatus(String message) {
        return createStatus(false, message);
    }

    private CreationStatus createStatus(boolean status, String message) {
        CreationStatus creationStatus = new CreationStatus();
        creationStatus.setStatus(status);
        creationStatus.setMessage(message);
        return creationStatus;
    }
}

//1. dokonczyc factory /\
//2. w UserController zmienic 3 zmienne na jeden obiekt CreationStatus
//3. Na html:
// - jezeli status jest null, to nie wyswietlamy alertu
// - jezeli status ma status == true to alert-basic
// - jezeli status ma status == false to alert-error

// 1. Napisac na stronie /users formularz do tworzenia nowych userow
// 2. (html i PostMapping)
// * fragment creationStatus-alert





