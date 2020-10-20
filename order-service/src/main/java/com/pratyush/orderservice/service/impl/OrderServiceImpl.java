package com.pratyush.orderservice.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import com.pratyush.orderservice.dto.CartDto;
import com.pratyush.orderservice.dto.MessageBody;
import com.pratyush.orderservice.dto.OrderDto;
import com.pratyush.orderservice.dto.ProductDto;
import com.pratyush.orderservice.entity.Order;
import com.pratyush.orderservice.entity.sequencegenerator.SequenceGeneratorService;
import com.pratyush.orderservice.repository.OrderRepository;
import com.pratyush.orderservice.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private static final String TOPIC = "TestTopic";

	private ModelMapper mapper = new ModelMapper();

	private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

	@Bean
	public JavaMailSender getJavaMailSender() {
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}
	
	@Override
	public OrderDto purchaseProductService(CartDto cartDto) {
		Order order = mapper.map(cartDto, Order.class);
		order.setOrderId(sequenceGeneratorService.generateSequence(Order.SEQUENCE_NAME));
		order.setPurchaseDate(new Date(System.currentTimeMillis()));
		order = orderRepository.save(order);
		return mapper.map(order, OrderDto.class);
	}

	@Override
	public List<ProductDto> getGiftService(String redeemCode) {
		System.out.println("service " + redeemCode);
		Order order = orderRepository.findByRedeemCode(redeemCode);
		order.setRedeemDate(new Date(System.currentTimeMillis()));
		return order.getAllSelectedProduct().stream().map(n -> mapper.map(n, ProductDto.class)).collect(Collectors.toList());
	}

	@Override
	public void emailService(CartDto cartDto, MessageBody messageBody) {
		SimpleMailMessage mail = new SimpleMailMessage();

		mailSender.setUsername(cartDto.getUserEmail());
		mailSender.setPassword(cartDto.getUserPassword());
		mail.setTo(cartDto.getRecipientEmail());
		mail.setSubject("Yo-Yo Gifts");
		mail.setText(messageBody.toString());
		String mailString=""+cartDto.getUserEmail()+"\n"+cartDto.getRecipientEmail()+"\n"+cartDto.getRedeemCode();
		kafkaTemplate.send(TOPIC, mailString);

		mailSender.send(mail);

	}

	

}
