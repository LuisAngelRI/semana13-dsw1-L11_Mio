package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final InstrumentoRepository repositoryI;
	private final MusicoRepository repositoryM;
	private final BandaRepository repositoryB;
	private final IntegranteRepository repositoryN;
	

	@Autowired
	public DatabaseLoader(
		InstrumentoRepository repositoryI,
		 MusicoRepository repositoryM,
		 BandaRepository repositoryB,
		 IntegranteRepository repositoryN) {
		this.repositoryI = repositoryI;
		this.repositoryM = repositoryM;
		this.repositoryB = repositoryB;
		this.repositoryN = repositoryN;
	}

	@Override
	public void run(String... strings) throws Exception {
		
		Instrumento voz = new Instrumento("Voz", "viento", "voz");
		this.repositoryI.save(voz);
		this.repositoryI.save(new Instrumento("Guitarra", "Cuerda", "de madera, con caja de resonancia, 6 cuerdas templadas"));
		this.repositoryI.save(new Instrumento("Ukelele", "Cuerda", "de madera, con caja de resonancia pequeña, 4 cuerdas templadas"));
		this.repositoryI.save(new Instrumento("Melódica", "Viento", "Teclado pequeño de 2 octavas, sonorisado por soplido"));

		Musico axl = new Musico("Axl Rose");
		this.repositoryM.save(axl);

		Banda guns = new Banda("Guns N' Roses");
		this.repositoryB.save(guns);


		this.repositoryN.save(new Integrante(guns, axl, voz));
	}

	
}