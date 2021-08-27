package br.com.cpd3r.calc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

	private static Memoria instancia = new Memoria();
	
	private String textoAtual = "";
	
	private final List<MemoriaObservador> observadores = 
			new ArrayList<>();
	
	private Memoria() {
		
	}

	public static Memoria getInstancia() {
		return instancia;
	}
	
	public void adicionarObservador(MemoriaObservador observador) {
		observadores.add(observador);
	}

	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual;
	}

	public void processarComando(String valor) {
		
		if( "AC".equals(valor)) {
			textoAtual = "";
		} else {
			textoAtual += valor;
		}
		
		observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
	}
	
}
