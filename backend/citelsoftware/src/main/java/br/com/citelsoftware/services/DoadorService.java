package br.com.citelsoftware.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.citelsoftware.dto.DoadoresCalcImcIdadeDto;
import br.com.citelsoftware.dto.DoadoresPorIdadeDto;
import br.com.citelsoftware.dto.ReceptoresPorTipoDto;
import br.com.citelsoftware.entities.SexoEnum;
import br.com.citelsoftware.dto.DoadoresCalcImcSexoDto;
import br.com.citelsoftware.repositories.DoadorRepository;

@Service
public class DoadorService {

    @Autowired
    private DoadorRepository repository;

    public Double imcMedioPorIdade(int idadeInicial, int idadeFinal) {
        List<DoadoresCalcImcIdadeDto> values = repository.getAlturaPesoIdade();
        values.stream().map(doador -> {
            Double doadorAltura = doador.getAltura();
            int doadorPeso = doador.getPeso();
            Double doadorImc = calcImc(doadorAltura, doadorPeso);
            return doadorImc;
        }).collect(Collectors.toList());
        values.stream().map(doador -> {
            String dataNasc = doador.getData_nasc();
            LocalDate dataNascConv = convertDate(dataNasc);
            int idade = calcAge(dataNascConv);
            return idade;
        }).collect(Collectors.toList());
        return 0.0;
    }

    public int idadeMediaPorTipo(String tipo) {
        List<DoadoresPorIdadeDto> values = repository.getTipoSanguineoPorIdade();
        values.stream().map(doador -> {
            String dataNasc = doador.getData_nasc();
            LocalDate dataNascConv = convertDate(dataNasc);
            int idade = calcAge(dataNascConv);
            return idade;
        }).collect(Collectors.toList());
        return 0;
    }

    private LocalDate convertDate(String data) {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ofPattern("[dd/MM/yyyy]"));
        DateTimeFormatter dateTimeFormatter = dateTimeFormatterBuilder.toFormatter();
        LocalDate dob = LocalDate.parse(data, dateTimeFormatter);
        return dob;
    }

    private int calcAge(LocalDate dob) {
        LocalDate curDate = LocalDate.now();
        if ((dob != null) && (curDate != null)) {
            return Period.between(dob, curDate).getYears();
        } else {
            return 0;
        }
    }

    public Double obesosPorSexo(SexoEnum sexo) {
        List<DoadoresCalcImcSexoDto> values = repository.getAlturaPesoSexo();
        values.stream().map(doador -> {
            Double doadorAltura = doador.getAltura();
            int doadorPeso = doador.getPeso();
            Double doadorImc = calcImc(doadorAltura, doadorPeso);
            return doadorImc;
        }).collect(Collectors.toList());
        return 0.0;
    }

    private Double calcImc(Double height, int weight) {
        Double imc = weight / (height * height);
        return imc;
    }

    public int doadoresPorReceptor(String tipo) {
        List<ReceptoresPorTipoDto> values = repository.getTipoSanguineo();
        values.stream().map(doador -> {
            String tipoDoador = doador.getTipo_sanguineo();
            int pesoDoador = doador.getPeso();
            String dataNasc = doador.getData_nasc();
            LocalDate dataNascConv = convertDate(dataNasc);
            int idade = calcAge(dataNascConv);
            List<String> receptores = mapearReceptores(tipo);
            return doador;
        }).collect(Collectors.toList());
        return 0;
    }

    private List<String> mapearReceptores(String tipo) {
        if (tipo.equals("A+")) {
            List<String> receptores = Arrays.asList("A+", "A-", "0+", "0-");
            return receptores;
        }
        if (tipo.equals("A-")) {
            List<String> receptores = Arrays.asList("A-", "0-");
            return receptores;
        }
        if (tipo.equals("B+")) {
            List<String> receptores = Arrays.asList("B+", "B-", "0+", "0-");
            return receptores;
        }
        if (tipo.equals("B-")) {
            List<String> receptores = Arrays.asList("B-", "0-");
            return receptores;
        }
        if (tipo.equals("AB+")) {
            List<String> receptores = Arrays.asList("A+", "B+", "O+", "AB+", "A-", "B-", "0-", "AB-");
            return receptores;
        }
        if (tipo.equals("AB-")) {
            List<String> receptores = Arrays.asList("A-", "B-", "0-", "AB-");
            return receptores;
        }
        if (tipo.equals("O+")) {
            List<String> receptores = Arrays.asList("0+", "0-");
            return receptores;
        }
        if (tipo.equals("0-")) {
            List<String> receptores = Arrays.asList("0-");
            return receptores;
        }
        return null;
    }
}