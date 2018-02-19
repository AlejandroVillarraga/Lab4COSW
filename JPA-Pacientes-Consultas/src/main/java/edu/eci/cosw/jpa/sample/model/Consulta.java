package edu.eci.cosw.jpa.sample.model;
// Generated Mar 9, 2016 7:01:57 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Consultas generated by hbm2java
 */
@Entity
@Table (name = "CONSULTAS")
public class Consulta  implements java.io.Serializable {


     private Integer idConsultas;     
     private Date fechaYHora;
     private String resumen;

    public Consulta() {
    }

    public Consulta(Date fechaYHora, String resumen) {       
       this.fechaYHora = fechaYHora;
       this.resumen = resumen;
    }

    @GeneratedValue
    @Id
    @Column(name="idCONSULTAS")
    public Integer getIdConsultas() {
        return this.idConsultas;
    }
    
    public void setIdConsultas(Integer idConsultas) {
        this.idConsultas = idConsultas;
    }

    @Column (name = "fecha_y_hora")
    public Date getFechaYHora() {
        return this.fechaYHora;
    }
    
    public void setFechaYHora(Date fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    @Column (name = "resumen")
    public String getResumen() {
        return this.resumen;
    }


    public void setResumen(String resumen) {
        this.resumen = resumen;
    }




}


