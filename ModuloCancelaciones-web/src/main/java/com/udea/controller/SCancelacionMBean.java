/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.ejb.EstadoSolicitudManagerLocal;
import com.udea.ejb.EstudianteManagerLocal;
import com.udea.ejb.HistoriaAcademicaManagerLocal;
import com.udea.ejb.MateriaManagerLocal;
import com.udea.ejb.MateriaSemestreManagerLocal;
import com.udea.ejb.ProfesorManagerLocal;
import com.udea.ejb.RelacionManagerLocal;
import com.udea.ejb.SemestreManagerLocal;
import com.udea.ejb.SituacionAcademicaManagerLocal;
import com.udea.ejb.SolicitudCancelacionManagerLocal;
import com.udea.ejb.TercioManagerLocal;
import com.udea.ejb.TipoSemestreManagerLocal;
import javax.ejb.EJB;

/**
 *
 * @author YEISON
 */
public class SCancelacionMBean {

    @EJB
    private TercioManagerLocal tercioManager;

    @EJB
    private TipoSemestreManagerLocal tipoSemestreManager;

    @EJB
    private SolicitudCancelacionManagerLocal solicitudCancelacionManager;

    @EJB
    private SituacionAcademicaManagerLocal situacionAcademicaManager;

    @EJB
    private SemestreManagerLocal semestreManager;

    @EJB
    private RelacionManagerLocal relacionManager;

    @EJB
    private ProfesorManagerLocal profesorManager;

    @EJB
    private MateriaSemestreManagerLocal materiaSemestreManager;

    @EJB
    private MateriaManagerLocal materiaManager;

    @EJB
    private HistoriaAcademicaManagerLocal historiaAcademicaManager;

    @EJB
    private EstudianteManagerLocal estudianteManager;

    @EJB
    private EstadoSolicitudManagerLocal estadoSolicitudManager;

    @EJB
    private com.udea.ejb.EstadoSemestreManagerLocal estadoSemestreManager;

    /**
     * Creates a new instance of SCancelacionMBean
     */
    public SCancelacionMBean() {
    }
    
    
}
