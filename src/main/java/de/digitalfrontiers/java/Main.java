package de.digitalfrontiers.java;

import lombok.Value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();

        Contact contact = new Contact();
        contact.setFirstName("Max");
        contact.setLastName("Mustermann");

        Contact contact2 = contact;

        main.updateNumber(contact, "01234-567890");

        System.out.println(contact2.getPhoneNumber());
        System.out.println(contact2.getFirstName());
        System.out.println(contact2.getLastName());

        ContactValueObject valueObject = main.new ContactValueObject("", "", "");



        List<Integer> values = new ArrayList<>();


        values.add(42);

        List<Integer> immutable = Collections.unmodifiableList(values);
        //immutable.add(42); // ?

        boolean isValid = FooAlgorithm.isValid(42);
        System.out.println(LuhnTest.isValid(49927398716L));
        System.out.println(LuhnTest.isValid(49927398717L));

    }

    private void updateNumber(Contact contact,
                              String phoneNumber) {
        validate(phoneNumber);

        contact.setPhoneNumber(phoneNumber);
    }

    private void validate(String phoneNumber) {

    }

    @Value
    class ContactValueObject {
        private String firstName;
        private String lastName;
        private String phoneNumber;
    }

}
