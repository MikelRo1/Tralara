package server.data.utils;

import server.data.data.Usuario; 
import server.data.dto.UsuarioDTO;

public class UsuarioAssembler {

	private static UsuarioAssembler instance;

	private UsuarioAssembler() { }

	//assembler-an instantzia itea ez dakit beharrezkoa dan//
	
	public static UsuarioAssembler getInstance() {
		if (instance == null) {
			instance = new UsuarioAssembler();
		}

		return instance;
	}

	public UsuarioDTO entityToDTO(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setNombre(usuario.getNombreUsuario());
		
		//kontraseña ez dakit pasa behar zaion//
		
		return dto;
	}
}