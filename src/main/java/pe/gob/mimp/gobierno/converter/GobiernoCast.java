/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.gobierno.converter;

import pe.gob.mimp.gobierno.bean.GobiernoBean;
import pe.gob.mimp.siscap.model.Gobierno;

/**
 *
 * @author Omar
 */
public class GobiernoCast {

    public static GobiernoBean castGobiernoToGobiernoBean(Gobierno gobierno) {

        if (gobierno == null) {
            return null;
        }

        GobiernoBean gobiernoBean = new GobiernoBean();

        gobiernoBean.setNidGobierno(gobierno.getNidGobierno());
        gobiernoBean.setTxtGobierno(gobierno.getTxtGobierno());
        gobiernoBean.setFlgActivo(gobierno.getFlgActivo());
        gobiernoBean.setNidUsuario(gobierno.getNidUsuario());
        gobiernoBean.setTxtPc(gobierno.getTxtPc());
        gobiernoBean.setTxtIp(gobierno.getTxtIp());
        gobiernoBean.setFecEdicion(gobierno.getFecEdicion());
        gobiernoBean.setNidDistrito(gobierno.getNidDistrito());
        gobiernoBean.setTipoGobiernoBean(TipoGobiernoCast.castTipoGobiernoToTipoGobiernoBean(gobierno.getNidTipoGobierno()));

        return gobiernoBean;
    }

    public static Gobierno castGobiernoBeanToGobierno(GobiernoBean gobiernoBean) {

        if (gobiernoBean == null) {
            return null;
        }

        Gobierno gobierno = new Gobierno();

        gobierno.setNidGobierno(gobiernoBean.getNidGobierno());
        gobierno.setTxtGobierno(gobiernoBean.getTxtGobierno());
        gobierno.setFlgActivo(gobiernoBean.getFlgActivo());
        gobierno.setNidUsuario(gobiernoBean.getNidUsuario());
        gobierno.setTxtPc(gobiernoBean.getTxtPc());
        gobierno.setTxtIp(gobiernoBean.getTxtIp());
        gobierno.setFecEdicion(gobiernoBean.getFecEdicion());
        gobierno.setNidDistrito(gobiernoBean.getNidDistrito());
        gobierno.setNidTipoGobierno(TipoGobiernoCast.castTipoGobiernoBeanToTipoGobierno(gobiernoBean.getTipoGobiernoBean()));

        return gobierno;
    }
}
