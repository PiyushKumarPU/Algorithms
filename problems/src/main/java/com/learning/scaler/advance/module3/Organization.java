package com.learning.scaler.advance.module3;

import java.util.ArrayList;
import java.util.List;

public class Organization {
    String name;
    List<Organization> subOrganizations;

    public Organization(String name) {
        this.name = name;
        this.subOrganizations = new ArrayList<>();
    }

    public void addSubOrganization(Organization subOrganization) {
        this.subOrganizations.add(subOrganization);
    }

    public void printHierarchy(int level) {
        System.out.println("  ".repeat(Math.max(0, level)) + name);
        for (Organization subOrg : subOrganizations) {
            subOrg.printHierarchy(level + 1);
        }
    }

    public static void main(String[] args) {
        Organization root = new Organization("Root Organization");

        Organization division1 = new Organization("Division 1");
        Organization department1_1 = new Organization("Department 1.1");
        Organization department1_2 = new Organization("Department 1.2");

        Organization division2 = new Organization("Division 2");
        Organization department2_1 = new Organization("Department 2.1");
        Organization department2_2 = new Organization("Department 2.2");

        root.addSubOrganization(division1);
        root.addSubOrganization(division2);

        division1.addSubOrganization(department1_1);
        division1.addSubOrganization(department1_2);

        division2.addSubOrganization(department2_1);
        division2.addSubOrganization(department2_2);

        // Print the organization hierarchy
        root.printHierarchy(0);
    }
}
