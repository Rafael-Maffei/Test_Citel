package br.com.citelsoftware.repositories;

import org.springframework.stereotype.Repository;

import br.com.citelsoftware.dto.DoadoresCalcImcIdadeDto;
import br.com.citelsoftware.dto.DoadoresCalcImcSexoDto;
import br.com.citelsoftware.dto.DoadoresPorIdadeDto;
import br.com.citelsoftware.dto.QtdDoadoresPorEstadoDto;
import br.com.citelsoftware.dto.ReceptoresPorTipoDto;
import br.com.citelsoftware.entities.Doador;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, Long> {

    @Query(value = "SELECT estado, count(estado) as count FROM tbl_doador GROUP BY estado", nativeQuery = true)
    public List<QtdDoadoresPorEstadoDto> countByEstado();

    @Query(value = "SELECT peso, altura, data_nasc FROM tbl_doador", nativeQuery = true)
    public List<DoadoresCalcImcIdadeDto> getAlturaPesoIdade();

    @Query(value = "SELECT peso, altura, sexo FROM tbl_doador", nativeQuery = true)
    public List<DoadoresCalcImcSexoDto> getAlturaPesoSexo();

    @Query(value = "SELECT data_nasc, tipo_sanguineo FROM tbl_doador", nativeQuery = true)
    public List<DoadoresPorIdadeDto> getTipoSanguineoPorIdade();

    @Query(value = "SELECT data_nasc, peso, tipo_sanguineo FROM tbl_doador", nativeQuery = true)
    public List<ReceptoresPorTipoDto> getTipoSanguineo();
}
