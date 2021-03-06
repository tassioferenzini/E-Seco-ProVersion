/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.pgcc.plscience.bean.collaborationServices;

import br.ufjf.pgcc.plscience.dao.RolerDAO;
import br.ufjf.pgcc.plscience.model.Roler;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author Guilherme Martins
 */
@ManagedBean()
@ViewScoped
public class NewRoler implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Roler roler;

    public NewRoler() {
        this.roler = new Roler();
    }
    
    public void save() {    
        try { 
            getRoler().setId(null);
            new RolerDAO().save(getRoler()); 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful: ", "Role saved with success!"));   
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));   
        }
    }

    /**
     * @return the roler
     */
    public Roler getRoler() {
        return roler;
    }

    /**
     * @param roler the roler to set
     */
    public void setRoler(Roler roler) {
        this.roler = roler;
    }
        
}
