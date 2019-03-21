

package br.edu.ifmt.java.main.obradearte;

import java.util.Objects;

/** funcion...
 * @author Israel Gomes
 * @version 1.0
 * @since 1.0
 */
public class TipoObraDeArte {
    
    private Long id;
    private String descricao;

    public TipoObraDeArte(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoObraDeArte other = (TipoObraDeArte) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
