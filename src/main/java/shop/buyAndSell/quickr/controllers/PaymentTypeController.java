package shop.buyAndSell.quickr.controllers;

import java.util.List;

import shop.buyAndSell.quickr.models.PaymentType;
import shop.buyAndSell.quickr.services.PaymentTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentTypeController {
    @Autowired
    PaymentTypeService paymentTypeService;

    @PostMapping("/savePaymentType")
    public ResponseEntity savePaymentType(@RequestBody PaymentType paymentType)
    {
        PaymentType newPaymentType=paymentTypeService.savePaymentType(paymentType);
        if(paymentType==null)
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        else
            return ResponseEntity.ok(newPaymentType);
    }

    @GetMapping("/fetchPaymentType")
    public ResponseEntity loadPaymentType()
    {
        List<PaymentType> p= paymentTypeService.loadPaymentType();
        return ResponseEntity.ok(p);
    }

    @PutMapping("/updatePaymentType")
	public ResponseEntity updatePaymentType(@RequestBody PaymentType paymentType) 
	{		
		PaymentType newPaymentType = paymentTypeService.updatepaymentType(paymentType);	
		if(newPaymentType==null)
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);		
		else
			return ResponseEntity.ok(newPaymentType);
	}
	
	@DeleteMapping("/deletePaymentType/{id}")
	public ResponseEntity deletePaymentType(@PathVariable String id) 
	{		
		System.out.println(id);
		PaymentType paymentType = paymentTypeService.get(id);
        if(paymentType==null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);		
		else
		{
			boolean result = paymentTypeService.deletepaymentType(paymentType);
			if(result)
				return new ResponseEntity<>(HttpStatus.OK);	
			else
				return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
		}
		
	}
}
