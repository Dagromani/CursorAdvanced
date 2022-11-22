package com.example.HW6.services;

import com.example.HW6.entity.User;
import com.example.HW6.util.MenuOptions;
import com.example.HW6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Scanner;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void showMenu() {
        System.out.println(MenuOptions.CHOOSE);
        System.out.println(MenuOptions.FIRST_OPTION);
        System.out.println(MenuOptions.SECOND_OPTION);
        System.out.println(MenuOptions.THIRD_OPTION);
        System.out.println(MenuOptions.FOURTH_OPTION);
        System.out.println(MenuOptions.FIFTH_OPTION);
    }

    public int makeDecision() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        return i;
    }

    public User settingUser() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        User newUser = new User();
        System.out.println("Enter user first name.");
        newUser.setFirstName(scanner.nextLine());
        System.out.println("Enter user second name.");
        newUser.setSecondName(scanner.nextLine());
        System.out.println("Enter user age.");
        newUser.setAge(scanner.nextInt());
        System.out.println("Enter user gender.");
        newUser.setGender(scanner2.nextLine());
        return newUser;
    }

    public User settingUserWithId() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        User newUser = new User();
        System.out.println("Enter user id.");
        newUser.setId(scanner3.nextLong());
        System.out.println("Enter user first name.");
        newUser.setFirstName(scanner.nextLine());
        System.out.println("Enter user second name.");
        newUser.setSecondName(scanner.nextLine());
        System.out.println("Enter user age.");
        newUser.setAge(scanner.nextInt());
        System.out.println("Enter user gender.");
        newUser.setGender(scanner2.nextLine());
        return newUser;
    }

    public Long enterId() {
        Scanner scanner = new Scanner(System.in);
        Long i;
        System.out.println("Enter user id:");
        i = scanner.nextLong();
        return i;
    }

    @Transactional
    public void createUserOption() {
        userRepository.save(settingUser());
        System.out.println("User added!");
    }

    @Transactional
    public void updateUserOption() {
        userRepository.update(settingUserWithId());
        System.out.println("User updated!");
    }

    @Transactional
    public void deleteUserOption() {
        userRepository.deleteUser(enterId());
        System.out.println("User deleted!");
    }

    public void showConcreteUserOption() {
        System.out.println(userRepository.findById(enterId()));
    }

    public void showAllUsersOption() {
        System.out.println(userRepository.getAll());
    }
}
