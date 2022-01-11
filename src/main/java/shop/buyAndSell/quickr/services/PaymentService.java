package shop.buyAndSell.quickr.services;

import shop.buyAndSell.quickr.models.Payment;
import shop.buyAndSell.quickr.repositories.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    
    @Autowired
    PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment)
    {
        try{
            paymentRepository.insert(payment);
            return payment;
        }catch(Exception e){
            return null;
        }
    }
}
