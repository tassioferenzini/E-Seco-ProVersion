/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.pgcc.plscience.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "cooperation_service")
@XmlRootElement
public class CooperationService implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "activity")
    private boolean activity;
    
    @Basic(optional = false)
    @Column(name = "task")
    private boolean task;
    
    @Basic(optional = false)
    @Column(name = "product")
    private boolean product;
    
    @Basic(optional = false)
    @Column(name = "artifact")
    private boolean artifact;
    
    @Basic(optional = false)
    @Column(name = "sharedSpace")
    private boolean sharedSpace;
    
    @Basic(optional = false)
    @Column(name = "resource")
    private boolean resource;
    
    @Basic(optional = false)
    @Column(name = "share")
    private boolean share;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cooperationServiceId")
    private CollaborationService collaborationService;

    public CooperationService() {
    }

    public CooperationService(Long id) {
        this.id = id;
    }

    public CooperationService(Long id, boolean activity, boolean task, boolean product, boolean artifact, boolean sharedSpace, boolean resource, boolean share) {
        this.id = id;
        this.activity = activity;
        this.task = task;
        this.product = product;
        this.artifact = artifact;
        this.sharedSpace = sharedSpace;
        this.resource = resource;
        this.share = share;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    public boolean getTask() {
        return task;
    }

    public void setTask(boolean task) {
        this.task = task;
    }

    public boolean getProduct() {
        return product;
    }

    public void setProduct(boolean product) {
        this.product = product;
    }

    public boolean getArtifact() {
        return artifact;
    }

    public void setArtifact(boolean artifact) {
        this.artifact = artifact;
    }

    public boolean getSharedSpace() {
        return sharedSpace;
    }

    public void setSharedSpace(boolean sharedSpace) {
        this.sharedSpace = sharedSpace;
    }

    public boolean getResource() {
        return resource;
    }

    public void setResource(boolean resource) {
        this.resource = resource;
    }

    public boolean getShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    @XmlTransient
    public CollaborationService getCollaborationService() {
        return collaborationService;
    }

    public void setCollaborationService(CollaborationService collaborationService) {
        this.collaborationService = collaborationService;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CooperationService)) {
            return false;
        }
        CooperationService other = (CooperationService) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufjf.pgcc.plscience.model.CooperationService[ id=" + id + " ]";
    }
    
}
