package br.com.citelsoftware.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.citelsoftware.dto.QtdDoadoresPorEstadoDto;
import br.com.citelsoftware.entities.Doador;
import br.com.citelsoftware.entities.SexoEnum;
import br.com.citelsoftware.repositories.DoadorRepository;
import br.com.citelsoftware.services.DoadorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class DoadorController {

    @Autowired
    private DoadorRepository doadorRepository;

    @Autowired
    private DoadorService doadorService;

    @GetMapping("/doadores")
    public List<Doador> getAllDoadores() {
        return doadorRepository.findAll();
    }

    @PostMapping("/criar-lista")
    public List<Doador> createDoadores(@RequestBody List<Doador> novoDoador) {
        return doadorRepository.saveAll(novoDoador);
    }

    @PostMapping("/criar")
    public Doador createDoador(@RequestBody Doador novoDoador) {
        return doadorRepository.save(novoDoador);
    }

    @PutMapping("/doador/{id}")
    public Doador updateDoador(@PathVariable Long id, @RequestBody Doador doador) {
        return doador;
    }

    @DeleteMapping("/doador/{id}")
    public void deletaDoador(@PathVariable Long id) {
        doadorRepository.deleteById(id);
    }

    @GetMapping("/contagem")
    public List<QtdDoadoresPorEstadoDto> countPerState() {
        return doadorRepository.countByEstado();
    }

    @GetMapping("/imc-idade")
    public Double getImcIdade(@RequestBody int idadeInicial, int idadeFinal) {
        return doadorService.imcMedioPorIdade(idadeInicial, idadeFinal);
    }

    @GetMapping("/obesos-sexo")
    public Double getImcSexo(SexoEnum sexo) {
        return doadorService.obesosPorSexo(sexo);
    }

    @GetMapping("/tipos-idade")
    public int getTiposIdade(@RequestBody String tipo) {
        return doadorService.idadeMediaPorTipo(tipo);
    }

    @GetMapping("/receptores")
    public int getDoadoresPorTipo(@RequestBody String tipo) {
        return doadorService.doadoresPorReceptor(tipo);
    }
}
