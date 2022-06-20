package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestaoCursosMain {

    public static void main(String[] args){

        CursoModel cursoModel = new CursoModel();
        AlunoModel alunoModel = new AlunoModel();
        List<Aluno> alunos;
        List<Curso> cursos;

        Telefone tel1 = new Telefone();
        tel1.setDDD("11");
        tel1.setNumero("91234-5678");

        Telefone tel2 = new Telefone();
        tel2.setDDD("11");
        tel2.setNumero("99876-5432");

        Telefone tel3 = new Telefone();
        tel3.setDDD("11");
        tel3.setNumero("91020-3040");

        Endereco end1 = new Endereco();
        end1.setLogradouro("Rua");
        end1.setEndereco("Techcamps");
        end1.setNumero("123");
        end1.setBairro("Ciandt");
        end1.setCidade("Campinas");
        end1.setEstado("São Paulo");
        end1.setCep(12345678);

        Endereco end2 = new Endereco();
        end2.setLogradouro("Rua");
        end2.setEndereco("Banana");
        end2.setNumero("321");
        end2.setBairro("Morango");
        end2.setCidade("Fruta");
        end2.setEstado("São Paulo");
        end2.setCep(87654321);

        // Criando Aluno1 com Tel1 e 2, End1 e Aluno2 com Tel3 e End2
        System.out.println("Criando dois alunos -> Aluno1 com Telefone1|Telefone2|Endereco1 e " +
                "Aluno2 com Telefone3|Endereco2");
        Aluno aluno1 = new Aluno();
        Aluno aluno2 = new Aluno();
        aluno1.setNomeCompleto("Thamires Santos");
        aluno1.setMatricula("ALUNO01");
        aluno1.setNascimento(LocalDate.of(1996,11,19));
        aluno1.setEmail("thamires@email.com");
        aluno1.setTelefones(new ArrayList<Telefone>(List.of(tel1, tel2)));
        aluno1.setEnderecos(new ArrayList<Endereco>(List.of(end1)));

        aluno2.setNomeCompleto("Marcia Leia");
        aluno2.setMatricula("ALUNO02");
        aluno2.setNascimento(LocalDate.of(1994,3,20));
        aluno2.setEmail("marcialeia@email.com");
        aluno2.setTelefones(new ArrayList<Telefone>(List.of(tel3)));
        aluno2.setEnderecos(new ArrayList<Endereco>(List.of(end2)));

        alunoModel.create(aluno1);
        alunoModel.create(aluno2);

        // Buscando Aluno1 e Aluno2
        System.out.println("Buscando Aluno1 e Aluno2");
        Aluno searchAlunoId1 = new Aluno();
        Aluno searchAlunoId2 = new Aluno();
        searchAlunoId1.setId(1L);
        searchAlunoId1 = alunoModel.findById(searchAlunoId1);
        searchAlunoId1.setId(2L);
        searchAlunoId2 = alunoModel.findById(searchAlunoId2);
        System.out.println(searchAlunoId1);
        System.out.println(searchAlunoId2);

        // Deletando Aluno2
        System.out.println("Deletando Aluno2");
        Aluno deleteAlunoId2 = new Aluno();
        deleteAlunoId2.setId(2L);
        alunoModel.delete(deleteAlunoId2);

        // Buscando todos os Alunos
        System.out.println("Buscando Todos os Alunos");
        alunos = alunoModel.findAll();
        System.out.println(alunos);

        // Atualizando Nome do Aluno1 e mudando o Telefone1
        System.out.println("Atualizando Nome do Aluno1 e mudando o Telefone1");
        Aluno updateAlunoId1 = new Aluno();
        updateAlunoId1.setId(1L);
        updateAlunoId1 = alunoModel.findById(updateAlunoId1);
        updateAlunoId1.setNomeCompleto("Thamires Cristina Santos");
        updateAlunoId1.getTelefones().forEach(telefone -> {
            if (telefone.getId() == 1L)
                telefone.setNumero("91234-5679");
        });
        alunoModel.update(updateAlunoId1);

        // Buscando todos os alunos
        System.out.println("Buscando todos os alunos");
        alunos = alunoModel.findAll();
        System.out.println(alunos);

        // Criando Professor
        Professor prof1 = new Professor();
        prof1.setNomeCompleto("Leticia");
        prof1.setMatricula("PROF-01");
        prof1.setEmail("leticia@email.com");
        Professor prof2 = new Professor();
        prof2.setId(1L);

        MaterialCurso material1 = new MaterialCurso();
        material1.setUrl("www.ciandt.com");

        MaterialCurso material2 = new MaterialCurso();
        material2.setUrl("www.techcamps.com");

        // Criando Curso1 e Curso2 com o mesmo Prof1 e Material1|Material2
        System.out.println("Criando Curso1 e Curso2 com mesmo Professor e Material1|Material2");
        Curso curso1 = new Curso();
        curso1.setNome("Programação");
        curso1.setSigla("PRG");
        curso1.setProfessor(prof1);
        curso1.setMaterialCurso(material1);

        Curso curso2 = new Curso();
        curso2.setNome("Analise de Sistemas");
        curso2.setSigla("ANLSIS");
        curso2.setProfessor(prof1);
        curso2.setMaterialCurso(material2);

        cursoModel.create(curso1);
        cursoModel.create(curso2);

        // Buscando Curso1 e Curso2
        System.out.println("Buscando Curso1 e Curso2");
        Curso searchCursoId1 = new Curso();
        Curso searchCursoId2 = new Curso();
        searchCursoId1.setId(1L);
        searchCursoId2.setId(2L);
        searchCursoId1 = cursoModel.findById(searchCursoId1);
        searchCursoId2 = cursoModel.findById(searchCursoId2);

        System.out.println(searchCursoId1);
        System.out.println(searchCursoId2);

        // Deletando Curso1
        System.out.println("Deletando Curso1");
        Curso deleteCursoId1 = new Curso();
        deleteCursoId1.setId(1L);
        cursoModel.delete(deleteCursoId1);

        Professor prof3 = new Professor();
        prof3.setNomeCompleto("Leia Marcia");
        prof3.setMatricula("PROF-02");
        prof3.setEmail("leiamarcia@email.com");

        // Atualizando Nome do Curso2 e mudando prof1 para prof2, mudando url do material
        System.out.println("Atualizando Nome do Curso e mudando Pro1 para Prof2|mudando url do material");
        Curso updateCursoId2 = new Curso();
        updateCursoId2.setId(2L);
        updateCursoId2 = cursoModel.findById(updateCursoId2);
        updateCursoId2.setNome("Programação Atualizado");
        updateCursoId2.setProfessor(prof3);
        updateCursoId2.getMaterialCurso().setUrl("www.ciandt.com/aula");
        cursoModel.update(updateCursoId2);

        // Buscando todos os cursos
        System.out.println("Buscando todos os Cursos");
        cursos = cursoModel.findAll();
        System.out.println(cursos);

        // Atualizando Curso2 e Adicionando Aluno
        System.out.println("Atulizando Curso2 e Adicionando Aluno");
        updateCursoId2 = cursoModel.findById(updateCursoId2);
        searchAlunoId1 = alunoModel.findById(searchAlunoId1);
        updateCursoId2.setAlunos(new ArrayList<Aluno>(List.of(searchAlunoId1)));
        cursoModel.update(updateCursoId2);

        //Buscando todos os cursos
        System.out.println("Buscando todos os cursos");
        cursos = cursoModel.findAll();
        System.out.println(cursos);
    }
}