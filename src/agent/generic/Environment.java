/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agent.generic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author kuri
 */
public abstract class Environment {
    
    public Map<Agent, Double> performanceMeasures;
    private Set<Action> supportedActions;
    
    public Environment(){
        performanceMeasures = new HashMap<>();
        supportedActions = new TreeSet<>();
    }
    
    public void updatePerformanceMeasure(Agent agent, Double newValue){
        performanceMeasures.put(agent, newValue);
    }
    
    public void addToPerformanceMeasure(Agent agent, double valueToAdd){
        Double d = performanceMeasures.get(agent) != null ? performanceMeasures.get(agent) : new Double(0.0);
        
        updatePerformanceMeasure(agent, d += valueToAdd);
    }
    
    public Double getPerformanceMeasure(Agent agent){
        return performanceMeasures.get(agent);
    }
    
    protected void addSupportedAction(Action action){
        supportedActions.add(action);
    }
    
    protected boolean isSupportedAction(Action action){
        return supportedActions.contains(action);
    }
    
    public abstract List<Agent> getAgents();
    
    public abstract void executeAction( Agent agent, Action action )throws ActionException;
}