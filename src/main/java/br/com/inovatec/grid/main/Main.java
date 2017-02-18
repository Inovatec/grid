/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.main;

import br.com.inovatec.grid.entidades.DiaAula;
import br.com.inovatec.grid.entidades.Disciplina;
import br.com.inovatec.grid.entidades.DisciplinaTurma;
import br.com.inovatec.grid.entidades.Endereco;
import br.com.inovatec.grid.entidades.Escola;
import br.com.inovatec.grid.entidades.HoraAula;
import br.com.inovatec.grid.entidades.Horario;
import br.com.inovatec.grid.entidades.Professor;
import br.com.inovatec.grid.entidades.Sala;
import br.com.inovatec.grid.entidades.Turma;
import br.com.inovatec.grid.entidades.Usuario;
import br.com.inovatec.grid.entidades.enums.TipoSala;
import br.com.inovatec.grid.entidades.enums.Turno;
import br.com.inovatec.grid.services.DisciplinaService;
import br.com.inovatec.grid.services.DisciplinaTurmaService;
import br.com.inovatec.grid.services.EscolaService;
import br.com.inovatec.grid.services.ProfessorService;
import br.com.inovatec.grid.services.SalaService;
import br.com.inovatec.grid.services.TurmaService;
import br.com.inovatec.grid.services.UsuarioService;
import br.com.inovatec.grid.services.exceptions.ServiceException;
import br.com.inovatec.grid.services.impl.DisciplinaServiceImpl;
import br.com.inovatec.grid.services.impl.DisciplinaTurmaServiceImpl;
import br.com.inovatec.grid.services.impl.EscolaServiceImpl;
import br.com.inovatec.grid.services.impl.ProfessorServiceImpl;
import br.com.inovatec.grid.services.impl.SalaServiceImpl;
import br.com.inovatec.grid.services.impl.TurmaServiceImpl;
import br.com.inovatec.grid.services.impl.UsuarioServiceImpl;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zrobe
 */
public class Main {
    
    private static final int TOTAL_DISCIPLINAS = 12;

    public static void main(String[] args) {

        // Executar rotinas
        execute();

    }
    
    public static void execute() {
        
        try {

            // Services da Aplicação
            UsuarioService usuarioService = new UsuarioServiceImpl();
            EscolaService escolaService = new EscolaServiceImpl();
            ProfessorService professorService = new ProfessorServiceImpl();
            DisciplinaService disciplinaService = new DisciplinaServiceImpl();
            SalaService salaService = new SalaServiceImpl();
            TurmaService turmaService = new TurmaServiceImpl();
            DisciplinaTurmaService disciplinaTurmaService = new DisciplinaTurmaServiceImpl();

            // Usuario Administrador do Sistema
            Usuario usuario = new Usuario();
            usuario.setLogin("admin");
            usuario.setSenha("123");
            usuario.setNome("Administrador");

            // Salvar Usuário
            usuarioService.save(usuario);

            // Informações da Escola
            Escola escola = new Escola();
            escola.setNome("Aurélio Buarque");
            escola.setDuracaoAula(45);
            // Dias de aula da Escola
            escola.getDiasAulas().add(new DiaAula(DayOfWeek.MONDAY, 5, Turno.MANHA));
            escola.getDiasAulas().add(new DiaAula(DayOfWeek.TUESDAY, 4, Turno.MANHA));
            escola.getDiasAulas().add(new DiaAula(DayOfWeek.WEDNESDAY, 5, Turno.MANHA));
            escola.getDiasAulas().add(new DiaAula(DayOfWeek.THURSDAY, 4, Turno.MANHA));
            escola.getDiasAulas().add(new DiaAula(DayOfWeek.FRIDAY, 5, Turno.MANHA));
            // Horas de Aula da Escola
            escola.getHorasAulas().add(new HoraAula(LocalTime.of(7, 0), LocalTime.of(8, 0)));
            escola.getHorasAulas().add(new HoraAula(LocalTime.of(8, 0), LocalTime.of(9, 0)));
            escola.getHorasAulas().add(new HoraAula(LocalTime.of(9, 0), LocalTime.of(10, 0)));
            escola.getHorasAulas().add(new HoraAula(LocalTime.of(10, 0), LocalTime.of(11, 0)));
            escola.getHorasAulas().add(new HoraAula(LocalTime.of(11, 0), LocalTime.of(12, 0)));

            // Salvar Escola
            escolaService.save(escola);

            // Disciplinas
            for (int i = 0; i < TOTAL_DISCIPLINAS; i++) {
                Disciplina disciplina = new Disciplina();
                disciplina.setNome("Disciplina " + i);
                disciplina.setDescricao("Descricao da Disciplina " + i);
                disciplinaService.save(disciplina);
            }

            // Salas de Aula
            for (int i = 0; i < 15; i++) {
                Sala sala = new Sala();
                int rnd = new Random().nextInt(TipoSala.values().length);
                sala.setTipoSala(TipoSala.values()[rnd]);
                sala.setNome("Sala " + i);
                sala.setDescricao("Descricao da Sala " + i);

                // Horarios
                LocalTime hour = LocalTime.of(7, 0);
                sala.getHorarios().add(new Horario(
                        DayOfWeek.MONDAY,
                        hour,
                        hour.plusHours(5)
                ));
                sala.getHorarios().add(new Horario(
                        DayOfWeek.TUESDAY,
                        hour,
                        hour.plusHours(5)
                ));
                sala.getHorarios().add(new Horario(
                        DayOfWeek.WEDNESDAY,
                        hour,
                        hour.plusHours(5)
                ));
                sala.getHorarios().add(new Horario(
                        DayOfWeek.THURSDAY,
                        hour,
                        hour.plusHours(5)
                ));
                sala.getHorarios().add(new Horario(
                        DayOfWeek.FRIDAY,
                        hour,
                        hour.plusHours(5)
                ));

                salaService.save(sala);
            }
            
            // Professores da Escola
            for (int i = 0; i < 30; i++) {
                Professor professor = new Professor();
                professor.setNome("Professor " + 0);
                professor.setCpf("000000000" + i);
                professor.setRg("0000" + i);
                professor.setEmail("email" + i + "@email.com");
                professor.getTelefones().add("8899999999" + i);
                professor.getTelefones().add("8898888888" + i);

                Endereco endereco = new Endereco();
                endereco.setLogradouro("Rua " + i);
                endereco.setNumero(Integer.toString(i));
                endereco.setBairro("Bairro " + i);
                endereco.setCidade("Icó");
                endereco.setUf("CE");
                endereco.setPais("Brasil");
                professor.setEndereco(endereco);

                // Horarios do Professor
                for (int j = 0; j < 5; j++) {
                    LocalTime hour = LocalTime.of(new Random().nextInt(5) + 7, new Random().nextInt(60));
                    professor.getHorarios().add(new Horario(
                            DayOfWeek.values()[new Random().nextInt(5) + 1],
                            hour,
                            hour.plusMinutes(90)
                    ));
                }

                // Disciplinas que o professor ministra
                for (int j = 0; j < 2; j++) {
                    int rnd = new Random().nextInt(TOTAL_DISCIPLINAS);
                    Disciplina disciplina = disciplinaService.find(rnd + 1l);
                    // Verificar se a disciplina ja esta presente na lista de disciplinas do professor
                    if (!professor.getDisciplinas().contains(disciplina)) {
                        professor.getDisciplinas().add(disciplina);
                    } else {
                        j--;
                    }
                }
                
                // Salvar professor
                professorService.save(professor);

            }

            // Turmas
            for (int i = 0; i < 10; i++) {
                Turma turma = new Turma();
                turma.setAcronimo(Integer.toString(i));
                turma.setAno(2017);
                turma.setDescricao("Descricao da Turma " + i);

                LocalTime hour = LocalTime.of(7, 0);
                turma.getHorarios().add(new Horario(
                        DayOfWeek.MONDAY,
                        hour,
                        hour.plusHours(5)
                ));
                turma.getHorarios().add(new Horario(
                        DayOfWeek.TUESDAY,
                        hour,
                        hour.plusHours(4)
                ));
                turma.getHorarios().add(new Horario(
                        DayOfWeek.WEDNESDAY,
                        hour,
                        hour.plusHours(5)
                ));
                turma.getHorarios().add(new Horario(
                        DayOfWeek.THURSDAY,
                        hour,
                        hour.plusHours(4)
                ));
                turma.getHorarios().add(new Horario(
                        DayOfWeek.FRIDAY,
                        hour,
                        hour.plusHours(5)
                ));
                turmaService.save(turma);

                // Disciplinas da Turma
                for (int j = 0; j < 12; j++) {
                    DisciplinaTurma disciplinaTurma = new DisciplinaTurma();
                    disciplinaTurma.setDisciplina(disciplinaService.find(j + 1l));
                    disciplinaTurma.setTurma(turma);

                    // Horarios da Disciplina na Turma
                    for (int k = 0; k < 3; k++) {
                        LocalTime hourTemp = LocalTime.of(new Random().nextInt(5) + 7, new Random().nextInt(60));
                        disciplinaTurma.getHorarios().add(new Horario(
                                DayOfWeek.values()[new Random().nextInt(5) + 1],
                                hourTemp,
                                hourTemp.plusMinutes(90)
                        ));
                    }
                    disciplinaTurmaService.save(disciplinaTurma);
                }

            }

            // DisciplinaTurma
        } catch (ServiceException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

}
