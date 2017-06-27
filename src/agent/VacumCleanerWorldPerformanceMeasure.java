/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agent;

/**
 *
 * @author kuri
 * 
 * The performance measure awards one point for each clean square at each time step,
 * over a lifetime of 1000 steps.
 * 
 * The geography of the environment is known a priori, but the dirt distribution
 * and the initial location of the agent are not. Clean squares stay clean and sucking
 * cleans the square. The left and right actions move the agent left and right except
 * when this would take the agent outside the environment, in which case the agent remains
 * where it is.
 * 
 * The only available actions are left, right, and suck.
 * 
 * The agent correctly perceives its location and whether that location contains dirt.
 * 
 */
public class VacumCleanerWorldPerformanceMeasure {
    
    public int measurePerformance(){return 1;}
    
}
