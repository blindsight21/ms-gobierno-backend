/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.gobierno.service.impl;

import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.model.Gobierno;
import pe.gob.mimp.siscap.repository.gobierno.GobiernoRepository;
import pe.gob.mimp.gobierno.bean.FindByParamBean;
import pe.gob.mimp.gobierno.bean.GobiernoBean;
import pe.gob.mimp.gobierno.converter.GobiernoCast;
import pe.gob.mimp.gobierno.converter.TipoGobiernoCast;
import pe.gob.mimp.gobierno.util.Util;
import pe.gob.mimp.gobierno.service.GobiernoService;
import pe.gob.mimp.siscap.model.TipoGobierno;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class GobiernoServiceImpl implements GobiernoService {

    @Autowired
    private GobiernoRepository gobiernoRepository;

    @Override
    public void crearGobierno(GobiernoBean gobiernoBean) throws Exception {

        Gobierno gobierno = new Gobierno();
        gobierno.setTxtGobierno(gobiernoBean.getTxtGobierno());
        gobierno.setNidUsuario(gobiernoBean.getNidUsuario());
        gobierno.setTxtPc(gobiernoBean.getTxtPc());
        gobierno.setTxtIp(gobiernoBean.getTxtIp());
        gobierno.setFecEdicion(gobiernoBean.getFecEdicion());
        gobierno.setFlgActivo(gobiernoBean.getFlgActivo());
        gobierno.setNidDistrito(gobiernoBean.getNidDistrito());

        gobierno.setNidTipoGobierno(TipoGobiernoCast.castTipoGobiernoBeanToTipoGobierno(gobiernoBean.getTipoGobiernoBean()));

        gobiernoRepository.save(gobierno);

    }

    @Override
    public void editarGobierno(GobiernoBean gobiernoBean) {

        if (gobiernoBean.getNidGobierno() == null) {
            return;
        }

        Gobierno gobierno = new Gobierno();

        gobierno.setNidGobierno(gobiernoBean.getNidGobierno());
        gobierno.setTxtGobierno(gobiernoBean.getTxtGobierno());
        gobierno.setNidUsuario(gobiernoBean.getNidUsuario());
        gobierno.setTxtPc(gobiernoBean.getTxtPc());
        gobierno.setTxtIp(gobiernoBean.getTxtIp());
        gobierno.setFecEdicion(gobiernoBean.getFecEdicion());
        gobierno.setFlgActivo(gobiernoBean.getFlgActivo());
        gobierno.setNidDistrito(gobiernoBean.getNidDistrito());

        gobierno.setNidTipoGobierno(TipoGobiernoCast.castTipoGobiernoBeanToTipoGobierno(gobiernoBean.getTipoGobiernoBean()));

        gobiernoRepository.save(gobierno);

    }

    @Override
    public String obtenerGobiernoPorId(BigDecimal nidGobierno) throws Exception {

        Optional<Gobierno> gobierno = gobiernoRepository.findById(nidGobierno);

        if (gobierno.isPresent()) {
            return gobierno.get().getTxtGobierno();
        }

        return "";
    }

    @Override
    public List<GobiernoBean> loadGobiernoList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        
        findByParamBean.getParameters().forEach((k, v) -> {
            if ("nidTipoGobierno".equals(k)) {
                String jsonString = new Gson().toJson(v);
                TipoGobierno tipoGobierno = new Gson().fromJson(jsonString, TipoGobierno.class);
                findByParamBean.getParameters().put(k, tipoGobierno);
            }
        });

        List<Gobierno> gobiernoList = gobiernoRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(gobiernoList)) {

            return gobiernoList.stream().map(gobierno -> {
                GobiernoBean gobiernoBean = new GobiernoBean();
                gobiernoBean.setNidGobierno(gobierno.getNidGobierno());
                gobiernoBean.setTxtGobierno(gobierno.getTxtGobierno());
                gobiernoBean.setNidUsuario(gobierno.getNidUsuario());
                gobiernoBean.setTxtPc(gobierno.getTxtPc());
                gobiernoBean.setTxtIp(gobierno.getTxtIp());
                gobiernoBean.setFecEdicion(gobierno.getFecEdicion());
                gobiernoBean.setFlgActivo(gobierno.getFlgActivo());
                gobiernoBean.setNidDistrito(gobierno.getNidDistrito());
                gobiernoBean.setTipoGobiernoBean(TipoGobiernoCast.castTipoGobiernoToTipoGobiernoBean(gobierno.getNidTipoGobierno()));
                return gobiernoBean;
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = gobiernoRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }

    @Override
    public GobiernoBean find(BigDecimal id) {

        Optional<Gobierno> gobierno = gobiernoRepository.findById(id);

        if (!gobierno.isPresent()) {
            return null;
        }

        return GobiernoCast.castGobiernoToGobiernoBean(gobierno.get());

    }

}
