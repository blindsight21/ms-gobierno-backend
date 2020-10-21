/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.gobierno.converter;

import pe.gob.mimp.gobierno.bean.TipoGobiernoBean;
import pe.gob.mimp.siscap.model.TipoGobierno;

/**
 *
 * @author Omar
 */
public class TipoGobiernoCast {

    public static TipoGobiernoBean castTipoGobiernoToTipoGobiernoBean(TipoGobierno tipoGobierno) {

        if (tipoGobierno == null) {
            return null;
        }

        TipoGobiernoBean tipoGobiernoBean = new TipoGobiernoBean();

        tipoGobiernoBean.setNidTipoGobierno(tipoGobierno.getNidTipoGobierno());
        tipoGobiernoBean.setTxtTipoGobierno(tipoGobierno.getTxtTipoGobierno());
        tipoGobiernoBean.setFlgActivo(tipoGobierno.getFlgActivo());
        tipoGobiernoBean.setNidUsuario(tipoGobierno.getNidUsuario());
        tipoGobiernoBean.setTxtPc(tipoGobierno.getTxtPc());
        tipoGobiernoBean.setTxtIp(tipoGobierno.getTxtIp());
        tipoGobiernoBean.setFecEdicion(tipoGobierno.getFecEdicion());

        return tipoGobiernoBean;
    }
    
    public static TipoGobierno castTipoGobiernoBeanToTipoGobierno(TipoGobiernoBean tipoGobiernoBean) {

        if (tipoGobiernoBean == null) {
            return null;
        }

        TipoGobierno tipoGobierno = new TipoGobierno();

        tipoGobierno.setNidTipoGobierno(tipoGobiernoBean.getNidTipoGobierno());
        tipoGobierno.setTxtTipoGobierno(tipoGobiernoBean.getTxtTipoGobierno());
        tipoGobierno.setFlgActivo(tipoGobiernoBean.getFlgActivo());
        tipoGobierno.setNidUsuario(tipoGobiernoBean.getNidUsuario());
        tipoGobierno.setTxtPc(tipoGobiernoBean.getTxtPc());
        tipoGobierno.setTxtIp(tipoGobiernoBean.getTxtIp());
        tipoGobierno.setFecEdicion(tipoGobiernoBean.getFecEdicion());

        return tipoGobierno;
    }
}
