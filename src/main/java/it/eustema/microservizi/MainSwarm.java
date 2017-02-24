package it.eustema.microservizi;

import org.wildfly.swarm.Swarm;

public class MainSwarm {

	public static void main(String[] args) throws Exception {
		Swarm swarm = new Swarm();
		swarm.start();
		swarm.deploy();
	}

}
