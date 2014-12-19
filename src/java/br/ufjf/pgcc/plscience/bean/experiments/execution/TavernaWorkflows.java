/*
 * The MIT License
 *
 * Copyright 2014 Pós-Graduação em Ciência da Computação UFJF.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.ufjf.pgcc.plscience.bean.experiments.execution;

import br.ufjf.pgcc.plscience.bean.experiments.Workspace;
import br.ufjf.pgcc.plscience.dao.TavernaWorkflowDAO;
import br.ufjf.pgcc.plscience.model.Experiment;
import br.ufjf.pgcc.plscience.model.TavernaWorkflow;
import br.ufjf.pgcc.plscience.util.BeanUtil;
import br.ufjf.taverna.core.TavernaClient;
import br.ufjf.taverna.model.run.TavernaRun;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author vitorfs
 */
@ManagedBean()
@ViewScoped
public class TavernaWorkflows implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private final TavernaClient client;
    private final Workspace workspace;
    private Experiment experiment;
    private List<TavernaWorkflow> workflows;
    private TavernaWorkflow selectedWorkflow;
    private UploadedFile t2flowFile;
    
    public TavernaWorkflows() {
        client = new TavernaClient();
        client.setBaseUri("http://ec2-54-191-44-161.us-west-2.compute.amazonaws.com:8080/TavernaServer-2.5.4/rest");
        client.setAuthorization("taverna", "taverna");   
        
        workspace = (Workspace) BeanUtil.getManagedBean("workspace");
        if (workspace != null) {
            experiment = workspace.getExperiment();
        }
    }
    
    public void uploadT2flow() {
        
    }
    
    public List<TavernaRun> getRuns() {
        try {
            return client.getRuns();
        } catch (Exception e) {
            return new ArrayList<TavernaRun>();
        }
    }

    /**
     * @return the workflows
     */
    public List<TavernaWorkflow> getWorkflows() {
        workflows = new TavernaWorkflowDAO().getExperimentWorkflows(experiment.getId());
        return workflows;
    }

    /**
     * @param workflows the workflows to set
     */
    public void setWorkflows(List<TavernaWorkflow> workflows) {
        this.workflows = workflows;
    }

    /**
     * @return the selectedWorkflow
     */
    public TavernaWorkflow getSelectedWorkflow() {
        return selectedWorkflow;
    }

    /**
     * @param selectedWorkflow the selectedWorkflow to set
     */
    public void setSelectedWorkflow(TavernaWorkflow selectedWorkflow) {
        this.selectedWorkflow = selectedWorkflow;
    }

    /**
     * @return the experiment
     */
    public Experiment getExperiment() {
        return experiment;
    }

    /**
     * @param experiment the experiment to set
     */
    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    /**
     * @return the t2flowFile
     */
    public UploadedFile getT2flowFile() {
        return t2flowFile;
    }

    /**
     * @param t2flowFile the t2flowFile to set
     */
    public void setT2flowFile(UploadedFile t2flowFile) {
        this.t2flowFile = t2flowFile;
    }
    
}
