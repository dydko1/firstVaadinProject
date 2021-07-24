package com.vaadin.tutorial.crm.ui.views.list;

import com.vaadin.tutorial.crm.backend.entity.Company;
import com.vaadin.tutorial.crm.backend.entity.Contact;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ContractForm1Test {
    private List<Company> companies;
    private Contact miroDydu;
    private Company company1;
    private Company company2;

    @Before
    public void setupData() {
        companies = new ArrayList<>();
        company1 = new Company("Miro Firma");
        company2 = new Company("Miro2 Firma2");
        companies.addAll(Arrays.asList(company1, company2));

        miroDydu = new Contact();
        miroDydu.setFirstName("Mirosław");
        miroDydu.setLastName("Dyduch");
        miroDydu.setEmail("miroslaw.dyduch@gmail.com");
        miroDydu.setStatus(Contact.Status.NotContacted);
        miroDydu.setCompany(company1);
    }

    @Test
    public void formFieldsPopulated() {
        ContactForm form = new ContactForm(companies);
        form.setContact(miroDydu);
        Assert.assertEquals("Mirosław", form.firstName.getValue());
        Assert.assertEquals("Dyduch", form.lastName.getValue());
        Assert.assertEquals("miroslaw.dyduch@gmail.com", form.email.getValue());
        Assert.assertEquals(company1, form.company.getValue());
        Assert.assertEquals(Contact.Status.NotContacted, form.status.getValue());
    }

    @Test
    public void saveEventHasCorrectValues() {
        ContactForm form = new ContactForm(companies);
        Contact contact = new Contact();
        form.setContact(contact);

        form.firstName.setValue("Miro");
        form.lastName.setValue("Dydko");
        form.company.setValue(company1);
        form.email.setValue("miro@wp.pl");
        form.status.setValue(Contact.Status.Customer);

        AtomicReference<Contact> saveContractRef = new AtomicReference<>(null);
        form.addListener(ContactForm.SaveEvent.class, e -> saveContractRef.set(e.getContact()));

        form.save.click();
        Contact savedContract = saveContractRef.get();

        Assert.assertEquals("Miro",savedContract.getFirstName());
        Assert.assertEquals("Dydko",savedContract.getLastName());
        Assert.assertEquals("miro@wp.pl",savedContract.getEmail());
        Assert.assertEquals(company1,savedContract.getCompany());
        Assert.assertEquals(Contact.Status.Customer,savedContract.getStatus());
    }

}
