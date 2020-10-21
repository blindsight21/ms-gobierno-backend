/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.gobierno.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.gobierno.bean.FindByParamBean;
import pe.gob.mimp.gobierno.bean.GobiernoBean;

/**
 *
 * @author Omar
 */
public interface GobiernoService {

    void crearGobierno(GobiernoBean gobiernoBean) throws Exception;

    void editarGobierno(GobiernoBean gobiernoBean) throws Exception;

//    void anularGobierno(GobiernoBean gobiernoBean) throws Exception;
    String obtenerGobiernoPorId(BigDecimal nidGobierno) throws Exception;

    List<GobiernoBean> loadGobiernoList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

    GobiernoBean find(BigDecimal id);

}
