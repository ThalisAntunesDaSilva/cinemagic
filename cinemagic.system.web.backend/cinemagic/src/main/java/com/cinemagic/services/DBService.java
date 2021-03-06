package com.cinemagic.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cinemagic.domain.Ator;
import com.cinemagic.domain.Atua;
import com.cinemagic.domain.Cidade;
import com.cinemagic.domain.Cinema;
import com.cinemagic.domain.Cliente;
import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Estado;
import com.cinemagic.domain.Filme;
import com.cinemagic.domain.Genero;
import com.cinemagic.domain.Ingresso;
import com.cinemagic.domain.Pais;
import com.cinemagic.domain.Sala;
import com.cinemagic.domain.Sessao;
import com.cinemagic.domain.Enums.Perfil;
import com.cinemagic.domain.Enums.TipoIngresso;
import com.cinemagic.domain.Enums.TipoPagamento;
import com.cinemagic.repositories.AtorRepository;
import com.cinemagic.repositories.AtuaRepository;
import com.cinemagic.repositories.CidadeRepository;
import com.cinemagic.repositories.CinemaRepository;
import com.cinemagic.repositories.ClienteRepository;
import com.cinemagic.repositories.CompraRepository;
import com.cinemagic.repositories.EstadoRepository;
import com.cinemagic.repositories.FilmeRepository;
import com.cinemagic.repositories.GeneroRepository;
import com.cinemagic.repositories.IngressoRepository;
import com.cinemagic.repositories.PaisRepository;
import com.cinemagic.repositories.SalaRepository;
import com.cinemagic.repositories.SessaoRepository;

@Service
public class DBService {
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private AtorRepository atorRepository;
	@Autowired
	private AtuaRepository atuaRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private CinemaRepository cinemaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private FilmeRepository filmeRepository;
	@Autowired
	private GeneroRepository generoRepository;
	@Autowired
	private IngressoRepository ingressoRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private SalaRepository salaRepository;
	@Autowired
	private SessaoRepository sessaoRepository;

	public void instantiateTestDatabase() throws ParseException {
		Ator ator1 = new Ator(null, "Tom Holland");
		Genero genero1 = new Genero(null, "Herói");
		Filme filme1 = new Filme(null, "Homem Aranha 3", "1h30", genero1);
		genero1.getFilmes().addAll(Arrays.asList(filme1));
		Atua atua1 = new Atua(null, "Petter Parker", ator1, filme1);

		ator1.getAtuacoes().addAll(Arrays.asList(atua1));
		Pais pais1 = new Pais(null, "Brasil");
		Estado estado1 = new Estado(null, "Rio Grande do Sul", "RS", pais1);
		pais1.getEstados().addAll(Arrays.asList(estado1));
		Cidade cidade1 = new Cidade(null, "Alegrete", estado1);
		Cidade cidade2 = new Cidade(null, "Uruguaiana", estado1);
		estado1.getCidades().addAll(Arrays.asList(cidade1, cidade2));

		Cinema cinema2 = new Cinema(null, "Cinetudo", cidade2);
		cidade2.getCinemas().addAll(Arrays.asList(cinema2));

		Sala sala1 = new Sala(null, 01, 50, cinema2);
		cinema2.getSalas().addAll(Arrays.asList(sala1));

		Sessao sessao1 = new Sessao(null, new SimpleDateFormat("dd/MM/yyyy").parse("15/02/2021"),
				new SimpleDateFormat("HH:mm").parse("22:00"), 20, 10, filme1, sala1);
		sala1.getSessoes().addAll(Arrays.asList(sessao1));
		sessao1.setTrocaPorCupons(true);
		sessao1.setValorEmCupons(10);


		generoRepository.saveAll(Arrays.asList(genero1));
		filmeRepository.saveAll(Arrays.asList(filme1));

		paisRepository.saveAll(Arrays.asList(pais1));
		estadoRepository.saveAll(Arrays.asList(estado1));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2));
		cinemaRepository.saveAll(Arrays.asList(cinema2));
		salaRepository.saveAll(Arrays.asList(sala1));
		sessaoRepository.saveAll(Arrays.asList(sessao1));

	

		Cliente cliente1 = new Cliente(null, "Gabriel Freitas", "gabriel@gmail.com", cidade1,pe.encode("manete12"));
		
		Cliente cliente2 = new Cliente(null, "José", "josé@gmail.com", cidade1,pe.encode("manete12"));
		cliente2.addPerfil(Perfil.ADMIN);

		Compra compra1 = new Compra(null, new Date(), cliente1, TipoPagamento.PONTOS);
		cliente1.getCompras().addAll(Arrays.asList(compra1));
		Ingresso ingresso1 = new Ingresso(null, "1", TipoIngresso.MEIA, sessao1, compra1);

		sessao1.getIngressos().addAll(Arrays.asList(ingresso1));
		compra1.getIngressos().addAll(Arrays.asList(ingresso1));

		atorRepository.saveAll(Arrays.asList(ator1));
		atuaRepository.saveAll(Arrays.asList(atua1));

		cliente1 = clienteRepository.save(cliente1);
		clienteRepository.save(cliente2);
		
		compra1.setCliente(cliente1);
		compraRepository.saveAll(Arrays.asList(compra1));

		ingressoRepository.saveAll(Arrays.asList(ingresso1));

	}
}