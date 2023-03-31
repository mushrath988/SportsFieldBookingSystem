package com.te.sbs.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.sbs.dto.PaymentDto;
import com.te.sbs.entity.Payment;
import com.te.sbs.exception.PaymentNotSuccessful;
import com.te.sbs.repository.PaymentRepository;
import com.te.sbs.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public PaymentDto updatePaymentInfo(PaymentDto paymentDto, Integer id) {
		Payment payment = paymentRepository.findById(id).orElseThrow(()->
		new PaymentNotSuccessful("Payment not Successful" ,id));
		if (paymentDto.getAmount() != null) {
			payment.setAmount(paymentDto.getAmount());
		}
		if (paymentDto.getPaymentDate() != null) {
			payment.setPaymentDate(paymentDto.getPaymentDate());
		}
		if (paymentDto.getPaymentMethod() != null) {
			payment.setPaymentMethod(paymentDto.getPaymentMethod());
		}
		PaymentDto newPaymentDto = new PaymentDto();
		BeanUtils.copyProperties(payment, newPaymentDto);
		paymentRepository.save(payment);

		return newPaymentDto;
	}

}
