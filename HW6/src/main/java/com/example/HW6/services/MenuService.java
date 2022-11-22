package com.example.HW6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuService {

    @Autowired
    private UserService userServices;

    public void run() {
        userServices.showMenu();
        choosingOption();
    }

    private void choosingOption() {
        int i = userServices.makeDecision();
        if (i == 1) {
            firstOption();
            run();
        } else if (i == 2) {
            secondOption();
            run();
        } else if (i == 3) {
            thirdOption();
            run();
        } else if (i == 4) {
            fourthOption();
            run();
        } else if (i == 5) {
            fifthOption();
            run();
        }
    }

    @Transactional
    private void firstOption() {
        userServices.createUserOption();
    }

    @Transactional
    private void secondOption() {
        userServices.updateUserOption();
    }

    @Transactional
    private void thirdOption() {
        userServices.deleteUserOption();
    }

    private void fourthOption() {
        userServices.showConcreteUserOption();
    }

    private void fifthOption() {
        userServices.showAllUsersOption();
    }
}
