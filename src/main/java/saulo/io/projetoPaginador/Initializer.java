package saulo.io.projetoPaginador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import saulo.io.projetoPaginador.entity.Perfil;
import saulo.io.projetoPaginador.enun.StatusPerfil;
import saulo.io.projetoPaginador.repository.PerfilRepository;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private PerfilRepository perfilRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		for (int i = 1; i < 1000; i++) {
			this.savePerfil("ADMIN", StatusPerfil.ATIVO);
		}

		for (int i = 1; i < 1000; i++) {
			this.savePerfil("USUARIO", StatusPerfil.INATIVO);
		}

		PageRequest value = PageRequest.of(10, 10);
		
		Page<Perfil> paginator = this.perfilRepository.findAll(value);

		for (Perfil perfil : paginator) {
			System.out.println(perfil.getNome());
		}
	}

	public void savePerfil(String name, StatusPerfil status) {

		Perfil perfil = new Perfil(name, status);

		this.perfilRepository.save(perfil);
	}

}
