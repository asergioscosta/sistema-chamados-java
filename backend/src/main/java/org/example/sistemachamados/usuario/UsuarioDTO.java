package org.example.sistemachamados.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sistemachamados.enums.TipoUsuario;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nomeUsuario;
    private String login;
    private String password;
    private boolean admin;
    private TipoUsuario tipoUsuario;

    public static UsuarioDTO create(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNomeUsuario(usuario.getNomeUsuario());
        dto.setLogin(usuario.getLogin());
        dto.setTipoUsuario(usuario.getTipoUsuario());
        return dto;
    }
}