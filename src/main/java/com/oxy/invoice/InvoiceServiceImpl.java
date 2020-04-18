package com.oxy.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("InvoiceService")
@Transactional(readOnly = true)
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceDAO invoiceDAO;

    @Autowired
    public InvoiceServiceImpl(InvoiceDAO invoiceDAO) {
        this.invoiceDAO = invoiceDAO;
    }

    @Override
    @Transactional(readOnly = false)
    public void saveInvoice(Invoice invoice) {
        invoiceDAO.save(invoice);
    }

    @Override
    public List<Invoice> findAllInvoice() {
        List<Invoice> invoices = new ArrayList<>();
        invoiceDAO.findAll().forEach(invoices::add);
        return invoices;
    }
}
