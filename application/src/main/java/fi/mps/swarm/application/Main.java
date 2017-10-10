package fi.mps.swarm.application;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

import fi.mps.swarm.application.controller.HelloController;

/**
 * https://github.com/emag-wildfly-swarm-sandbox/wildfly-swarm-jaxrs-jsp-demo
 * 
 * @author msopanen
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		Swarm swarm = new Swarm();

		JAXRSArchive archive = ShrinkWrap.create(JAXRSArchive.class);

		archive.addPackage(HelloController.class.getPackage());
		archive.addAsWebResource(new ClassLoaderAsset("index.html", Main.class.getClassLoader()), "index.html");
		archive.staticContent();

		swarm.start(archive);
	}
}
