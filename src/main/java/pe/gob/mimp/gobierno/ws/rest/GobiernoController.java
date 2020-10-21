/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.gobierno.ws.rest;

import java.math.BigDecimal;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.gobierno.bean.FindByParamBean;

import pe.gob.mimp.gobierno.bean.ResponseData;
import pe.gob.mimp.gobierno.bean.GobiernoBean;
import pe.gob.mimp.gobierno.service.GobiernoService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/")
public class GobiernoController {

    @Autowired
    private GobiernoService gobiernoService;

    @PostMapping(value = "/crearGobierno", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearGobierno(@RequestBody GobiernoBean gobiernoBean) throws Exception {

        gobiernoService.crearGobierno(gobiernoBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarGobierno", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarGobierno(@RequestBody GobiernoBean gobiernoBean) throws Exception {

        gobiernoService.editarGobierno(gobiernoBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/obtenerGobiernoPorId/{nidGobierno}")
    public ResponseEntity<ResponseData<?>> obtenerGobiernoPorId(@PathVariable("nidGobierno") BigDecimal nidGobierno) throws Exception {

        String txtGobierno = gobiernoService.obtenerGobiernoPorId(nidGobierno);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(txtGobierno);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/loadGobiernoList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadGobiernoList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<GobiernoBean> gobiernoList = gobiernoService.loadGobiernoList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(gobiernoList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = gobiernoService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        GobiernoBean gobiernoBean = gobiernoService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(gobiernoBean);

        return ResponseEntity.ok(response);

    }

}
