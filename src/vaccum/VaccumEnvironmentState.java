/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccum;

import agent.generic.Agent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kuri
 */
public class VaccumEnvironmentState {
    
    private Map<Agent, Integer> agentLocations;
    
    public VaccumEnvironmentState(){
        agentLocations = new HashMap<>();
    }
    
    public void setAgentLocationIndex(Agent agent, int locationIndex){
        agentLocations.put(agent, locationIndex);
    }
    
    public Integer getAgentLocationIndex(Agent agent){
        return agentLocations.get(agent);
    }
    
    public List<Agent> getAgents(){
        List<Agent> agents = new LinkedList<>();
        Iterator it = agentLocations.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Agent, Integer> pair = (Map.Entry)it.next();
            agents.add(pair.getKey());
        }
        
        return agents;
    }
    
    
}
