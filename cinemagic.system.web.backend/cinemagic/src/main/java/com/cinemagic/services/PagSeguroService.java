package com.cinemagic.services;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cinemagic.domain.Cliente;
import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Ingresso;
import com.cinemagic.domain.Enums.StatusCompra;
import com.cinemagic.domain.Enums.TipoIngresso;
import com.cinemagic.dto.xml.CheckoutDTO;
import com.cinemagic.dto.xml.NotificacaoDTO;

@Service
public class PagSeguroService {
	private final String EMAIL = "gabrielcamposfreitas12@gmail.com";
	private final String TOKEN = "991799a6-6d82-4f4f-8bc6-fd35279f6a9c3c13bd894cf2a2b7a173e286f9310c646217-988e-43ae-a9be-188eba8d3fd6";
	private final String URL = "https://ws.pagseguro.uol.com.br/v2/checkout?";
	private final String URLATUALIZAR = "https://ws.pagseguro.uol.com.br/v3/transactions/notifications/";
	@Autowired
	private CompraService compraService;

	public CheckoutDTO criarPagamento(Cliente cliente, Compra compra) {
		RestTemplate rest = new RestTemplate();

		MultiValueMap<String, String> map = getBody(cliente, compra);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		List<MediaType> l = new ArrayList<>();
		l.add(MediaType.APPLICATION_XML);
		l.add(MediaType.ALL);
		headers.setAccept(l);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL).queryParam("email", EMAIL)
				.queryParam("token", TOKEN);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<CheckoutDTO> response = rest.postForEntity(builder.toUriString(), request, CheckoutDTO.class);
		response.getBody()
				.setCode("https://pagseguro.uol.com.br/v2/checkout/payment.html?code=" + response.getBody().getCode());
		return response.getBody();

	}

	public void atualizarTransacao(String code) {
		RestTemplate rest = new RestTemplate();

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URLATUALIZAR).path(code)
				.queryParam("email", EMAIL).queryParam("token", TOKEN);

		// ResponseEntity<NotificacaoDTO> response =
		// rest.getForEntity(builder.toUriString(),NotificacaoDTO.class);
		ResponseEntity<String> response = rest.getForEntity(builder.toUriString(), String.class);

		int status = Integer.parseInt(teste(response.getBody()));
		int reference = Integer.parseInt(teste2(response.getBody()));

		atualizarCompra(status, reference);

		// atualizarCompra(response.getBody());

	}

	private void atualizarCompra(int status, int reference) {
		Compra compra = compraService.findById(reference);
		switch (status) {
		case 1:
			compra.setStatusCompra(StatusCompra.ESPERANDO_PAGAMENTO);
			break;
		case 2:
			compra.setStatusCompra(StatusCompra.ANALISE);
			break;
		case 3:
			compra.setStatusCompra(StatusCompra.PAGO);
			break;
		case 7:
			compra.setStatusCompra(StatusCompra.CANCELADO);
			break;
		}
		compraService.update(compra);
	}

	private MultiValueMap<String, String> getBody(Cliente cliente, Compra compra) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("currency", "BRL");

		setItens(compra.getIngressos(), map);

		map.add("shippingAddressRequired", "false");

		map.add("senderName", cliente.getNome());
		map.add("senderEmail", cliente.getEmail());
		map.add("senderAreaCode", cliente.getAreaCode());
		map.add("senderPhone", cliente.getPhone());
		map.add("senderCPF", cliente.getCpf());
		map.add("reference", compra.getId().toString());
		map.add("redirectURL", "https://moodle.unipampa.edu.br/moodle/");
		map.add("notificationURL", "https://cinemagic-grupo04.herokuapp.com/notificacao");
		map.add("receiverEmail", "gabrielcamposfreitas12@gmail.com");
		map.add("maxUses", "10");
		map.add("maxAge", "10000");
		return map;
	}

	private void setItens(List<Ingresso> itens, MultiValueMap<String, String> map) {

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);

		int i = 1;
		for (Ingresso x : itens) {
			map.add("itemId" + i, x.getId().toString());
			map.add("itemDescription" + i,
					x.getTipoIngresso() == TipoIngresso.INTEIRA ? "Ingresso Inteira" : "Ingresso Meia");
			map.add("itemAmount" + i,
					x.getTipoIngresso() == TipoIngresso.INTEIRA
							? String.valueOf(nf.format(x.getSessao().getValorInteira())).replace(",", ".")
							: String.valueOf(nf.format(x.getSessao().getValorMeia())).replace(",", "."));
			map.add("itemQuantity" + i, "1");
			map.add("itemWeight" + i, "1");
			i++;
		}

	}

	private String teste(String a) {
		String b = a.substring(a.indexOf("<status>"), a.lastIndexOf("</status>"));
		return b.replaceAll("<status>", "");

	}

	private String teste2(String a) {
		String b = a.substring(a.indexOf("<reference>"), a.lastIndexOf("</reference>"));
		return b.replaceAll("<reference>", "");
	}

}
