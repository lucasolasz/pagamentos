package com.ltech.pagamentos.config;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ltech.pagamentos.model.Banco;
import com.ltech.pagamentos.model.Condomino;
import com.ltech.pagamentos.model.SituacaoCondomino;
import com.ltech.pagamentos.model.Unidade;
import com.ltech.pagamentos.repository.BancoRepository;
import com.ltech.pagamentos.repository.CondominoRepository;
import com.ltech.pagamentos.repository.SituacaoCondominoRepository;
import com.ltech.pagamentos.repository.UnidadeRepository;
import com.ltech.pagamentos.util.TextoUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@Component
@Profile("dev")
public class DataInitializerInicial implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    private final UnidadeRepository unidadeRepository;
    private final CondominoRepository condominoRepository;
    private final BancoRepository bancoRepository;
    private final SituacaoCondominoRepository situacaoCondominoRepository;

    public DataInitializerInicial(JdbcTemplate jdbcTemplate, UnidadeRepository unidadeRepository,
            CondominoRepository condominoRepository, BancoRepository bancoRepository,
            SituacaoCondominoRepository situacaoCondominoRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.unidadeRepository = unidadeRepository;
        this.condominoRepository = condominoRepository;
        this.bancoRepository = bancoRepository;
        this.situacaoCondominoRepository = situacaoCondominoRepository;
    }

    @Override
    public void run(String... args) {

        jdbcTemplate.execute(carregarBancos());
        jdbcTemplate.execute(carregarSituacaoCondomino());
        jdbcTemplate.execute(carregarStudents());
        jdbcTemplate.execute(carregarUnidade());
        jdbcTemplate.execute(carregarCondominos());
        jdbcTemplate.execute(carregarRoles());
        jdbcTemplate.execute(carregarUsuarios());
        jdbcTemplate.execute(carregarRolesUsuario());

        // processarArquivo();

        System.out.println("Scripts executados");

    }

    public String carregarBancos() {

        try {
            Path path = Paths.get(new ClassPathResource("scripts/bancos.sql").getURI());
            String sql = Files.readString(path);
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String carregarRoles() {

        try {
            Path path = Paths.get(new ClassPathResource("scripts/roles.sql").getURI());
            String sql = Files.readString(path);
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String carregarSituacaoCondomino() {

        try {
            Path path = Paths.get(new ClassPathResource("scripts/situacao_condomino.sql").getURI());
            String sql = Files.readString(path);
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String carregarUnidade() {

        try {
            Path path = Paths.get(new ClassPathResource("scripts/unidade.sql").getURI());
            String sql = Files.readString(path);
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String carregarStudents() {

        try {
            Path path = Paths.get(new ClassPathResource("scripts/students.sql").getURI());
            String sql = Files.readString(path);
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String carregarUsuarios() {

        try {
            Path path = Paths.get(new ClassPathResource("scripts/usuario.sql").getURI());
            String sql = Files.readString(path);
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String carregarRolesUsuario() {

        try {
            Path path = Paths.get(new ClassPathResource("scripts/usuario_roles.sql").getURI());
            String sql = Files.readString(path);
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String carregarCondominos() {

        try {
            Path path = Paths.get(new ClassPathResource("scripts/condominos.sql").getURI());
            String sql = Files.readString(path);
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public void processarArquivo() {
        String csvFilePath = Paths.get("src/main/resources/tabcondomino3.csv").toString();

        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            // Pula primeira linha
            csvReader.readNext();
            // CSVReader csvReader = new CSVReader(filereader);
            List<String[]> allData = csvReader.readAll();

            for (String[] strings : allData) {

                Condomino obj = new Condomino();
                obj.setUnidade(TextoUtil.eVazio(strings[1]) ? null : recuperarUnidadePorId(Long.parseLong(strings[1])));
                obj.setNomeCondomino(strings[2]);
                obj.setOutrosResidentes(strings[3]);
                obj.setSituacaoCondomino(
                        TextoUtil.eVazio(strings[4]) ? null : recuperarSituacaoPorId(Long.parseLong(strings[4])));
                obj.setContratoDeGaveta("1".equals(strings[5]));
                obj.setNumContrato(strings[6]);
                obj.setBanco(TextoUtil.eVazio(strings[7]) ? null : recuperarBancoPorId(Long.parseLong(strings[7])));
                obj.setDataNascimento(TextoUtil.eVazio(strings[8]) ? null : LocalDate.parse(strings[8]));
                obj.setNumIdentidade(strings[9]);
                obj.setCpf(strings[10]);
                obj.setTelefone(strings[11]);
                obj.setCelular(strings[12]);
                obj.setProfissao(strings[13]);
                obj.setEnderecoTrabalho(strings[14]);
                obj.setNomeProprietario(strings[15]);
                obj.setEnderecoProprietario(strings[16]);

                // processarCampo(obj);
                condominoRepository.save(obj);

            }

            System.out.println("Processamento do CSV concluído!");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        } catch (CsvException e) {
            System.err.println("Erro ao processar o CSV: " + e.getMessage());
        }
    }

    public Unidade recuperarUnidadePorId(Long id) {
        return this.unidadeRepository.findById(id).orElse(null);
    }

    public Banco recuperarBancoPorId(Long id) {
        return this.bancoRepository.findById(id).orElse(null);
    }

    public SituacaoCondomino recuperarSituacaoPorId(Long id) {
        return this.situacaoCondominoRepository.findById(id).orElse(null);
    }

}
