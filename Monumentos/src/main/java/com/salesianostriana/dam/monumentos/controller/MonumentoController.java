package com.salesianostriana.dam.monumentos.controller;

import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.service.MonumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/monumentos")
public class MonumentoController {

    @Autowired
    private MonumentoService monumentoService;

    @GetMapping("/")
    public List<Monumento> obtenerTodosLosMonumentos() {

        return monumentoService.mostrarMonumentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monumento> obtenerMonumento(@PathVariable Long id) {
        Monumento monumento = monumentoService.mostrarMonumentoPorId(id);
        if (monumento != null) {
            return new ResponseEntity<>(monumento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Monumento> crearMonumento(@RequestBody Monumento monumento) {
        Monumento nuevoMonumento = monumentoService.guardarMonumento(monumento);
        return new ResponseEntity<>(nuevoMonumento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monumento> editarMonumento(@PathVariable Long id, @RequestBody Monumento monumento) {
        Monumento monumentoEditado = monumentoService.editarMonumento(id, monumento);
        if (monumentoEditado != null) {
            return new ResponseEntity<>(monumentoEditado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMonumento(@PathVariable Long id) {
        monumentoService.eliminarMonumento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
