package com.ltech.pagamentos.config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ltech.pagamentos.repository.BancoRepository;
import com.ltech.pagamentos.repository.CondominoRepository;
import com.ltech.pagamentos.repository.RoleRepository;
import com.ltech.pagamentos.repository.SituacaoCondominoRepository;
import com.ltech.pagamentos.repository.UnidadeRepository;
import com.ltech.pagamentos.repository.UsuarioRepository;

public class DataInitializerInicial_old {

    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JdbcTemplate jdbcTemplate;

    private final UnidadeRepository unidadeRepository;
    private final CondominoRepository condominoRepository;
    private final BancoRepository bancoRepository;
    private final SituacaoCondominoRepository situacaoCondominoRepository;

    public DataInitializerInicial_old(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder,
            RoleRepository roleRepository, JdbcTemplate jdbcTemplate, UnidadeRepository unidadeRepository,
            CondominoRepository condominoRepository, BancoRepository bancoRepository,
            SituacaoCondominoRepository situacaoCondominoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.roleRepository = roleRepository;
        this.jdbcTemplate = jdbcTemplate;
        this.unidadeRepository = unidadeRepository;
        this.condominoRepository = condominoRepository;
        this.bancoRepository = bancoRepository;
        this.situacaoCondominoRepository = situacaoCondominoRepository;
    }

    // @Override
    // public void run(String... args) {
    // if (this.roleRepository.count() == 0) {

    // Roles roles1 = new Roles();
    // roles1.setName("ROLE_ADMIN");
    // Roles roles2 = new Roles();
    // roles2.setName("ROLE_USER");

    // this.roleRepository.save(roles1);
    // this.roleRepository.save(roles2);

    // System.out.println("Roles criadas!");
    // }

    // if (this.usuarioRepository.count() == 0) {
    // List<Roles> roleAdm = this.roleRepository.findAll();
    // Usuario admin = new Usuario();

    // admin.setUsername("admin");
    // admin.setPassword(passwordEncoder.encode("123"));
    // admin.setFirstName("Administrador");
    // admin.setLastName("adm");
    // admin.setEnabled(true);
    // admin.setRoles(roleAdm);

    // List<Roles> roleUser = this.roleRepository.findByName("ROLE_USER");
    // Usuario user = new Usuario();

    // user.setUsername("user");
    // user.setPassword(passwordEncoder.encode("123"));
    // user.setFirstName("Usuario");
    // user.setLastName("comum");
    // user.setEnabled(true);
    // user.setRoles(roleUser);

    // this.usuarioRepository.save(admin);
    // this.usuarioRepository.save(user);

    // System.out.println("Usuários criados!");
    // }

    // jdbcTemplate.update("INSERT INTO `student` (`address`, `email`, `name`)\r\n"
    // + //
    // "SELECT \r\n" + //
    // " CONCAT(FLOOR(1 + (RAND() * 999)), ' Main St, City ', FLOOR(1 + (RAND() *
    // 100))) AS address,\r\n" + //
    // " CONCAT('student', FLOOR(1 + (RAND() * 9999)), '@example.com') AS
    // email,\r\n" + //
    // " CONCAT('Student ', FLOOR(1 + (RAND() * 50))) AS name\r\n" + //
    // "FROM (SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5
    // UNION \r\n" + //
    // " SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10) AS
    // tmp1,\r\n" + //
    // " (SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5) AS
    // tmp2\r\n" + //
    // "LIMIT 50;");

    // System.out.println("50 Estudantes inseridos");

    // // processarArquivo();

    // }

    // public void processarArquivo() {
    // String csvFilePath =
    // Paths.get("src/main/resources/tabcondomino3.csv").toString();

    // try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
    // // Pula primeira linha
    // csvReader.readNext();
    // // CSVReader csvReader = new CSVReader(filereader);
    // List<String[]> allData = csvReader.readAll();

    // for (String[] strings : allData) {

    // Condomino obj = new Condomino();
    // obj.setUnidade(TextoUtil.eVazio(strings[1]) ? null :
    // recuperarUnidadePorId(Long.parseLong(strings[1])));
    // obj.setNomeCondomino(strings[2]);
    // obj.setOutrosResidentes(strings[3]);
    // obj.setSituacaoCondomino(
    // TextoUtil.eVazio(strings[4]) ? null :
    // recuperarSituacaoPorId(Long.parseLong(strings[4])));
    // obj.setContratoDeGaveta("1".equals(strings[5]));
    // obj.setNumContrato(strings[6]);
    // obj.setBanco(TextoUtil.eVazio(strings[7]) ? null :
    // recuperarBancoPorId(Long.parseLong(strings[7])));
    // obj.setDataNascimento(TextoUtil.eVazio(strings[8]) ? null :
    // LocalDate.parse(strings[8]));
    // obj.setNumIdentidade(strings[9]);
    // obj.setCpf(strings[10]);
    // obj.setTelefone(strings[11]);
    // obj.setCelular(strings[12]);
    // obj.setProfissao(strings[13]);
    // obj.setEnderecoTrabalho(strings[14]);
    // obj.setNomeProprietario(strings[15]);
    // obj.setEnderecoProprietario(strings[16]);

    // // processarCampo(obj);
    // condominoRepository.save(obj);

    // }

    // System.out.println("Processamento do CSV concluído!");
    // } catch (IOException e) {
    // System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
    // } catch (CsvException e) {
    // System.err.println("Erro ao processar o CSV: " + e.getMessage());
    // }
    // }

    // public Unidade recuperarUnidadePorId(Long id) {
    // return this.unidadeRepository.findById(id).orElse(null);
    // }

    // public Banco recuperarBancoPorId(Long id) {
    // return this.bancoRepository.findById(id).orElse(null);
    // }

    // public SituacaoCondomino recuperarSituacaoPorId(Long id) {
    // return this.situacaoCondominoRepository.findById(id).orElse(null);
    // }

}
