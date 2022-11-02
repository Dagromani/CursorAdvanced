package com.example.HW6.View;

import com.example.HW6.Services.MenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Menu {

    @Autowired
    private MenuServices menuServices;

    public void run(){
        menuServices.showMenu();
        choosingOption();
    }

    public void choosingOption() {
        int i = menuServices.makeDecision();
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
    public void firstOption(){
        menuServices.createUserOption();
    }

    @Transactional
    public void secondOption(){
        menuServices.updateUserOption();
    }

    @Transactional
    public void thirdOption() {
        menuServices.deleteUserOption();
    }

    public void fourthOption() {
        menuServices.showConcreteUserOption();
    }

    public void fifthOption() {
        menuServices.showAllUsersOption();
    }
}
