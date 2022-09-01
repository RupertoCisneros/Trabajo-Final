/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemMenu;
import gob.mdmq.remetfu.dto.DtoHijos;
import gob.mdmq.remetfu.dto.DtoMenuPerfil;
import gob.mdmq.remetfu.repository.MenuPerfilRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author omaldonado
 */
@Service
public class ServicioMenuPerfil {

    @Autowired
    private MenuPerfilRepository menuPerfilRepository;

    public List<DtoMenuPerfil> obtenerMenu(String perfil) {
        var menu = menuPerfilRepository.obtenerMenuPorRoles(perfil);

        List<DtoMenuPerfil> result = Arrays.asList(new DtoMenuPerfil[menu.size()]);

        List<DtoMenuPerfil> menusPerfil = new ArrayList<>();
        for (int i = 0; i < menu.size(); i++) {
            DtoMenuPerfil mp = new DtoMenuPerfil();

            mp.setNombre(menu.get(i).getNombre());
            List<RemMenu> ite = menu.get(i).getHijos();

            List<DtoHijos> menusHijos = new ArrayList<>();
            for (var menuHijos : ite) {
                DtoHijos menuHijo = new DtoHijos();
                menuHijo.setNombre(menuHijos.getNombre());
                menuHijo.setDescripcion(menuHijos.getDescripcion());
                menuHijo.setIcono(menuHijos.getIcono());
                menuHijo.setRuta(menuHijos.getRuta());

                menusHijos.add(menuHijo);
                mp.setHijos(menusHijos);

                result.set(i, mp);
            }

            menusPerfil.add(mp);
        }

        List<DtoMenuPerfil> sourceList = result;
        return sourceList;
        
    }

}
