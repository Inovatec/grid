/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.tests.services;

import br.com.inovatec.grid.services.DisciplinaService;
import br.com.inovatec.grid.services.DisciplinaTurmaService;
import br.com.inovatec.grid.services.impl.DisciplinaServiceImpl;
import br.com.inovatec.grid.services.impl.DisciplinaTurmaServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author zrobe
 */
public class DisciplinaTurmaServiceTest {
    
    private DisciplinaService disciplinaService;
    private DisciplinaTurmaService disciplinaTurmaService;
    
    public DisciplinaTurmaServiceTest() {
        this.disciplinaService = new DisciplinaServiceImpl();
        this.disciplinaTurmaService = new DisciplinaTurmaServiceImpl();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void saveDisciplinaTurma() {
        
    }
}
