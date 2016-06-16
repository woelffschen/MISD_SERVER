package misdTests;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public abstract class DataSet {

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "test.war")
				.addPackages(true, "dao", "dto", "entities", "onlineService", "misdTests")
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");

	}
}