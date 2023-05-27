package com.mikedgl.desafio1;

import com.mikedgl.desafio1.entities.Order;
import com.mikedgl.desafio1.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Digíte os dados do pedido: \n");
		System.out.print("Código: ");
		Integer code = sc.nextInt();
		System.out.print("Valor básico R$: ");
		Double basic = sc.nextDouble();
		System.out.print("Desconto %: ");
		Double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		Double totalValue = orderService.total(order);

		System.out.printf("%nPedido código %d%n", order.getCode());
		System.out.printf("Valor total: R$ %.2f", totalValue);

		sc.close();
	}
}
