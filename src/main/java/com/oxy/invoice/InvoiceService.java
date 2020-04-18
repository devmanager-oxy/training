package com.oxy.invoice;

import java.util.List;

public interface InvoiceService {

    void saveInvoice(Invoice invoice);

    List<Invoice> findAllInvoice();
}
