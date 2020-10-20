package com.pratyush.giftservice.service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import com.pratyush.giftservice.entity.RedeemCode;
import com.pratyush.giftservice.entity.RedeemProducts;
import com.pratyush.giftservice.repository.RedeemHistoryRepository;
import com.pratyush.giftservice.repository.RedeemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class RedeemServiceImpl implements RedeemService{
@Autowired
private RedeemRepository redeemRepository;

@Autowired
private RedeemHistoryRepository redeemHistoryRepo;
	@Override
	public RedeemCode generateRedeemCode(String userId, int cartId) {
		RedeemCode redeem = new RedeemCode();
		
		String redeemCode = createRandomCode(userId,cartId);
		if(redeemRepository.existsById(redeemCode)) {
			redeemCode = createRandomCode(userId, cartId);
		}
		redeem.setRedeemCode(redeemCode);
		return redeemRepository.save(redeem);
	}
	
	 public String createRandomCode(String userId,int cartId){   
	     String randomGen = ""+userId+""+cartId;
	     char[] chars = randomGen.toCharArray();
	        StringBuilder sb = new StringBuilder();
	        int codeLength=8;
	        Random random = new SecureRandom();
	        for (int i = 0; i < codeLength; i++) {
	            char c = chars[random.nextInt(chars.length)];
	            sb.append(c);
	        }  
	        String output = sb.toString();
	        System.out.println(output);
	        return output ;
	    }

	@Override
	public boolean validateRedeemCode(String redeemID) {
		return redeemRepository.existsById(redeemID);
	}

	@Override
	public RedeemProducts redeemProducts(RedeemProducts redeemProducts) {
		return redeemHistoryRepo.save(redeemProducts);
	}

	

}
