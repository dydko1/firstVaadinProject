package com.vaadin.tutorial.crm.ui.views.list;

import com.vaadin.tutorial.crm.backend.entity.Company;
import com.vaadin.tutorial.crm.backend.entity.Contact;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContractForm1Test {
    private List<Company> companies;
    private Contact miroDydu;
    private Company company1;
    private Company company2;

    @Before
    public void setupData() {
        //companies = new ArrayList<>();
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
}
