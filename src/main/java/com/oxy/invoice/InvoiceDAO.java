package com.oxy.invoice;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface InvoiceDAO extends PagingAndSortingRepository<Invoice, String> {
}
