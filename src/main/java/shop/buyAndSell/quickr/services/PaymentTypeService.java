package shop.buyAndSell.quickr.services;

import java.util.List;

import shop.buyAndSell.quickr.models.PaymentType;
import shop.buyAndSell.quickr.repositories.PaymentTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentTypeService {
    @Autowired
    PaymentTypeRepository paymentTypeRepository;

    public PaymentType savePaymentType(PaymentType paymentType)
    {
        try{
            paymentTypeRepository.insert(paymentType);
            return paymentType;
        }catch(Exception e){
            return null;
        }
    }

    public List<PaymentType> loadPaymentType()
    {
        try{
            List<PaymentType> p= paymentTypeRepository.findAll();
            return p;
        }catch(Exception e)
        {
            return null;
        }
    }

    public PaymentType get(String id)
    {
        try{
            return paymentTypeRepository.findById(id).get();
        }catch(Exception e)
        {
            return null;
        }
    }

    public PaymentType updatepaymentType(PaymentType paymentType) 
	{
		try {
			paymentTypeRepository.save(paymentType);			
			return paymentType;
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public Boolean deletepaymentType(PaymentType paymentType) 
	{
		try {
			paymentTypeRepository.delete(paymentType);				
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
