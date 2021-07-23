package com.vaadin.tutorial.crm.ui.views.list;

import com.vaadin.tutorial.crm.backend.entity.Company;
import com.vaadin.tutorial.crm.backend.entity.Contact;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactFormTest {
    private List<Company> companies;
    private Contact marcUsher;
    private Company company1;
    private Company company2;
    //private Company company3;

    @Before
    public void setupData() {
        companies = new ArrayList<>();
        company1 = new Company("Vaadin Ltd");
        company2 = new Company("IT Mill");
        //company3 = new Company("Miro test");
        //companies.add(company1);
        //companies.add(company2);
        //companies.add(company3);
        companies.addAll(Arrays.asList(company1, company2));

        marcUsher = new Contact();
        marcUsher.setFirstName("Marc");
        marcUsher.setLastName("Usher");
        marcUsher.setEmail("marc@usher.com");
        marcUsher.setStatus(Contact.Status.NotContacted);
        marcUsher.setCompany(company1);
    }

    @Test
    public void formFieldsPopulated() {
        ContactForm form = new ContactForm(companies);
        form.setContact(marcUsher);
        Assert.assertEquals("Marc", form.firstName.getValue());
        Assert.assertEquals("Usher", form.lastName.getValue());
        Assert.assertEquals("marc@usher.com", form.email.getValue());
        Assert.assertEquals(company1, form.company.getValue());
        Assert.assertEquals(Contact.Status.NotContacted, form.status.getValue());
        System.out.println("Test:\t" + form.status.getValue());
    }
}

