package com.example.demohexagonalarchitecture.resource;


import com.example.demohexagonalarchitecture.domain.Locacao;
import com.example.demohexagonalarchitecture.domain.Veiculo;
import com.example.demohexagonalarchitecture.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoResource {

    private final VeiculoService veiculoService;

    public VeiculoResource(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Veiculo> findAll() {
        return this.veiculoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Veiculo findById(@PathVariable("id") Long id) {
        return this.veiculoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo create(@Valid @RequestBody Veiculo veiculo) {
        return this.veiculoService.save(veiculo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Veiculo update(@PathVariable("id") Long id, @Valid @RequestBody Veiculo veiculo) {
        veiculo.setId(id);
        return this.veiculoService.save(veiculo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        this.veiculoService.deleteById(id);
    }

    @GetMapping("/categoria/{categoriaId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Veiculo> findByCategoriaId(@PathVariable("categoriaId") Long categoriaId) {
        return this.veiculoService.findByCategoriaId(categoriaId);
    }

    @GetMapping("/{id}/locacoes")
    @ResponseStatus(HttpStatus.OK)
    public List<Locacao> findVehicleLocations(@PathVariable("id") Long id) {
        return this.veiculoService.findVehicleLocations(id);
    }
}
