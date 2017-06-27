/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccum;

import agent.generic.Action;
import agent.generic.Agent;
import agent.generic.Environment;
import agent.generic.ActionException;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author kuri
 */
public class VaccumEnvironment extends Environment{
    
    private final Location[] locations;
    private VaccumEnvironmentState state;
    private Random random = new Random();
    
    public final Action moveRight = new Action() {
        @Override
        public void execute(Agent agent) throws ActionException{
            Integer locationIndex = state.getAgentLocationIndex(agent);
            if(locationIndex == locations.length - 1){
                throw new ActionException("Can't move to right, there are no locations to the right.");
            }
            VaccumEnvironment.this.addToPerformanceMeasure(agent, -1);
            locationIndex++;
        }
    };
    
    public final Action moveLeft = new Action() {
        @Override
        public void execute(Agent agent) throws ActionException {
            Integer locationIndex = state.getAgentLocationIndex(agent);
            if(locationIndex == 0){
                throw new ActionException("Can't move to left, there are no locations to the left of the agent");
            }
            VaccumEnvironment.this.addToPerformanceMeasure(agent, -1);
            locationIndex--;
        }
    };
    
    public final Action suck = new Action() {
        @Override
        public void execute(Agent agent) {
            Location location = locations[state.getAgentLocationIndex(agent)];
            if(location.isDirty()){
                location.clean();
                VaccumEnvironment.this.addToPerformanceMeasure(agent, 10);
            }else{
                VaccumEnvironment.this.addToPerformanceMeasure(agent, -1);
            }
        }
    };
    
    public VaccumEnvironment(int numberOfLocations){
        locations = new Location[numberOfLocations];
        for(int i=0; i<numberOfLocations; i++){
            locations[i] = new Location(getRandomBoolean());
        }
        state = new VaccumEnvironmentState();
        
        addSupportedAction(moveLeft);
        addSupportedAction(moveRight);
        addSupportedAction(suck);
    }
    
    private boolean getRandomBoolean(){
        return Math.random() < 0.5;
    }

    @Override
    public void executeAction(Agent agent, Action action) throws ActionException{
        if(!isSupportedAction(action)){
            throw new ActionException("Action not supported");
        }
        action.execute(agent);
    }

    public void addAgent(Agent agent, Integer locationIndex){
        state.setAgentLocationIndex(agent, locationIndex);
    }
    
    public void addAgentToRandomLocation(Agent agent){
        int locationIndex = random.nextInt(locations.length);
        addAgent(agent, locationIndex);
    }
    
    @Override
    public List<Agent> getAgents() {
        return state.getAgents();
    }
    
    public class Location{
        
        private boolean dirty;
        
        public Location(boolean dirty){
            this.dirty = dirty;
        }
        
        public boolean isDirty(){
            return this.dirty;
        }
        
        public void clean(){
            this.dirty = false;
        }
    }
    
    
    
}
