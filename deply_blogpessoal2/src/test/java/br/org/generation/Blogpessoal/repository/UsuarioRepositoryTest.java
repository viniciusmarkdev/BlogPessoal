package br.org.generation.Blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

	
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.org.generation.Blogpessoal.model.Usuario;

@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT )   
@TestInstance(TestInstance.Lifecycle.PER_CLASS)                 
public class UsuarioRepositoryTest {

		@Autowired
		private UsuarioRepository usuarioRepository;
		
		@BeforeAll 
		void start() {
			
			usuarioRepository.save(new Usuario(0L,"João da Silva","joao@email.com.br","123456"));
			usuarioRepository.save(new Usuario(0L,"Manuela da Silva","manuela@email.com.br","123456"));	
			usuarioRepository.save(new Usuario(0L,"Adriana da Silva","adriana@email.com.br","123456"));
			usuarioRepository.save(new Usuario(0L,"Paulo Antunes","paulo@email.com.br","123456"));	
		}

			@Test                                                         
			@DisplayName ("Retorna 3 usuários")                         
			public void deveRetornarTresUsuarios() {
				
				List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
				assertEquals(3, listaDeUsuarios.size());
				assertTrue(listaDeUsuarios.get(0).getNome().equals("João da Silva"));
				assertTrue(listaDeUsuarios.get(1).getNome().equals("Manuela da Silva"));
				assertTrue(listaDeUsuarios.get(2).getNome().equals("Adriana da Silva"));
				
			}

}