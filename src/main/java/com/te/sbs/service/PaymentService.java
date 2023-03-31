package com.te.sbs.service;

import com.te.sbs.dto.PaymentDto;

public interface PaymentService {

	PaymentDto updatePaymentInfo(PaymentDto paymentDto, Integer id);

}
