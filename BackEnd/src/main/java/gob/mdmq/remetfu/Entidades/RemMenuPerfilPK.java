/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author omaldonado
 */
@Embeddable
public class RemMenuPerfilPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PERFIL_ID", nullable = false)
    private long perfilId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MENU_ID", nullable = false)
    private int menuId;

    public RemMenuPerfilPK() {
    }

    public RemMenuPerfilPK(long perfilId, int menuId) {
        this.perfilId = perfilId;
        this.menuId = menuId;
    }
    
    

    public long getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(long perfilId) {
        this.perfilId = perfilId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) perfilId;
        hash += (int) menuId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemMenuPerfilPK)) {
            return false;
        }
        RemMenuPerfilPK other = (RemMenuPerfilPK) object;
        if (this.perfilId != other.perfilId) {
            return false;
        }
        if (this.menuId != other.menuId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RemMenuPerfilPK{" + "perfilId=" + perfilId + ", menuId=" + menuId + '}';
    }

    
    
}
