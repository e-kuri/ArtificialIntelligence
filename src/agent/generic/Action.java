/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agent.generic;

import agent.exception.ActionException;

/**
 *
 * @author kuri
 */
public interface Action {
    void execute(Agent agent) throws ActionException;
}
